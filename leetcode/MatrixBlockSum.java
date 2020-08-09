public class MatrixBlockSum {

    // 2d array 와 k 가 주어진다.
    // 각 r,c 에서의
    // i - K <= r <= i + K, j - K <= c <= j + K 범위를 가지는 블록의 합을 반환하는 문제.
    // . . . .
    // . . . .
    // . . . .
    // . . . .
    // 4x4 배열에서 k == 2 일때, 2,2 의 값을 구한다고 해보자.
    // 이 값은
    // - - - -      . - - -     . . . .     . - - -
    // - . . .      . - - -     - - - -     - - - -
    // - . . . -    . - - - -   - - - - +   - - - -
    // - . . .      . - - -     - - - -     - - - -
    // 가 될 것이다.
    // 이를 위해서 먼저 각 지점에서의 subsum 을 구한후 각 지점의 합을 구한다.
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] subSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                subSum[i + 1][j + 1] = subSum[i][j + 1] + subSum[i + 1][j] - subSum[i][j] + mat[i][j];
            }
        }

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c1 = Math.max(0, j - K);
                int r1 = Math.max(0, i - K);
                int c2 = Math.min(n, j + K + 1);
                int r2 = Math.min(m, i + K + 1);

                ans[i][j] = subSum[r2][c2] - subSum[r1][c2] - subSum[r2][c1] + subSum[r1][c1];
            }
        }

        return ans;
    }
}
