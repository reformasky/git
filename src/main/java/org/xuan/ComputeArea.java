package org.xuan;

/**
 * Created by xzhou2 on 4/21/16.
 */
public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > E) {
            return computeArea(E, F, G, H, A, B, C, D);
        }
        return (G-E) * (H - F) + (C-A)* (D -B) - intersect(A, B, C, D, E, F, G, H);
    }

    private int intersect(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (E >= C || F >= D || H <= B) {
            return 0;
        }
        int leftX, leftY, rightX, rightY;
        leftX = E;
        leftY = Math.max(F, B);
        rightX = Math.min(C, G);
        rightY = Math.min(D, H);
        return (rightY - leftY) * (rightX - leftX);
    }
}
