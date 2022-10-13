package io.github.libsdl4j.api.stdinc;

public final class AllocationFunctions {

    private SDL_malloc_func mallocFunction;
    private SDL_calloc_func callocFunction;
    private SDL_realloc_func reallocFunction;
    private SDL_free_func freeFunction;

    public AllocationFunctions(SDL_malloc_func mallocFunction, SDL_calloc_func callocFunction, SDL_realloc_func reallocFunction, SDL_free_func freeFunction) {
        this.mallocFunction = mallocFunction;
        this.callocFunction = callocFunction;
        this.reallocFunction = reallocFunction;
        this.freeFunction = freeFunction;
    }

    public SDL_malloc_func getMallocFunction() {
        return mallocFunction;
    }

    public SDL_calloc_func getCallocFunction() {
        return callocFunction;
    }

    public SDL_realloc_func getReallocFunction() {
        return reallocFunction;
    }

    public SDL_free_func getFreeFunction() {
        return freeFunction;
    }
}
