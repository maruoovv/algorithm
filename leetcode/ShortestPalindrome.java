
public class ShortestPalindrome {

    // 문자열이 주어지면 문자열 앞에 문자들을 더해 가장 짧은 팰린드롬을 만드는 문제.
    // 문자열이 주어지면 그걸 뒤집은 문자열과 비교를 해나가고, 일치하는 substring 의 index 가 발견되면
    // 뒤집은 문자열에 원본 배열의 substring 을 더해준다.

    // s = "abcd"
    // reverse = "dcba"
    // 원본 배열은 (0,N-i) ... (0,1) 로 비교를 해나가고
    // 뒤집은 배열은 (i, len) ... 으로 비교를 해나간다
    // 위의 경우 (0, 1) == "a" 에서 일치 하므로
    // 뒤집은 배열인 dcba + s.substring(N - i) ("bcd") 를 반환한다.
    public String shortestPalindrome(String s) {
        int len = s.length();
        String reverse = "";

        for (int i = 0; i < len; i++) {
            reverse += s.charAt(len - i - 1);
        }

        for (int i = 0; i < len; i++) {
            if (s.substring(0, len - i).equals(reverse.substring(i, len))) {
                return reverse + s.substring(len -i);
            }
        }

        return "";
    }
}
