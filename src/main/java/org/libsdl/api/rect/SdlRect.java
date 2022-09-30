package org.libsdl.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import org.libsdl.jna.ContiguousArrayList;
import org.libsdl.jna.SdlNativeLibraryLoader;

import static org.libsdl.api.stdinc.SdlStdincConst.SDL_FLT_EPSILON;

public final class SdlRect {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlRect.class);
    }

    private SdlRect() {
    }

    public static boolean SDL_PointInRect(
            SDL_Point p,
            SDL_Rect r) {
        return ((p.x >= r.x) && (p.x < (r.x + r.w))
                && (p.y >= r.y) && (p.y < (r.y + r.h)));
    }

    public static boolean SDL_RectEmpty(
            SDL_Rect r) {
        return r == null || r.w <= 0 || r.h <= 0;
    }

    public static boolean SDL_RectEquals(
            SDL_Rect a,
            SDL_Rect b) {
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

    public static boolean SDL_EnclosePoints(
            ContiguousArrayList<SDL_Point> points,
            SDL_Rect clip,
            SDL_Rect result) {
        if (points.size() == 0) {
            return true;
        }
        return SDL_EnclosePoints(points.autoWriteAndGetPointer(), points.size(), clip, result);
    }

    public static native boolean SDL_EnclosePoints(
            Pointer points,
            int count,
            SDL_Rect clip,
            SDL_Rect result);

    public static native boolean SDL_IntersectRectAndLine(
            SDL_Rect rect,
            IntByReference x1,
            IntByReference y1,
            IntByReference x2,
            IntByReference y2);

    public static boolean SDL_PointInFRect(
            SDL_FPoint p,
            SDL_FRect r) {
        return (p.x >= r.x) && (p.x < (r.x + r.w)) &&
                (p.y >= r.y) && (p.y < (r.y + r.h));
    }

    public static boolean SDL_FRectEmpty(
            SDL_FRect r) {
        return (r == null) || (r.w <= 0.0f) || (r.h <= 0.0f);
    }

    public static boolean SDL_FRectEqualsEpsilon(
            SDL_FRect a,
            SDL_FRect b,
            float epsilon) {
        return a != null && b != null && ((a == b) ||
                ((Math.abs(a.x - b.x) <= epsilon) &&
                        (Math.abs(a.y - b.y) <= epsilon) &&
                        (Math.abs(a.w - b.w) <= epsilon) &&
                        (Math.abs(a.h - b.h) <= epsilon)));
    }

    public static boolean SDL_FRectEquals(
            SDL_FRect a,
            SDL_FRect b) {
        return SDL_FRectEqualsEpsilon(a, b, SDL_FLT_EPSILON);
    }

    public static native boolean SDL_HasIntersectionF(
            SDL_FRect a,
            SDL_FRect b);

    public static native boolean SDL_IntersectFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result);

    public static native void SDL_UnionFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result);

    public static boolean SDL_EncloseFPoints(
            ContiguousArrayList<SDL_FPoint> points,
            SDL_FRect clip,
            SDL_FRect result) {
        if (points.size() == 0) {
            return true;
        }
        return SDL_EncloseFPoints(points.autoWriteAndGetPointer(), points.size(), clip, result);
    }

    public static native boolean SDL_EncloseFPoints(
            Pointer points,
            int count,
            SDL_FRect clip,
            SDL_FRect result);

    public static native boolean SDL_IntersectFRectAndLine(
            SDL_FRect rect,
            FloatByReference x1,
            FloatByReference y1,
            FloatByReference x2,
            FloatByReference y2);
}
