public class ArrangeCoins {

    // n 이 주어졌을 때 다음과 같이 배열한다
    // n = 5
    // o
    // o o
    // o o
    // 각 row 에 있는 개수가 row 와 일치하는 최대 개수를 구하라.

    // N 이 integer.MAX 로 주어졌을때 생각 해보면
    // 1
    // 2 3
    // 4 5 6
    // 7 8 9 10
    // 11 12 13 14 15 ... 이런식으로 배열이 된다.
    // 각 row 의 누적합은
    // 1                | 1
    // 2 3              | 6
    // 4 5 6            | 21
    // 7 8 9 10         | 34
    // 11 12 13 14 15   | ...
    // 다음과 같이 된다.
    // 결국 N 이 주어 졌을 때,
    // N 이 위같은 누적합의 어느 구간에 속하는지를 알아 낼수 있다면 답을 찾아 낼수 있다.
    // N 이 주어졌을때 누적 합은, k * (k*1) / 2 다음 공식으로 구할 수 있다.
    // 따라서 N 이 주어졌을 때, k <= N 을 만족하는 k 를 찾으면 된다.
    // n == 5 라고 가정 했을때, n 은 1 <  < 6 구간에 속한다.
    // 이 구간을 찾는 방법은 binary search 를 하며, 누적합이 N 보다 작으면서 가장 큰 k 를 찾는다.
    // 어렵다.. 어떻게 생각해내지
    // TODO : 나중에 다시 풀어보자
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        long k, curr;

        while(left <= right) {
            k = (left + right) / 2;
            curr = k * (k + 1) / 2;

            if (curr == n) return (int) k;

            if (n < curr) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return (int)right;

    }
}
