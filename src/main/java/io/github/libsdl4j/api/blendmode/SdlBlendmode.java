package io.github.libsdl4j.api.blendmode;

import io.github.libsdl4j.api.render.SDL_Renderer;
import io.github.libsdl4j.api.render.SDL_Texture;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Definitions from file SDL_blendmode.h
 *
 * <p>Header file declaring the SDL_BlendMode enumeration</p>
 */
public final class SdlBlendmode {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlBlendmode.class);
    }

    private SdlBlendmode() {
    }

    /**
     * Compose a custom blend mode for renderers.
     *
     * <p>The functions SDL_SetRenderDrawBlendMode and SDL_SetTextureBlendMode accept
     * the SDL_BlendMode returned by this function if the renderer supports it.</p>
     *
     * <p>A blend mode controls how the pixels from a drawing operation (source) get
     * combined with the pixels from the render target (destination). First, the
     * components of the source and destination pixels get multiplied with their
     * blend factors. Then, the blend operation takes the two products and
     * calculates the result that will get stored in the render target.</p>
     *
     * <p>Expressed in pseudocode, it would look like this:</p>
     *
     * <pre>
     * dstRGB = colorOperation(srcRGB * srcColorFactor, dstRGB * dstColorFactor);
     * dstA = alphaOperation(srcA * srcAlphaFactor, dstA * dstAlphaFactor);
     * </pre>
     *
     * <p>Where the functions {@code colorOperation(src, dst)} and `alphaOperation(src,
     * dst)` can return one of the following:</p>
     *
     * <ul>
     *     <li>{@code src + dst}</li>
     *     <li>{@code src - dst}</li>
     *     <li>{@code dst - src}</li>
     *     <li>{@code min(src, dst)}</li>
     *     <li>{@code max(src, dst)}</li>
     * </ul>
     *
     * <p>The red, green, and blue components are always multiplied with the first,
     * second, and third components of the SDL_BlendFactor, respectively. The
     * fourth component is not used.</p>
     *
     * <p>The alpha component is always multiplied with the fourth component of the
     * SDL_BlendFactor. The other components are not used in the alpha
     * calculation.</p>
     *
     * <p>Support for these blend modes varies for each renderer. To check if a
     * specific SDL_BlendMode is supported, create a renderer and pass it to
     * either SDL_SetRenderDrawBlendMode or SDL_SetTextureBlendMode. They will
     * return with an error if the blend mode is not supported.</p>
     *
     * <p>This list describes the support of custom blend modes for each renderer in
     * SDL 2.0.6. All renderers support the four blend modes listed in the
     * SDL_BlendMode enumeration.</p>
     *
     * <ul>
     *     <li><b>direct3d</b>: Supports all operations with all factors. However, some
     *     factors produce unexpected results with {@code SDL_BLENDOPERATION_MINIMUM} and
     *     {@code SDL_BLENDOPERATION_MAXIMUM}.</li>
     *     <li><b>direct3d11</b>: Same as Direct3D 9.</li>
     *     <li><b>opengl</b>: Supports the {@code SDL_BLENDOPERATION_ADD} operation with all
     *     factors. OpenGL versions 1.1, 1.2, and 1.3 do not work correctly with SDL
     *     2.0.6.</li>
     *     <li><b>opengles</b>: Supports the {@code SDL_BLENDOPERATION_ADD} operation with all
     *     factors. Color and alpha factors need to be the same. OpenGL ES 1
     *     implementation specific: May also support {@code SDL_BLENDOPERATION_SUBTRACT}
     *     and {@code SDL_BLENDOPERATION_REV_SUBTRACT}. May support color and alpha
     *     operations being different from each other. May support color and alpha
     *     factors being different from each other.</li>
     *     <li><b>opengles2</b>: Supports the {@code SDL_BLENDOPERATION_ADD},
     *     {@code SDL_BLENDOPERATION_SUBTRACT}, {@code SDL_BLENDOPERATION_REV_SUBTRACT}
     *     operations with all factors.</li>
     *     <li><b>psp</b>: No custom blend mode support.</li>
     *     <li><b>software</b>: No custom blend mode support.</li>
     * </ul>
     *
     * <p>Some renderers do not provide an alpha component for the default render
     * target. The {@code SDL_BLENDFACTOR_DST_ALPHA} and
     * {@code SDL_BLENDFACTOR_ONE_MINUS_DST_ALPHA} factors do not have an effect in this
     * case.</p>
     *
     * @param srcColorFactor the SDL_BlendFactor applied to the red, green, and
     *                       blue components of the source pixels
     * @param dstColorFactor the SDL_BlendFactor applied to the red, green, and
     *                       blue components of the destination pixels
     * @param colorOperation the SDL_BlendOperation used to combine the red,
     *                       green, and blue components of the source and
     *                       destination pixels
     * @param srcAlphaFactor the SDL_BlendFactor applied to the alpha component of
     *                       the source pixels
     * @param dstAlphaFactor the SDL_BlendFactor applied to the alpha component of
     *                       the destination pixels
     * @param alphaOperation the SDL_BlendOperation used to combine the alpha
     *                       component of the source and destination pixels
     * @return an SDL_BlendMode that represents the chosen factors and
     * operations.
     * @see io.github.libsdl4j.api.render.SdlRender#SDL_SetRenderDrawBlendMode(SDL_Renderer, int)
     * @see io.github.libsdl4j.api.render.SdlRender#SDL_GetRenderDrawBlendMode(SDL_Renderer, SDL_BlendMode.Ref)
     * @see io.github.libsdl4j.api.render.SdlRender#SDL_SetTextureBlendMode(SDL_Texture, int)
     * @see io.github.libsdl4j.api.render.SdlRender#SDL_GetTextureBlendMode(SDL_Texture, SDL_BlendMode.Ref)
     * @since This function is available since SDL 2.0.6.
     */
    @MagicConstant(valuesFromClass = SDL_BlendMode.class)
    public static native int SDL_ComposeCustomBlendMode(
            @MagicConstant(valuesFromClass = SDL_BlendFactor.class) int srcColorFactor,
            @MagicConstant(valuesFromClass = SDL_BlendFactor.class) int dstColorFactor,
            @MagicConstant(valuesFromClass = SDL_BlendOperation.class) int colorOperation,
            @MagicConstant(valuesFromClass = SDL_BlendFactor.class) int srcAlphaFactor,
            @MagicConstant(valuesFromClass = SDL_BlendFactor.class) int dstAlphaFactor,
            @MagicConstant(valuesFromClass = SDL_BlendOperation.class) int alphaOperation);
}
