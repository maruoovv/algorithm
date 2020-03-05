import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 사전을 만들고, 단어가 주어질때 정확히 한 문자만 바꿔서 사전에 있는지를 판별하는 문제
// 사전을 만들때, 단어들의 길이 별로 맵을 구축해놓고
// 단어가 들어 올때 단어의 길이 리스트를 가져와 비교.
public class MagicDictionary {

    private Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (int i = 0; i < dict.length; i++) {
            int len = dict[i].length();
            List<String> list = map.getOrDefault(len, new ArrayList<>());
            list.add(dict[i]);
            map.put(len, list);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        List<String> list = map.get(word.length());

        if (list == null || list.isEmpty()) return false;

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            String comp = list.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (cnt > 1) break;

                if (word.charAt(j) != comp.charAt(j)) {
                    cnt++;
                }
            }

            if (cnt == 1) return true;
            else cnt = 0;
        }

        return false;
    }


}
