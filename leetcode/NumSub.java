public class NumSub {

    // 0과 1로 이루어진 string 이 주어지면, 1로만 이루어진 substring 의 개수를 구하는 문제.
    // O(N) 으로 순회하면서 연속된 1을 구하면서, ans 를 계산해나간다.
    // 연속된 1의 길이가 2라고 하면
    // 1
    // 11
    // 1개만 있는거 2개 + 2개 있는거 1개다.
    // 결국 하나가 추가될때 2개가 추가된건데, N을 확장시켜 일반화 해보면
    // 길이가 N 일때 substring 의 개수는
    // count(N - 1) + N 이다.
    public int numSub(String s) {
        int ans = 0;
        int len = s.length();

        int cnt = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < len; i++) {
            cnt = s.charAt(i) == '1' ? cnt + 1 : 0;
            ans = (ans + cnt) % mod;
        }

        return ans;
    }
}
