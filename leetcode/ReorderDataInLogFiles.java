import java.util.*;
import java.util.stream.Collectors;

public class ReorderDataInLogFiles {

    // log 들이 주어지고 주어진 조건에 따라 정렬하는 문제
    // 조건만 까다로울 뿐이지 그다지 어려운 문제는 아니었다

    // identifier log 로 이루어진 문자열들이 주어지는데
    // log 는 숫자로만 구성된 digits, 문자로 구성된 letter 가 주어진다.
    // digits 는 주어진 순서대로, letters 는 identifier 를 제외한 log 의 사전순, 이게 같다면 identifier 사전순이다.
    // letters 의 비교 구문만 작성하면 끝.
    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for (String cur : logs) {
            String[] split = cur.split(" ");
            char firstChar = split[1].charAt(0);

            if (firstChar >= '0' && firstChar <= '9') {
                digits.add(cur);
            } else {
                letters.add(cur);
            }
        }

        List<String> sortedLetters = letters.stream()
                .sorted((a, b) -> {
                    String logA = a.substring(a.indexOf(" "));
                    String logB = b.substring(b.indexOf(" "));
                    String idenA = a.substring(0, a.indexOf(" "));
                    String idenB = b.substring(0, b.indexOf(" "));

                    int comp = logA.compareTo(logB);

                    if (comp < 0) return -1;
                    else if (comp > 0) return 1;
                    else return idenA.compareTo(idenB);
                }).collect(Collectors.toList());

        sortedLetters.addAll(digits);

        return sortedLetters.toArray(new String[0]);
    }
}
