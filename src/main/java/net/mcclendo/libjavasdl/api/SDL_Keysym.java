package net.mcclendo.libjavasdl.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.jna.Structure;

public final class SDL_Keysym extends Structure {

    public int scancode;
    public int sym;
    public short mod;
    public int unused;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList(this.getClass().getDeclaredFields()).stream()
                .map(f -> f.getName())
                .collect(Collectors.toList());
    }
}
