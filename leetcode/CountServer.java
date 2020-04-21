public class CountServer {

    // 1(서버), 0 으로 이루어진 배열이 주어진다.
    // 각 서버는 row, col 에 다른 서버가 있을 경우 연결되어 있는 서버이다.
    // 연결된 서버의 개수를 구하여라.
    // grid 배열을 순회하며 서버가 있을 경우
    // 해당 i번쨰 열, j번째 컬럼의 rows, cols 를 각각 증가시키고, 전체 서버 수를 증가시킨다.
    // 이후에, 한번 더 순회를 하며 grid[i][j] 가 1일 때(서버일 때), rows[i], cols[j] 가 모두 1이라면,
    // 이 경우엔 row, col 에 서버가 단 한대만 있는 경우이다.
    // 이 경우는 연결된 서버가 아니므로 뺴준다.
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        int total = 0;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    total--;
                }
            }
        }

        return total;
    }
}
