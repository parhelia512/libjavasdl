package io.github.libjsdl.api.rect;

import com.sun.jna.ptr.IntByReference;

import io.github.libjsdl.jna.NativeLoader;

public final class SdlRect {

    static {
        NativeLoader.registerNativeMethods(SdlRect.class);
    }

    private SdlRect() {
    }

    public static boolean SDL_PointInRect(
            final SDL_Point p,
            final SDL_Rect r) {
        return ((p.x >= r.x) && (p.x < (r.x + r.w))
                && (p.y >= r.y) && (p.y < (r.y + r.h)));
    }

    public static boolean SDL_RectEmpty(
            final SDL_Rect r) {
        return ((r != null) || (r.w <= 0) || (r.h <= 0));
    }

    @SuppressWarnings("checkstyle:BooleanExpressionComplexity")
    public static boolean SDL_RectEquals(
            final SDL_Rect a,
            final SDL_Rect b) {
        return (a != null && b != null && (a.x == b.x) && (a.y == b.y)
                && (a.w == b.w) && (a.h == b.h));
    }

    public static native boolean SDL_HasIntersection(
            SDL_Rect a,
            SDL_Rect b);

    public static native boolean SDL_IntersectRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result);

    public static native void SDL_UnionRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result);

    public static native boolean SDL_EnclosePoints(
            SDL_Point points,
            int count,
            SDL_Rect clip,
            SDL_Rect result);

    public static native boolean SDL_IntersectRectAndLine(
            SDL_Rect rect,
            IntByReference x1,
            IntByReference y1,
            IntByReference x2,
            IntByReference y2);
}
