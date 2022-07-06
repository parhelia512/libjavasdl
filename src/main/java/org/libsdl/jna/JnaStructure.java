package org.libsdl.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.TypeMapper;

/**
 * The same class as a {@link Structure}, just exposes {@link #useMemory(Pointer)}
 */
public class JnaStructure extends Structure {

    public JnaStructure() {
    }

    public JnaStructure(TypeMapper mapper) {
        super(mapper);
    }

    public JnaStructure(int alignType) {
        super(alignType);
    }

    public JnaStructure(int alignType, TypeMapper mapper) {
        super(alignType, mapper);
    }

    public JnaStructure(Pointer p) {
        super(p);
    }

    public JnaStructure(Pointer p, int alignType) {
        super(p, alignType);
    }

    public JnaStructure(Pointer p, int alignType, TypeMapper mapper) {
        super(p, alignType, mapper);
    }
}
