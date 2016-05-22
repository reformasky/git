package org.xuan;

/**
 * Created by xzhou2 on 5/17/16.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        if (!isBadVersion(n)) {
            return n+1;
        }

        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) /2;
            boolean curr = isBadVersion(mid),
                    next = isBadVersion(mid + 1);
            if (!curr && next) {
                return mid + 1;
            }
            if (!curr) {
                left = mid + 1;
            }
            if (next) {
                right = mid - 1;
            }

        }
        return left + 1;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
