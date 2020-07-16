import java.util.Arrays;

public class IPO {

    // 이익을 가장 극대화 하는 project 를 선택 하는 문제.
    // 현재의 capital 보다 같거나 작은 capital 만을 선택할 수 있다.
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int ans = W;

        // ans 보다 같거나 작은 capital 을 선택해야 하고,
        // 그 중 가장 큰 profit 을 선택해야 함
        // 이를 위해 먼저 Profit 의 크기 순으로 정렬을 한다.
        // 정렬된 배열에서, capital 의 값이 현재 capital 의 합보다 작거나 같은 첫번째 project를 선택하고 더해준다.
        // 배열보다 우선순위 큐를 활용하면 코드가 더 깔끔해지고 시간복잡도도 더 줄일 수 있을것 같다.

        int len = Profits.length;

        if (len == 0) return ans;

        int[][] pcMap = new int[len][3];

        for (int i = 0; i < len; i++) {
            pcMap[i][0] = Profits[i];
            pcMap[i][1] = Capital[i];
            pcMap[i][2] = 0;
        }

        Arrays.sort(pcMap, (o1, o2) -> {
            if (o1[0] > o2[0]) return -1;
            else if (o1[0] < o2[0]) return 1;
            else {
                if (o1[1] < o2[1]) return 1;
                else if (o1[1] > o2[1]) return -1;
                else return 0;
            }
        });

        while (k > 0) {
            k--;
            for (int i = 0; i < len; i++) {
                if (pcMap[i][2] == 0 && ans >= pcMap[i][1]) {
                    ans += pcMap[i][0];
                    pcMap[i][2] = 1;
                    break;
                }
            }

        }

        return ans;
    }

}
