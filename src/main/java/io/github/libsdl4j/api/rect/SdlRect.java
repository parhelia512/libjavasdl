package io.github.libsdl4j.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.jna.ContiguousArrayList;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

import static io.github.libsdl4j.api.stdinc.SdlStdincConst.SDL_FLT_EPSILON;

/**
 * Definitions from file SDL_rect.h
 *
 * <p>Header file for SDL_rect definition and management functions.</p>
 */
public final class SdlRect {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlRect.class);
    }

    private SdlRect() {
    }

    /**
     * Returns true if point resides inside a rectangle.
     */
    public static boolean SDL_PointInRect(
            SDL_Point p,
            SDL_Rect r) {
        return ((p.x >= r.x) && (p.x < (r.x + r.w))
                && (p.y >= r.y) && (p.y < (r.y + r.h)));
    }

    /**
     * Returns true if the rectangle has no area.
     */
    public static boolean SDL_RectEmpty(
            SDL_Rect r) {
        return r == null || r.w <= 0 || r.h <= 0;
    }

    /**
     * Returns true if the two rectangles are equal.
     */
    public static boolean SDL_RectEquals(
            SDL_Rect a,
            SDL_Rect b) {
        return (a != null && b != null && (a.x == b.x) && (a.y == b.y)
                && (a.w == b.w) && (a.h == b.h));
    }

    /**
     * Determine whether two rectangles intersect.
     *
     * <p>If either pointer is null the function will return false.</p>
     *
     * @param a an SDL_Rect structure representing the first rectangle
     * @param b an SDL_Rect structure representing the second rectangle
     * @return true if there is an intersection, false otherwise.
     * @see #SDL_IntersectRect(SDL_Rect, SDL_Rect, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_HasIntersection(
            SDL_Rect a,
            SDL_Rect b);

    /**
     * Calculate the intersection of two rectangles.
     *
     * <p>If {@code result} is null then this function will return false.</p>
     *
     * @param a      an SDL_Rect structure representing the first rectangle
     * @param b      an SDL_Rect structure representing the second rectangle
     * @param result an SDL_Rect structure filled in with the intersection of
     *               rectangles {@code a} and {@code b}
     * @return true if there is an intersection, false otherwise.
     * @see #SDL_HasIntersection(SDL_Rect, SDL_Rect)
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IntersectRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result);

    /**
     * Calculate the union of two rectangles.
     *
     * @param a      an SDL_Rect structure representing the first rectangle
     * @param b      an SDL_Rect structure representing the second rectangle
     * @param result an SDL_Rect structure filled in with the union of rectangles
     *               {@code a} and {@code b}
     * @since This function is available since SDL 2.0.0.
     */
    public static native void SDL_UnionRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result);

    /**
     * Calculate a minimal rectangle enclosing a set of points.
     *
     * <p>If {@code clip} is not null then only points inside of the clipping rectangle are
     * considered.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer it over the other.</p>
     *
     * @param points a {@link ContiguousArrayList} of SDL_Point structures representing points to be
     *               enclosed
     * @param clip   an SDL_Rect used for clipping or null to enclose all points
     * @param result an SDL_Rect structure filled in with the minimal enclosing
     *               rectangle
     * @return true if any points were enclosed or false if all the
     * points were outside of the clipping rectangle.
     * @since This function is available since SDL 2.0.0.
     */
    public static boolean SDL_EnclosePoints(
            ContiguousArrayList<SDL_Point> points,
            SDL_Rect clip,
            SDL_Rect result) {
        if (points.size() == 0) {
            return true;
        }
        return SDL_EnclosePoints(points.autoWriteAndGetPointer(), points.size(), clip, result);
    }

    /**
     * Calculate a minimal rectangle enclosing a set of points.
     *
     * <p>If {@code clip} is not null then only points inside of the clipping rectangle are
     * considered.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_EnclosePoints(ContiguousArrayList, SDL_Rect, SDL_Rect)}.</p>
     *
     * @param points an array of SDL_Point structures representing points to be
     *               enclosed
     * @param count  the number of structures in the {@code points} array
     * @param clip   an SDL_Rect used for clipping or null to enclose all points
     * @param result an SDL_Rect structure filled in with the minimal enclosing
     *               rectangle
     * @return true if any points were enclosed or false if all the
     * points were outside of the clipping rectangle.
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_EnclosePoints(
            Pointer points,
            int count,
            SDL_Rect clip,
            SDL_Rect result);

    /**
     * Calculate the intersection of a rectangle and line segment.
     *
     * <p>This function is used to clip a line segment to a rectangle. A line segment
     * contained entirely within the rectangle or that does not intersect will
     * remain unchanged. A line segment that crosses the rectangle at either or
     * both ends will be clipped to the boundary of the rectangle and the new
     * coordinates saved in {@code x1}, {@code y1}, {@code x2}, and/or {@code y2} as necessary.</p>
     *
     * @param rect an SDL_Rect structure representing the rectangle to intersect
     * @param x1   a pointer to the starting X-coordinate of the line
     * @param y1   a pointer to the starting Y-coordinate of the line
     * @param x2   a pointer to the ending X-coordinate of the line
     * @param y2   a pointer to the ending Y-coordinate of the line
     * @return true if there is an intersection, false otherwise.
     * @since This function is available since SDL 2.0.0.
     */
    public static native boolean SDL_IntersectRectAndLine(
            SDL_Rect rect,
            IntByReference x1,
            IntByReference y1,
            IntByReference x2,
            IntByReference y2);

    /**
     * Returns true if point resides inside a rectangle.
     */
    public static boolean SDL_PointInFRect(
            SDL_FPoint p,
            SDL_FRect r) {
        return (p.x >= r.x) && (p.x < (r.x + r.w)) &&
                (p.y >= r.y) && (p.y < (r.y + r.h));
    }

    /**
     * Returns true if the rectangle has no area.
     */
    public static boolean SDL_FRectEmpty(
            SDL_FRect r) {
        return (r == null) || (r.w <= 0.0f) || (r.h <= 0.0f);
    }

    /**
     * Returns true if the two rectangles are equal, within some given epsilon.
     *
     * @since This function is available since SDL 2.0.22.
     */
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

    /**
     * Returns true if the two rectangles are equal, using a default epsilon.
     *
     * @since This function is available since SDL 2.0.22.
     */
    public static boolean SDL_FRectEquals(
            SDL_FRect a,
            SDL_FRect b) {
        return SDL_FRectEqualsEpsilon(a, b, SDL_FLT_EPSILON);
    }

    /**
     * Determine whether two rectangles intersect with float precision.
     *
     * <p>If either pointer is null the function will return false.</p>
     *
     * @param a an SDL_FRect structure representing the first rectangle
     * @param b an SDL_FRect structure representing the second rectangle
     * @return true if there is an intersection, false otherwise.
     * @see #SDL_IntersectRect(SDL_Rect, SDL_Rect, SDL_Rect)
     * @since This function is available since SDL 2.0.22.
     */
    public static native boolean SDL_HasIntersectionF(
            SDL_FRect a,
            SDL_FRect b);

    /**
     * Calculate the intersection of two rectangles with float precision.
     *
     * <p>If {@code result} is null then this function will return false.</p>
     *
     * @param a      an SDL_FRect structure representing the first rectangle
     * @param b      an SDL_FRect structure representing the second rectangle
     * @param result an SDL_FRect structure filled in with the intersection of
     *               rectangles {@code a} and {@code b}
     * @return true if there is an intersection, false otherwise.
     * @see #SDL_HasIntersectionF(SDL_FRect, SDL_FRect)
     * @since This function is available since SDL 2.0.22.
     */
    public static native boolean SDL_IntersectFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result);

    /**
     * Calculate the union of two rectangles with float precision.
     *
     * @param a      an SDL_FRect structure representing the first rectangle
     * @param b      an SDL_FRect structure representing the second rectangle
     * @param result an SDL_FRect structure filled in with the union of rectangles
     *               {@code a} and {@code b}
     * @since This function is available since SDL 2.0.22.
     */
    public static native void SDL_UnionFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result);

    /**
     * Calculate a minimal rectangle enclosing a set of points with float
     * precision.
     *
     * <p>If {@code clip} is not null then only points inside of the clipping rectangle are
     * considered.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer it over the other.</p>
     *
     * @param points a {@link ContiguousArrayList} of SDL_FPoint structures representing points to be
     *               enclosed
     * @param clip   an SDL_FRect used for clipping or null to enclose all points
     * @param result an SDL_FRect structure filled in with the minimal enclosing
     *               rectangle
     * @return true if any points were enclosed or false if all the
     * points were outside of the clipping rectangle.
     * @since This function is available since SDL 2.0.22.
     */
    public static boolean SDL_EncloseFPoints(
            ContiguousArrayList<SDL_FPoint> points,
            SDL_FRect clip,
            SDL_FRect result) {
        if (points.size() == 0) {
            return true;
        }
        return SDL_EncloseFPoints(points.autoWriteAndGetPointer(), points.size(), clip, result);
    }

    /**
     * Calculate a minimal rectangle enclosing a set of points with float
     * precision.
     *
     * <p>If {@code clip} is not null then only points inside of the clipping rectangle are
     * considered.</p>
     *
     * <p>This is a raw C-style version of the function. Prefer Java-style version
     * {@link #SDL_EncloseFPoints(ContiguousArrayList, SDL_FRect, SDL_FRect)}.</p>
     *
     * @param points an array of SDL_FPoint structures representing points to be
     *               enclosed
     * @param count  the number of structures in the {@code points} array
     * @param clip   an SDL_FRect used for clipping or null to enclose all points
     * @param result an SDL_FRect structure filled in with the minimal enclosing
     *               rectangle
     * @return true if any points were enclosed or false if all the
     * points were outside of the clipping rectangle.
     * @since This function is available since SDL 2.0.22.
     */
    public static native boolean SDL_EncloseFPoints(
            Pointer points,
            int count,
            SDL_FRect clip,
            SDL_FRect result);

    /**
     * Calculate the intersection of a rectangle and line segment with float
     * precision.
     *
     * <p>This function is used to clip a line segment to a rectangle. A line segment
     * contained entirely within the rectangle or that does not intersect will
     * remain unchanged. A line segment that crosses the rectangle at either or
     * both ends will be clipped to the boundary of the rectangle and the new
     * coordinates saved in {@code x1}, {@code y1}, {@code x2}, and/or {@code y2} as necessary.</p>
     *
     * @param rect an SDL_FRect structure representing the rectangle to intersect
     * @param x1   a pointer to the starting X-coordinate of the line
     * @param y1   a pointer to the starting Y-coordinate of the line
     * @param x2   a pointer to the ending X-coordinate of the line
     * @param y2   a pointer to the ending Y-coordinate of the line
     * @return true if there is an intersection, false otherwise.
     * @since This function is available since SDL 2.0.22.
     */
    public static native boolean SDL_IntersectFRectAndLine(
            SDL_FRect rect,
            FloatByReference x1,
            FloatByReference y1,
            FloatByReference x2,
            FloatByReference y2);
}
