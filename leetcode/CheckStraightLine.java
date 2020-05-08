public class CheckStraightLine {

    // 2차원 배열에 각 점들이 주어지면, 각 점들이 동일 선상에 있는지를 판단하는 문제.
    // 각 점들의 기울기를 검사해서 모두 같다면 동일 선상에 있는 것이다.
    // dy / dx = (y1 - y0) / (x1 - x0) 가 되어야 함.
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], x1 = coordinates[1][0], y0 = coordinates[0][1], y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for (int[] po : coordinates) {
            if (dx * (po[1] - y0) != dy * (po[0] - x0)) return false;
        }

        return true;
    }
}
