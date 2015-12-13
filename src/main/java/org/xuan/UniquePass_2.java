package org.xuan;

/**
 * Created by xuan on 2015/12/9.
 */
public class UniquePass_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }


        int rowNum = obstacleGrid.length,
                colNum = obstacleGrid[0].length;
        if (obstacleGrid[rowNum - 1][colNum - 1] == 1) {
            return 0;
        }
        int[][] cache = new int[rowNum][colNum];
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                cache[i][j] = - 1;
            }
        }
        if (colNum > 1) {
            cache[rowNum - 1][colNum - 2] = obstacleGrid[rowNum - 1][colNum - 2] == 0 ? 1 : 0;
        }
        if(rowNum > 1) {
            cache[rowNum - 2][colNum - 1] = obstacleGrid[rowNum - 2][colNum - 1] == 0 ? 1 : 0;
        }
        cache[rowNum - 1][colNum -1] = 1;

        return uniquePathsWithObstacles(obstacleGrid, 0, 0, cache);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int m, int n, int[][] cache) {
        if (cache[m][n] >= 0) {
            return cache[m][n];
        }
        if (obstacleGrid[m][n] == 1) {
            cache[m][n] = 0;
            return 0;
        }

        int result = 0;
        result += m < obstacleGrid.length -1 ?  uniquePathsWithObstacles(obstacleGrid, m + 1, n, cache) : 0;
        result += n < obstacleGrid[0].length -1 ?  uniquePathsWithObstacles(obstacleGrid, m, n+1, cache) : 0;
        cache[m][n] = result;
        return result;
    }
}
