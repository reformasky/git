package org.xuan;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by xzhou2 on 6/10/16.
 */
public class SelfCross {
    public boolean isSelfCrossing(int[] x) {
        Deque<Segment> h = new ArrayDeque<>(3),
                v = new ArrayDeque<>(3);
        int operation = 0;
        int x1 = 0, y1 = 0;
        int x2, y2;
        for(int i : x) {
            switch(operation) {
                case 0: x2 = x1; y2 = y1 + i; break;
                case 1: y2 = y1; x2 = x1 - i; break;
                case 2: x2 = x1; y2 = y1 - i; break;
                case 3: y2 = y1; x2 = x1 + i; break;
                default:throw new RuntimeException();
            }

            Segment curr = new Segment(x1, y1, x2, y2);
            Segment pre1 = null, pre2 = null, pre3 = null;
            if (operation % 2 == 0) {
                pre3 = v.size() < 2 ? null : v.getFirst();
                v.addLast(curr);

                pre1 = h.size() < 3 ? null: h.removeFirst();
                pre2 = h.size() < 2 ? null: h.getFirst();

            }
            else {
                pre3 = h.size() <2 ? null : h.getFirst();
                h.addLast(curr);
                pre1 = v.size() < 3 ? null: v.removeFirst();
                pre2 = v.size() < 2 ? null: v.getFirst();
            }
            if (curr.cross(pre1) || curr.cross(pre2) || curr.cross(pre3)) {
                return true;
            }

            x1 = x2;
            y1 = y2;
            operation = (operation + 1) % 4;
        }
        return false;
    }

    class Segment {
        int x1, y1, x2, y2;
        public Segment(int _x1, int _y1, int _x2, int _y2) {
            x1 = _x1;
            y1 = _y1;
            x2 = _x2;
            y2 = _y2;
        }

        public boolean cross(Segment that) {
            if (that == null) {
                return false;
            }

            int t1 = x1,t2 = x2, t3 = y1, t4 = y2, t5 = that.x1, t6 = that.x2, t7 = that.y1, t8 = that.y2;
            if (t1 > t2) {
                t1 = x2;
                t2 = x1;
            }
            if (t3 > t4) {
                t3 = y2;
                t4 = y1;
            }
            if (t5 > t6) {
                t5 = that.x2;
                t6 = that.x1;
            }
            if (t7 > t8) {
                t7 = that.y2;
                t8 = that.y1;
            }
            if (t1 == t2) {
                if (t5 == t6) {
                    return t1 == t5 && ! (t3 > t8 || t4 < t7);
                }
                else {
                    return (t5 <= t1 && t1 <= t6) && (t3 <= t7 && t4 >= t7);
                }

            }
            else {
                if (t7 == t8) {
                    return t3 == t7 && !(t1 > t6 || t2 < t5);
                }
                else {
                    return (t1 <= t5 && t2 >= t5) && (t7 <= t3 && t8 >= t3);
                }
            }

        }
    }
}
