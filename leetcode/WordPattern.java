import java.util.*;

public class WordPattern {
    // pattern 과 string 이 주어지고, 주어진 string 이 패턴에 대응하는지 판단하는 문제.
    // 먼저 str 을 split 하여 각 단어로 분리한다.
    // 각 단어들이 주어진 패턴에 맞는지 판단하기 위해, pattern character -> string 의 맵을 생성하고,
    // 이미 나온 문자열인지 판단을 위해 set 을 생성한다.
    // map 에 해당 패턴이 저장되있지 않고 이미 나온 문자가 아닌경우 유효하고,
    // map 에 해당 패턴이 있을 경우 지금의 문자열과 저장된 문자열이 일치해야 유효하다.
    public boolean wordPattern(String pattern, String str) {
        String[] splittedStr = str.split(" ");

        if (splittedStr.length != pattern.length()) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> dic = new HashSet<>();

        for (int i = 0; i < splittedStr.length; i++) {
            String curStr = splittedStr[i];
            Character curChar = pattern.charAt(i);

            if (map.get(curChar) == null) {
                if (dic.contains(curStr)) return false;
                map.put(curChar, curStr);
            }
            else {
                if (!map.get(curChar).equals(curStr)) return false;

            }

            dic.add(curStr);
        }

        return true;
    }
}
