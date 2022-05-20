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

    /**
     * Set the memory used by this structure.  This method is used to
     * indicate the given structure is nested within another or otherwise
     * overlaid on some other memory block and thus does not own its own
     * memory.
     *
     * @param m Memory to with which to back this {@link Structure}.
     */
    @Override
    public void useMemory(Pointer m) {
        super.useMemory(m);
    }

    /**
     * Set the memory used by this structure.  This method is used to
     * indicate the given structure is based on natively-allocated data,
     * nested within another, or otherwise overlaid on existing memory and
     * thus does not own its own memory allocation.
     *
     * @param m      Base memory to use to back this structure.
     * @param offset offset into provided memory where structure mapping
     */
    @Override
    public void useMemory(Pointer m, int offset) {
        super.useMemory(m, offset);
    }
}
