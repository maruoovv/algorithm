public class RemoveKDigits {

    // 주어진 숫자에서 k개 digit 을 없애고 가장 작은 수를 만드는 문제.
    // 하나의 숫자를 없앨 때 다음 수가 가장 작은 수일 경우는
    // 첫번째 peak element 를 없애는 것이다.
    // 몇가지 예시를 들어서 생각해보면 좋은데,
    // 4 3 1 2 에서 2개 제거 -> 4 3 을 제거
    // 4 3 2 1 에서 1개 제거 -> 4 제거
    // 1 4 3 2 에서 2개 제거 -> 4, 3 제거
    // 각 k 번째 순회에 가장 왼쪽의 peak element 를 제거하면, 다음 수는 가장 작은 수이다.
    // 시간 복잡도는 O(n*k)
    public String removeKdigits(String num, int k) {
        String cur = num;

        int i;
        while(k > 0) {
            k--;

            for (i = 0; i < cur.length() - 1; i++) {
                if (cur.charAt(i) > cur.charAt(i+1)) break;
            }

            cur = cur.substring(0, i) + (i + 1 < cur.length() ? cur.substring(i + 1) : "");
        }


        for (i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != '0') break;
        }

        String res = cur.substring(i);
        return res.isEmpty() ? "0" : cur.substring(i);
    }
}
