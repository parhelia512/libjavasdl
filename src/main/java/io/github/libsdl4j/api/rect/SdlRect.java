package io.github.libsdl4j.api.rect;

import java.util.Iterator;
import java.util.List;
import io.github.libsdl4j.jna.ContiguousArrayList;
import io.github.libsdl4j.jna.FloatRef;
import io.github.libsdl4j.jna.IntRef;
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
        return (p.x >= r.x) && (p.x < (r.x + r.w))
                && (p.y >= r.y) && (p.y < (r.y + r.h));
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
    public static boolean SDL_HasIntersection(
            SDL_Rect a,
            SDL_Rect b) {
        int aMin, aMax, bMin, bMax;

        if (SDL_RectEmpty(a) || SDL_RectEmpty(b)) {
            return false;  /* Special cases for empty rects */
        }

        /* Horizontal intersection */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin > aMin) {
            aMin = bMin;
        }
        if (bMax < aMax) {
            aMax = bMax;
        }
        if (aMax <= aMin) {
            return false;
        }
        /* Vertical intersection */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin > aMin) {
            aMin = bMin;
        }
        if (bMax < aMax) {
            aMax = bMax;
        }
        if (aMax <= aMin) {
            return false;
        }
        return true;
    }

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
    public static boolean SDL_IntersectRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result) {
        int aMin, aMax, bMin, bMax;

        if (result == null) {
            return false;
        } else if (SDL_RectEmpty(a) || SDL_RectEmpty(b)) {  /* Special cases for empty rects */
            result.w = 0;
            result.h = 0;
            return false;
        }

        /* Horizontal intersection */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin > aMin) {
            aMin = bMin;
        }
        result.x = aMin;
        if (bMax < aMax) {
            aMax = bMax;
        }
        result.w = aMax - aMin;

        /* Vertical intersection */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin > aMin) {
            aMin = bMin;
        }
        result.y = aMin;
        if (bMax < aMax) {
            aMax = bMax;
        }
        result.h = aMax - aMin;

        return !SDL_RectEmpty(result);
    }

    /**
     * Calculate the union of two rectangles.
     *
     * @param a      an SDL_Rect structure representing the first rectangle
     * @param b      an SDL_Rect structure representing the second rectangle
     * @param result an SDL_Rect structure filled in with the union of rectangles
     *               {@code a} and {@code b}
     * @since This function is available since SDL 2.0.0.
     */
    public static void SDL_UnionRect(
            SDL_Rect a,
            SDL_Rect b,
            SDL_Rect result) {
        int aMin, aMax, bMin, bMax;

        if (a == null) {
            return;
        } else if (b == null) {
            return;
        } else if (result == null) {
            return;
        } else if (SDL_RectEmpty(a)) {  /* Special cases for empty Rects */
            if (SDL_RectEmpty(b)) {  /* A and B empty */
                result.x = 0;
                result.y = 0;
                result.w = 0;
                result.h = 0;
            } else {  /* A empty, B not empty */
                result.x = b.x;
                result.y = b.y;
                result.w = b.w;
                result.h = b.h;
            }
            return;
        } else if (SDL_RectEmpty(b)) {  /* A not empty, B empty */
            result.x = a.x;
            result.y = a.y;
            result.w = a.w;
            result.h = a.h;
            return;
        }

        /* Horizontal union */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin < aMin) {
            aMin = bMin;
        }
        result.x = aMin;
        if (bMax > aMax) {
            aMax = bMax;
        }
        result.w = aMax - aMin;

        /* Vertical union */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin < aMin) {
            aMin = bMin;
        }
        result.y = aMin;
        if (bMax > aMax) {
            aMax = bMax;
        }
        result.h = aMax - aMin;
    }

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
            List<SDL_Point> points,
            SDL_Rect clip,
            SDL_Rect result) {
        int minx = 0;
        int miny = 0;
        int maxx = 0;
        int maxy = 0;

        if (points == null) {
            return false;
        }

        int count = points.size();
        if (count < 1) {
            return false;
        }

        if (clip != null) {
            boolean added = false;
            int clip_minx = clip.x;
            int clip_miny = clip.y;
            int clip_maxx = clip.x + clip.w - 1;
            int clip_maxy = clip.y + clip.h - 1;

            /* Special case for empty rectangle */
            if (SDL_RectEmpty(clip)) {
                return false;
            }

            for (SDL_Point point : points) {
                int x = point.x;
                int y = point.y;

                if (x < clip_minx || x > clip_maxx ||
                        y < clip_miny || y > clip_maxy) {
                    continue;
                }
                if (!added) {
                    /* Special case: if no result was requested, we are done */
                    if (result == null) {
                        return true;
                    }

                    /* First point added */
                    minx = maxx = x;
                    miny = maxy = y;
                    added = true;
                    continue;
                }
                if (x < minx) {
                    minx = x;
                } else if (x > maxx) {
                    maxx = x;
                }
                if (y < miny) {
                    miny = y;
                } else if (y > maxy) {
                    maxy = y;
                }
            }
            if (!added) {
                return false;
            }
        } else {
            /* Special case: if no result was requested, we are done */
            if (result == null) {
                return true;
            }

            /* No clipping, always add the first point */
            Iterator<SDL_Point> iterator = points.iterator();
            SDL_Point point = iterator.next();
            minx = maxx = point.x;
            miny = maxy = point.y;

            while (iterator.hasNext()) {
                point = iterator.next();
                int x = point.x;
                int y = point.y;

                if (x < minx) {
                    minx = x;
                } else if (x > maxx) {
                    maxx = x;
                }
                if (y < miny) {
                    miny = y;
                } else if (y > maxy) {
                    maxy = y;
                }
            }
        }

        result.x = minx;
        result.y = miny;
        result.w = (maxx - minx) + 1;
        result.h = (maxy - miny) + 1;

        return true;
    }

    /**
     * Calculate the intersection of a rectangle and line segment.
     *
     * <p>This function is used to clip a line segment to a rectangle. A line segment
     * contained entirely within the rectangle or that does not intersect will
     * remain unchanged. A line segment that crosses the rectangle at either or
     * both ends will be clipped to the boundary of the rectangle and the new
     * coordinates saved in {@code lineX1}, {@code lineY1}, {@code lineX2}, and/or {@code lineY2} as necessary.</p>
     *
     * @param rect   an SDL_Rect structure representing the rectangle to intersect
     * @param lineX1 a pointer to the starting X-coordinate of the line
     * @param lineY1 a pointer to the starting Y-coordinate of the line
     * @param lineX2 a pointer to the ending X-coordinate of the line
     * @param lineY2 a pointer to the ending Y-coordinate of the line
     * @return true if there is an intersection, false otherwise.
     * @since This function is available since SDL 2.0.0.
     */
    public static boolean SDL_IntersectRectAndLine(
            SDL_Rect rect,
            IntRef lineX1,
            IntRef lineY1,
            IntRef lineX2,
            IntRef lineY2) {
        int x = 0;
        int y = 0;
        int x1, y1;
        int x2, y2;
        int rectx1;
        int recty1;
        int rectx2;
        int recty2;
        int outcode1, outcode2;

        if (rect == null) {
            return false;
        } else if (lineX1 == null) {
            return false;
        } else if (lineY1 == null) {
            return false;
        } else if (lineX2 == null) {
            return false;
        } else if (lineY2 == null) {
            return false;
        } else if (SDL_RectEmpty(rect)) {
            return false;  /* Special case for empty rect */
        }

        x1 = lineX1.getValue();
        y1 = lineY1.getValue();
        x2 = lineX2.getValue();
        y2 = lineY2.getValue();
        rectx1 = rect.x;
        recty1 = rect.y;
        rectx2 = rect.x + rect.w - 1;
        recty2 = rect.y + rect.h - 1;

        /* Check to see if entire line is inside rect */
        if (x1 >= rectx1 && x1 <= rectx2 && x2 >= rectx1 && x2 <= rectx2 &&
                y1 >= recty1 && y1 <= recty2 && y2 >= recty1 && y2 <= recty2) {
            return true;
        }

        /* Check to see if entire line is to one side of rect */
        if ((x1 < rectx1 && x2 < rectx1) || (x1 > rectx2 && x2 > rectx2) ||
                (y1 < recty1 && y2 < recty1) || (y1 > recty2 && y2 > recty2)) {
            return false;
        }

        if (y1 == y2) {  /* Horizontal line, easy to clip */
            if (x1 < rectx1) {
                lineX1.setValue(rectx1);
            } else if (x1 > rectx2) {
                lineX1.setValue(rectx2);
            }
            if (x2 < rectx1) {
                lineX2.setValue(rectx1);
            } else if (x2 > rectx2) {
                lineX2.setValue(rectx2);
            }
            return true;
        }

        if (x1 == x2) {  /* Vertical line, easy to clip */
            if (y1 < recty1) {
                lineY1.setValue(recty1);
            } else if (y1 > recty2) {
                lineY1.setValue(recty2);
            }
            if (y2 < recty1) {
                lineY2.setValue(recty1);
            } else if (y2 > recty2) {
                lineY2.setValue(recty2);
            }
            return true;
        }

        /* More complicated Cohen-Sutherland algorithm */
        outcode1 = COMPUTEOUTCODE(rect, x1, y1);
        outcode2 = COMPUTEOUTCODE(rect, x2, y2);
        while ((outcode1 | outcode2) != 0) {
            if ((outcode1 & outcode2) != 0) {
                return false;
            }

            if (outcode1 != 0) {
                if ((outcode1 & CODE_TOP) != 0) {
                    y = recty1;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode1 & CODE_BOTTOM) != 0) {
                    y = recty2;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode1 & CODE_LEFT) != 0) {
                    x = rectx1;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                } else if ((outcode1 & CODE_RIGHT) != 0) {
                    x = rectx2;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                }
                x1 = x;
                y1 = y;
                outcode1 = COMPUTEOUTCODE(rect, x, y);
            } else {
                if ((outcode2 & CODE_TOP) != 0) {
                    y = recty1;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode2 & CODE_BOTTOM) != 0) {
                    y = recty2;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode2 & CODE_LEFT) != 0) {
                /* If this assertion ever fires, here's the static analysis that warned about it:
                   http://buildbot.libsdl.org/sdl-static-analysis/sdl-macosx-static-analysis/sdl-macosx-static-analysis-1101/report-b0d01a.html#EndPath */
                    if (x2 == x1) throw new AssertionError("x2 equal x1: division by zero.");
                    x = rectx1;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                } else if ((outcode2 & CODE_RIGHT) != 0) {
                /* If this assertion ever fires, here's the static analysis that warned about it:
                   http://buildbot.libsdl.org/sdl-static-analysis/sdl-macosx-static-analysis/sdl-macosx-static-analysis-1101/report-39b114.html#EndPath */
                    if (x2 == x1) throw new AssertionError("x2 equal x1: division by zero.");
                    x = rectx2;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                }
                x2 = x;
                y2 = y;
                outcode2 = COMPUTEOUTCODE(rect, x, y);
            }
        }
        lineX1.setValue(x1);
        lineY1.setValue(y1);
        lineX2.setValue(x2);
        lineY2.setValue(y2);
        return true;
    }

    private static final int CODE_BOTTOM = 1;
    private static final int CODE_TOP = 2;
    private static final int CODE_LEFT = 4;
    private static final int CODE_RIGHT = 8;

    /* Use the Cohen-Sutherland algorithm for line clipping */
    private static int COMPUTEOUTCODE(SDL_Rect rect, int x, int y) {
        int code = 0;
        if (y < rect.y) {
            code |= CODE_TOP;
        } else if (y >= rect.y + rect.h) {
            code |= CODE_BOTTOM;
        }
        if (x < rect.x) {
            code |= CODE_LEFT;
        } else if (x >= rect.x + rect.w) {
            code |= CODE_RIGHT;
        }
        return code;
    }

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
    public static boolean SDL_HasIntersectionF(
            SDL_FRect a,
            SDL_FRect b) {
        float aMin, aMax, bMin, bMax;

        if (SDL_FRectEmpty(a) || SDL_FRectEmpty(b)) {
            return false;  /* Special cases for empty rects */
        }

        /* Horizontal intersection */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin > aMin) {
            aMin = bMin;
        }
        if (bMax < aMax) {
            aMax = bMax;
        }
        if (aMax <= aMin) {
            return false;
        }
        /* Vertical intersection */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin > aMin) {
            aMin = bMin;
        }
        if (bMax < aMax) {
            aMax = bMax;
        }
        if (aMax <= aMin) {
            return false;
        }
        return true;

    }

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
    public static boolean SDL_IntersectFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result) {
        float aMin, aMax, bMin, bMax;

        if (result == null) {
            return false;
        } else if (SDL_FRectEmpty(a) || SDL_FRectEmpty(b)) {  /* Special cases for empty rects */
            result.w = 0;
            result.h = 0;
            return false;
        }

        /* Horizontal intersection */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin > aMin) {
            aMin = bMin;
        }
        result.x = aMin;
        if (bMax < aMax) {
            aMax = bMax;
        }
        result.w = aMax - aMin;

        /* Vertical intersection */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin > aMin) {
            aMin = bMin;
        }
        result.y = aMin;
        if (bMax < aMax) {
            aMax = bMax;
        }
        result.h = aMax - aMin;

        return !SDL_FRectEmpty(result);

    }

    /**
     * Calculate the union of two rectangles with float precision.
     *
     * @param a      an SDL_FRect structure representing the first rectangle
     * @param b      an SDL_FRect structure representing the second rectangle
     * @param result an SDL_FRect structure filled in with the union of rectangles
     *               {@code a} and {@code b}
     * @since This function is available since SDL 2.0.22.
     */
    public static void SDL_UnionFRect(
            SDL_FRect a,
            SDL_FRect b,
            SDL_FRect result) {
        float aMin, aMax, bMin, bMax;

        if (a == null) {
            return;
        } else if (b == null) {
            return;
        } else if (result == null) {
            return;
        } else if (SDL_FRectEmpty(a)) {  /* Special cases for empty Rects */
            if (SDL_FRectEmpty(b)) {  /* A and B empty */
                result.x = 0;
                result.y = 0;
                result.w = 0;
                result.h = 0;
            } else {  /* A empty, B not empty */
                result.x = b.x;
                result.y = b.y;
                result.w = b.w;
                result.h = b.h;
            }
            return;
        } else if (SDL_FRectEmpty(b)) {  /* A not empty, B empty */
            result.x = a.x;
            result.y = a.y;
            result.w = a.w;
            result.h = a.h;
            return;
        }

        /* Horizontal union */
        aMin = a.x;
        aMax = aMin + a.w;
        bMin = b.x;
        bMax = bMin + b.w;
        if (bMin < aMin) {
            aMin = bMin;
        }
        result.x = aMin;
        if (bMax > aMax) {
            aMax = bMax;
        }
        result.w = aMax - aMin;

        /* Vertical union */
        aMin = a.y;
        aMax = aMin + a.h;
        bMin = b.y;
        bMax = bMin + b.h;
        if (bMin < aMin) {
            aMin = bMin;
        }
        result.y = aMin;
        if (bMax > aMax) {
            aMax = bMax;
        }
        result.h = aMax - aMin;
    }

    /**
     * Calculate a minimal rectangle enclosing a set of points with float
     * precision.
     *
     * <p>If {@code clip} is not null then only points inside of the clipping rectangle are
     * considered.</p>
     *
     * <p>This is a Java-style version of a raw C-style function. Prefer it over the other.</p>
     *
     * @param points a {@link List} of SDL_FPoint structures representing points to be
     *               enclosed
     * @param clip   an SDL_FRect used for clipping or null to enclose all points
     * @param result an SDL_FRect structure filled in with the minimal enclosing
     *               rectangle
     * @return true if any points were enclosed or false if all the
     * points were outside of the clipping rectangle.
     * @since This function is available since SDL 2.0.22.
     */
    public static boolean SDL_EncloseFPoints(
            List<SDL_FPoint> points,
            SDL_FRect clip,
            SDL_FRect result) {
        float minx = 0;
        float miny = 0;
        float maxx = 0;
        float maxy = 0;

        if (points == null) {
            return false;
        }

        int count = points.size();
        if (count < 1) {
            return false;
        }

        if (clip != null) {
            boolean added = false;
            float clip_minx = clip.x;
            float clip_miny = clip.y;
            float clip_maxx = clip.x + clip.w - 1;
            float clip_maxy = clip.y + clip.h - 1;

            /* Special case for empty rectangle */
            if (SDL_FRectEmpty(clip)) {
                return false;
            }

            for (SDL_FPoint point : points) {
                float x = point.x;
                float y = point.y;

                if (x < clip_minx || x > clip_maxx ||
                        y < clip_miny || y > clip_maxy) {
                    continue;
                }
                if (!added) {
                    /* Special case: if no result was requested, we are done */
                    if (result == null) {
                        return true;
                    }

                    /* First point added */
                    minx = maxx = x;
                    miny = maxy = y;
                    added = true;
                    continue;
                }
                if (x < minx) {
                    minx = x;
                } else if (x > maxx) {
                    maxx = x;
                }
                if (y < miny) {
                    miny = y;
                } else if (y > maxy) {
                    maxy = y;
                }
            }
            if (!added) {
                return false;
            }
        } else {
            /* Special case: if no result was requested, we are done */
            if (result == null) {
                return true;
            }

            /* No clipping, always add the first point */
            Iterator<SDL_FPoint> iterator = points.iterator();
            SDL_FPoint point = iterator.next();
            minx = maxx = point.x;
            miny = maxy = point.y;

            while (iterator.hasNext()) {
                point = iterator.next();
                float x = point.x;
                float y = point.y;

                if (x < minx) {
                    minx = x;
                } else if (x > maxx) {
                    maxx = x;
                }
                if (y < miny) {
                    miny = y;
                } else if (y > maxy) {
                    maxy = y;
                }
            }
        }

        result.x = minx;
        result.y = miny;
        result.w = (maxx - minx) + 1;
        result.h = (maxy - miny) + 1;

        return true;
    }

    /**
     * Calculate the intersection of a rectangle and line segment with float
     * precision.
     *
     * <p>This function is used to clip a line segment to a rectangle. A line segment
     * contained entirely within the rectangle or that does not intersect will
     * remain unchanged. A line segment that crosses the rectangle at either or
     * both ends will be clipped to the boundary of the rectangle and the new
     * coordinates saved in {@code lineX1}, {@code lineY1}, {@code lineX2}, and/or {@code lineY2} as necessary.</p>
     *
     * @param rect   an SDL_FRect structure representing the rectangle to intersect
     * @param lineX1 a pointer to the starting X-coordinate of the line
     * @param lineY1 a pointer to the starting Y-coordinate of the line
     * @param lineX2 a pointer to the ending X-coordinate of the line
     * @param lineY2 a pointer to the ending Y-coordinate of the line
     * @return true if there is an intersection, false otherwise.
     * @since This function is available since SDL 2.0.22.
     */
    public static boolean SDL_IntersectFRectAndLine(
            SDL_FRect rect,
            FloatRef lineX1,
            FloatRef lineY1,
            FloatRef lineX2,
            FloatRef lineY2) {
        float x = 0;
        float y = 0;
        float x1, y1;
        float x2, y2;
        float rectx1;
        float recty1;
        float rectx2;
        float recty2;
        int outcode1, outcode2;

        if (rect == null) {
            return false;
        } else if (lineX1 == null) {
            return false;
        } else if (lineY1 == null) {
            return false;
        } else if (lineX2 == null) {
            return false;
        } else if (lineY2 == null) {
            return false;
        } else if (SDL_FRectEmpty(rect)) {
            return false;  /* Special case for empty rect */
        }

        x1 = lineX1.getValue();
        y1 = lineY1.getValue();
        x2 = lineX2.getValue();
        y2 = lineY2.getValue();
        rectx1 = rect.x;
        recty1 = rect.y;
        rectx2 = rect.x + rect.w - 1;
        recty2 = rect.y + rect.h - 1;

        /* Check to see if entire line is inside rect */
        if (x1 >= rectx1 && x1 <= rectx2 && x2 >= rectx1 && x2 <= rectx2 &&
                y1 >= recty1 && y1 <= recty2 && y2 >= recty1 && y2 <= recty2) {
            return true;
        }

        /* Check to see if entire line is to one side of rect */
        if ((x1 < rectx1 && x2 < rectx1) || (x1 > rectx2 && x2 > rectx2) ||
                (y1 < recty1 && y2 < recty1) || (y1 > recty2 && y2 > recty2)) {
            return false;
        }

        if (y1 == y2) {  /* Horizontal line, easy to clip */
            if (x1 < rectx1) {
                lineX1.setValue(rectx1);
            } else if (x1 > rectx2) {
                lineX1.setValue(rectx2);
            }
            if (x2 < rectx1) {
                lineX2.setValue(rectx1);
            } else if (x2 > rectx2) {
                lineX2.setValue(rectx2);
            }
            return true;
        }

        if (x1 == x2) {  /* Vertical line, easy to clip */
            if (y1 < recty1) {
                lineY1.setValue(recty1);
            } else if (y1 > recty2) {
                lineY1.setValue(recty2);
            }
            if (y2 < recty1) {
                lineY2.setValue(recty1);
            } else if (y2 > recty2) {
                lineY2.setValue(recty2);
            }
            return true;
        }

        /* More complicated Cohen-Sutherland algorithm */
        outcode1 = F_COMPUTEOUTCODE(rect, x1, y1);
        outcode2 = F_COMPUTEOUTCODE(rect, x2, y2);
        while ((outcode1 | outcode2) != 0) {
            if ((outcode1 & outcode2) != 0) {
                return false;
            }

            if (outcode1 != 0) {
                if ((outcode1 & CODE_TOP) != 0) {
                    y = recty1;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode1 & CODE_BOTTOM) != 0) {
                    y = recty2;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode1 & CODE_LEFT) != 0) {
                    x = rectx1;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                } else if ((outcode1 & CODE_RIGHT) != 0) {
                    x = rectx2;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                }
                x1 = x;
                y1 = y;
                outcode1 = F_COMPUTEOUTCODE(rect, x, y);
            } else {
                if ((outcode2 & CODE_TOP) != 0) {
                    y = recty1;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode2 & CODE_BOTTOM) != 0) {
                    y = recty2;
                    x = x1 + ((x2 - x1) * (y - y1)) / (y2 - y1);
                } else if ((outcode2 & CODE_LEFT) != 0) {
                /* If this assertion ever fires, here's the static analysis that warned about it:
                   http://buildbot.libsdl.org/sdl-static-analysis/sdl-macosx-static-analysis/sdl-macosx-static-analysis-1101/report-b0d01a.html#EndPath */
                    if (x2 == x1) throw new AssertionError("x2 equal x1: division by zero.");
                    x = rectx1;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                } else if ((outcode2 & CODE_RIGHT) != 0) {
                /* If this assertion ever fires, here's the static analysis that warned about it:
                   http://buildbot.libsdl.org/sdl-static-analysis/sdl-macosx-static-analysis/sdl-macosx-static-analysis-1101/report-39b114.html#EndPath */
                    if (x2 == x1) throw new AssertionError("x2 equal x1: division by zero.");
                    x = rectx2;
                    y = y1 + ((y2 - y1) * (x - x1)) / (x2 - x1);
                }
                x2 = x;
                y2 = y;
                outcode2 = F_COMPUTEOUTCODE(rect, x, y);
            }
        }
        lineX1.setValue(x1);
        lineY1.setValue(y1);
        lineX2.setValue(x2);
        lineY2.setValue(y2);
        return true;
    }

    /* Use the Cohen-Sutherland algorithm for line clipping */
    private static int F_COMPUTEOUTCODE(SDL_FRect rect, float x, float y) {
        int code = 0;
        if (y < rect.y) {
            code |= CODE_TOP;
        } else if (y >= rect.y + rect.h) {
            code |= CODE_BOTTOM;
        }
        if (x < rect.x) {
            code |= CODE_LEFT;
        } else if (x >= rect.x + rect.w) {
            code |= CODE_RIGHT;
        }
        return code;
    }
}
