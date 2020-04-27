public class MaximalSquare {

    // 1, 0 으로 이루어진 배열이 주어지면,
    // 1로 이루어진 가장 큰 정사각형을 찾는 문제.
    // 배열을 순회하며 각 원소를 오른쪽 아래로 하는 가장 큰 정사각형의 변을 구한다.
    // 만약 해당 원소가 1이고, 왼쪽 위 대각선 위의 원소가 모두 같으면 그 원소를 오른쪽 아래로 하는 가장 큰 정사각형의
    // 한변의 길이는 왼쪽원소 + 1가 된다.
    // 해당 원소가 1이고, 세개가 같지 않으면, 변의 길이는 세개중 최소값 + 1 이 된다.
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[][] map = new int[n][m];

        int max = 0;

        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') {
                map[0][i] = 1;
                max = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                map[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0') continue;

                if (map[i][j-1] == map[i-1][j-1] && map[i-1][j-1] ==  map[i-1][j]) map[i][j] = map[i][j-1] + 1;
                else {
                    map[i][j] = Math.min(map[i][j-1], Math.min(map[i-1][j-1], map[i-1][j])) + 1;
                }

                max = max < map[i][j] ? map[i][j] : max;
            }
        }

        return max*max;
    }
}
