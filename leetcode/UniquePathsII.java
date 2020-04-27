public class UniquePathsII {

    // UniquePaths 와 비슷한 문제.
    // 갈수 없는 영역이 추가되었다.
    // 갈수 없는 영역의 경우는 해당 칸은 0이고,
    // 갈수 있는 영역의 경우 해당 칸에 도달하는 방법의 수는
    // 왼쪽에서 오는 경우의 수 + 위쪽에서 오는 경우의 수이다.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;

        if (m == 0) return 0;

        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];

        if (obstacleGrid[0][0] == 0) map[0][0] = 1;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;

                if (i - 1 < 0 && j - 1 >= 0) map[i][j] = map[i][j-1];
                else if (j - 1 < 0 && i - 1 >= 0) map[i][j] = map[i-1][j];
                else if (i - 1 >= 0 && j - 1 >= 0) {
                    map[i][j] = map[i-1][j] + map[i][j-1];
                }
            }

        }

        return map[m-1][n-1];
    }
}
