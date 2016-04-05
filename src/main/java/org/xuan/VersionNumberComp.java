package org.xuan;

/**
 * Created by xzhou2 on 4/3/16.
 */
public class VersionNumberComp {
    public int compareVersion(String version1, String version2) {
        if (version1 == null) {
            return version2 == null ? 0 : -1;
        }
        if (version2 == null) {
            return 1;
        }
        int index1 = 0 , index2 = 0;
        int tempIndex1, tempIndex2;
        int part1, part2;
        while(index1< version1.length() && index2 < version2.length()) {
            tempIndex1 = version1.indexOf('.' , index1);
            tempIndex2 = version2.indexOf('.', index2);
            if (tempIndex1 < 0) {
                tempIndex1 = version1.length();
            }
            if (tempIndex2 < 0) {
                tempIndex2 = version2.length();
            }
            part1 = Integer.parseInt(version1.substring(index1, tempIndex1));
            part2 = Integer.parseInt(version2.substring(index2, tempIndex2));
            if (part1 > part2) {
                return 1;
            }
            else if (part1 < part2) {
                return -1;
            }
            else {
                index1 = tempIndex1 + 1;
                index2 = tempIndex2 + 1;
            }
        }
        while(index1 < version1.length()) {
            tempIndex1 = version1.indexOf('.' , index1);
            if (tempIndex1 < 0) {
                tempIndex1 = version1.length();
            }
            part1 = Integer.parseInt(version1.substring(index1, tempIndex1));
            if (part1 > 0) {
                return 1;
            }
            index1 = tempIndex1 + 1;
        }

        while(index2 < version2.length()) {
            tempIndex2 = version2.indexOf('.' , index2);
            if (tempIndex2 < 0) {
                tempIndex2 = version2.length();
            }
            part2 = Integer.parseInt(version2.substring(index2, tempIndex2));
            if (part2 > 0) {
                return -1;
            }
            index2 = tempIndex2 + 1;
        }

        return 0;
    }
}
