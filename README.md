LibSDL4J
========

LibSDL4J is a mapping of SDL2 APIs to Java. There are two goals for LibSDL4J:

* Provide as direct of a mapping of SDL APIs as possible.<br/>
  It should be easy to just 1:1 translate C-style source code to Java.
* Provide reasonably performant mapping.

Because of these goals, there is a lot of room for Java niceties (enums, encapsulation, AutoClosable, type-safety, exceptions etc.)
which are intentionally avoided. These can be applied by wrapping the raw API,
but it is outside the scope of this project.



## Not Implemented

Minor things that make little to no sense in the Java world were omitted from the Java bindings.
It's still possible to add those headers if someone contributes it to the project.
Amongst the omitted things are:

* **SDL_thread.h**, **SDL_mutex.h**, **SDL_atomic.h**
  * Thread functions could be supported but Java has plenty of that already.
    If there was an interest in these, file a feature request.
* **SDL_test_\*.h**, **SDL_assert.h**
  * Testing facilities are low priority.
    If there was an interest in these, file a feature request.
* **SDL_loadso.h**
  * Loading another dynamically-linked libraries must be done in Java specific way.
* **SDL_stdinc.h**
  * Most C-style functions were omitted.
  * However, memory management `malloc()`/`free()` is covered.
* **SDL_platform.h**.
  * Platform specific functions related to the platform specific APIs.
  * It could be done by splitting the functionality into a separate
    class for each OS, but many times platform specific
    header files and libraries would also need to be loaded,
    so it was left out of the scope of the project.
* **SDL_opengl_\*.h**, **SDL_opengles_\*.h**, **SDL_egl.h** 



## Implementation details

C structs are implemented as JNA Structures.
If they are passed as arguments to the native functions or return types from native functions,
they will be passed-by-reference.
If they are a part of another struct, they are passed-by-value (exploded in the outer structure).
Unless they implement Structure.ByReference.
In rare cases, the structure is passed by value even to the native function.
In that case, the structure implements Structure.ByValue.

More documentation in the [JNA docs](https://github.com/java-native-access/jna/blob/master/www/StructuresAndUnions.md).
