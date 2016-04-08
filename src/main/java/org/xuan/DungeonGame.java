package org.xuan;

/**
 * Created by xzhou2 on 4/7/16.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            throw new IllegalArgumentException();
        }
        int nRow = dungeon.length, nCol = dungeon[0].length;
        int[][] minHP = new int[nRow][nCol];
        minHP[nRow-1][nCol-1] = Math.max(1, 1 - dungeon[nRow-1][nCol - 1]);
        for(int r = nRow - 2; r >= 0; r--) {
            minHP[r][nCol-1] = Math.max(1, minHP[r + 1][nCol - 1] - dungeon[r][nCol - 1]);
        }
        for(int c = nCol - 2; c >= 0; c--) {
            minHP[nRow-1][c] = Math.max(1, minHP[nRow - 1][c + 1] - dungeon[nRow - 1][c]);
        }
        for(int r = nRow -2; r >= 0; r--) {
            for(int c = nCol - 2; c >= 0; c--) {
                minHP[r][c] = Math.max(1, Math.min(minHP[r + 1][c], minHP[r][c + 1]) - dungeon[r][c]);
            }
        }
        return minHP[0][0];
    }
}
