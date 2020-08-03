import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {

    // (이름, 이메일...) 로 이루어진 리스트가 주어진다.
    // 이메일이 겹치면 동일한 사람이라, 이런 계정들을 합쳐서 반환하는 문제이다.
    // 먼저 email 을 key, indexes 를 value 로 하는 맵을 만들고,
    // 연결된 계정들을 찾는다.
    // 연결된 계정의 graph 를 만들면, 각 노드에서 그래프를 순회하면서 연결된 이메일들을 찾는다.
    // 코드가 너무 길어져서 어떻게 하면 줄일수 있을지 생각해보는게 좋을듯
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> nodes = new HashMap<>();

        int len = accounts.size();
        boolean[][] connected = new boolean[len][10];

        for (int i = 0; i < len; i++) {
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());

            for (int j = 0; j < emails.size(); j++) {
                List<Integer> neighbor = nodes.getOrDefault(emails.get(j), new ArrayList<>());
                neighbor.add(i);
                nodes.put(emails.get(j), neighbor);
            }
        }

        for (int i = 0; i < len; i++) {
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());

            for (int j = 0; j < emails.size(); j++) {
                List<Integer> neighbor = nodes.getOrDefault(emails.get(j), new ArrayList<>());

                for (int k = 0; k < neighbor.size(); k++) {
                    connected[i][neighbor.get(k)] = true;
                }
            }
        }

        boolean[][] visit = new boolean[len][10];

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (visit[i][i]) continue;

            List<String> temp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            List<String> currentMails = accounts.get(i);
            temp.addAll(currentMails.subList(1, currentMails.size()));

            while(!q.isEmpty()) {
                int cur = q.poll();

                if (visit[cur][cur]) continue;

                for (int j = 0; j < 10; j++) {
                    if (j != cur && connected[cur][j]) {
                        visit[cur][cur] = true;
                        q.add(j);
                        temp.addAll(accounts.get(j).subList(1, accounts.get(j).size()));
                    }
                }
            }


            List<String> candidates = new ArrayList<>();
            candidates.add(currentMails.get(0));
            candidates.addAll(temp.stream()
                    .distinct()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList()));

            ans.add(candidates);
        }

        return ans;
    }
}
