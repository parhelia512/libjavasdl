# libjavasdl
libjavasdl is a mapping of SDL2 APIs to Java. There are two goals for libjavasdl:
* Provide as direct of a mapping of SDL APIs as possible.
* Provide as performant of a mapping as possible.

Because of these goals there is a lot of room for Java niceties (Enums, encapulation, autoclosable, type-safety, etc.).
These will be applied at some time int he future by wrapping the raw API.

## Not Implemented
* SDL_assert.h was not implemented.
* SDL_SysWMinfo.h was not implemented.
* Threads (SDL_thread.h, SDL_mutex.h, SDL_atomic.h) was not implemented.
* Platform and CPU Information (SDL_platform.h, SDL_cpuinfo.h, SDL_endian.h, SDL_bits.h)