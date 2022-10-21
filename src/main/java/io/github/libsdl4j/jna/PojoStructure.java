package io.github.libsdl4j.jna;

import java.util.List;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;

public interface PojoStructure {

    long size();

    void write(Pointer buffer, long offset);

    static Memory writeListToNativeMemory(List<? extends PojoStructure> objects) {
        long structSize = objects.get(0).size();
        Memory buffer = new Memory(objects.size() * structSize);
        long offset = 0;
        for (PojoStructure obj : objects) {
            obj.write(buffer, offset);
            offset += structSize;
        }
        return buffer;
    }
}
