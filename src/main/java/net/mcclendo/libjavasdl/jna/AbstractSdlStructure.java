package net.mcclendo.libjavasdl.jna;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.jna.Structure;

public abstract class AbstractSdlStructure extends Structure {

    @Override
    protected final List<String> getFieldOrder() {
        return Arrays.asList(this.getClass().getDeclaredFields()).stream()
                .filter(f -> !Modifier.isStatic(f.getModifiers()))
                .map(f -> f.getName())
                .collect(Collectors.toList());
    }
}
