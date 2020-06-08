public class FindJudge {

    // 주어진 조건을 만족하는 지점을 찾는 문제.
    // N 명의 사람이 있고,
    // 자기를 제외한 모든 사람이 자신을 믿으며, 자신은 누구도 안 믿는 유일한 사람을 찾는 문제
    // [N+1][2] 배열을 만들고
    // [i][0] 는 자신이 믿는 사람의 수, [i][1] 은 자신을 믿는 사람의 수를 저장한다.
    public int findJudge(int N, int[][] trust) {
        int[][] trustMap = new int[N+1][2];

        for (int i = 0; i < trust.length; i++) {
            int x = trust[i][0];
            int y = trust[i][1];

            trustMap[x][0]++;
            trustMap[y][1]++;
        }

        int res = -1;
        for (int i = 1; i <= N; i++) {
            if (trustMap[i][0] == 0 && trustMap[i][1] == N - 1) {
                if (res == -1) res = i;
                else return -1;
            }
        }

        return res;
    }
}
