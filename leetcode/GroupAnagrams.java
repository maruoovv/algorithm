import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	// anagram 문자열끼리 그룹핑 하는 문제.
	// 문자열을 사전순으로 sort한 값을 키로 갖는 맵을 선언하여 해결
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str: strs) {
			String key = sortString(str.toCharArray());
			List<String> value = map.getOrDefault(key, new ArrayList<>());
			value.add(str);
			map.put(key, value);
		}

		return new ArrayList<>(map.values());
	}

	public String sortString(char[] t) {
		Arrays.sort(t);
		return new String(t);
	}
}
