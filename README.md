LibJSDL
=======

LibJSDL is a mapping of SDL2 APIs to Java. There are two goals for LibJSDL:
* Provide as direct of a mapping of SDL APIs as possible.
* Provide as performant of a mapping as possible.

Because of these goals, there is a lot of room for Java niceties (enums, encapsulation, AutoClosable, type-safety, etc.) which are purposefully avoided.
These can be applied by wrapping the raw API but it is not the aim of this project.

## Not Implemented
* SDL_assert.h was not implemented.
* SDL_SysWMinfo.h was not implemented.
* Threads (SDL_thread.h, SDL_mutex.h, SDL_atomic.h) was not implemented.
* Platform and CPU Information (SDL_platform.h, SDL_cpuinfo.h, SDL_endian.h, SDL_bits.h)
*