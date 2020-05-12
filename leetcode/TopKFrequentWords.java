import java.util.*;
public class TopKFrequentWords {

    // words 가 주어지면, 빈도수가 많은 순으로 k 개 만큼의 단어를 반환하는 문제.
    // 빈도수가 같을 경우 lower alphabetical order 로 반환한다.
    // 먼저 주어진 단어의 빈도수를 저장하는 맵을 생성하고 저장한다.
    // 그 후 PriorityQueue 에 요소들을 집어 넣는데, 정렬 값은 위에서 생성한 빈도수 맵을 사용해
    // 빈도수가 많은순 -> 알파벳 순으로 정렬을 한다.
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String str: words) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> pQueue = new PriorityQueue<>((x, y) -> {
            int cmp = countMap.get(y) - countMap.get(x);
            if (cmp > 0) return 1;
            else if(cmp < 0) return -1;
            else return x.compareTo(y);
        });


        for (String str: countMap.keySet()) {
            pQueue.add(str);
        }

        List<String> res = new ArrayList<>();
        while(k > 0) {
            k--;
            res.add(pQueue.poll());
        }

        return res;
    }
}
