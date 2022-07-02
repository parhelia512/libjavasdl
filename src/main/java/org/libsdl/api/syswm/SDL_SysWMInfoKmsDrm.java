package org.libsdl.api.syswm;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.libsdl.jna.JnaStructure;

@Structure.FieldOrder({
        "dev_index",
        "drm_fd",
        "gbm_dev"
})
public class SDL_SysWMInfoKmsDrm extends JnaStructure {

    /** Device index (ex: the X in /dev/dri/cardX) */
    public int dev_index;

    /** DRM FD (unavailable on Vulkan windows) */
    public int drm_fd;

    /** GBM device (unavailable on Vulkan windows) */
    public Pointer gbm_dev;
}
