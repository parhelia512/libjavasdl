LibSDL4J
========

LibSDL4J is a mapping of SDL2 APIs to Java. There are two goals for LibSDL4J:

* Provide as direct of a mapping of SDL APIs as possible.<br/>
  It should be easy to just 1:1 translate C-style source code to Java.
* Provide reasonably performant mapping.

Because of these goals, there is a lot of room for Java niceties (enums, encapsulation, AutoClosable, type-safety, exceptions etc.)
which are intentionally avoided. These can be applied by wrapping the raw API,
but it is outside the scope of this project.



## SDL2.Dll / libSDL2.so loading

The Java bindings will lookup the SDL2 dynamic library in the following locations
in order of precedence (algorithm built into `NativeLibrary.loadLibrary()`):
 
1. Any custom paths set by calling: `NativeLibrary.addSearchPath("SDL2", CUSTOM_PATHS)`.  
2. Java Web Start (if used).
3. Any custom paths set to `jna.library.path` system property 
   (`System.setProperty("jna.library.path", "CUSTOM_PATHS");` in the Java code
   or `-Djna.library.path=CUSTOM_PATHS` Java command line parameter).
4. Any OS standard library paths (`/usr/lib/`, `LD_LIBRARY_PATH` etc.)
   and custom paths set to `jna.platform.library.path` system property.
5. Embedded DLL/so in the `libsdl4j.jar` file itself.
   There are embedded libraries for Windows (x86, x86-64) and
   Linux (x86, x86-64, armhf, aarch64).

If you find it difficult to make it working, the process of searching for the dll/so library has debug logs:

| Logger                      | Minimum threshold level     |
|-----------------------------|-----------------------------|
| `com.sun.jna.NativeLibrary` | `DEBUG` / `FINE`            |

Note: If you set system property `jna.debug_load` to `true`,
the minimum threshold level will become `INFO`, and thus will likely be logged by default to the console.

              
        
### Embedded SDL2 libraries for Windows and Linux

Windows DLLs are the official ones from SDL2 distribution.

Linux .so are compiled on Ubuntu 2016 LTS (to use reasonably old glibc)
for x86 and x86-64
and on Raspberry Pi 4 for armhf and aarch64 (Raspberry Pi OS, version *buster*).
The compilation went on a newly installed and updated OS
(`sudo apt-get update`, `sudo apt-get upgrade`)
with all recommended build dependencies installed
(see SDL2's [README-linux.md](https://github.com/libsdl-org/SDL/blob/main/docs/README-linux.md#user-content-build-dependencies))
and with default `./configure` (<https://wiki.libsdl.org/Installation#cb1>). 

On Linux, the embedded library might be missing support for a specific library or framework you have on your computer,
so it is advised to have the libSDL2 installed as a separate package. Watch out for the library version, though.
The embedded libraries should be fine in most cases.

On macOS, it is recommended to distribute the libSDL2 library
as a framework bundled in your `.app` package.

                   

## What Is Not Implemented by LibSDL4J

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
