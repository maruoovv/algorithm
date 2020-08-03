import java.util.*;
import java.util.stream.Collectors;

public class GetWatchedVideosbyYourFriends {

    // 간단한 BFS 문제. 설명이 조금 꼬여있긴 하지만 차분히 풀면 된다.
    // 이웃한 친구들 중에, distance 가 level 만큼인 친구들이 본 비디오를 빈도순으로 정렬하여 반환하는 문제
    // 먼저 각 0~n-1 의 이웃들을 저장을 하고,
    // 각노드, 거리 의 배열을 큐에 넣고 bfs 로 탐색 한다.
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Map<Integer, List<Integer>> friendList = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < friends.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < friends[i].length; j++) {
                temp.add(friends[i][j]);
            }

            friendList.put(i, temp);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visit = new boolean[friends.length];
        Map<String, Integer> freq = new HashMap<>();

        q.add(new int[]{id, 0});
        visit[id] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[1] > level) continue;

            List<String> videos = watchedVideos.get(cur[0]);

            if (cur[1] == level) {
                ans.addAll(videos);

                for (int i = 0; i < videos.size(); i++) {
                    freq.put(videos.get(i), freq.getOrDefault(videos.get(i), 0) + 1);
                }
            }

            List<Integer> fr = friendList.get(cur[0]);
            for (int i = 0; i < fr.size(); i++) {
                int next = fr.get(i);
                if (!visit[next]) {
                    q.add(new int[]{fr.get(i), cur[1] + 1});
                    visit[next] = true;
                }
            }
        }

        return ans.stream()
                .distinct()
                .sorted((a, b) ->  {
                    int fa = freq.get(a);
                    int fb = freq.get(b);
                    if (fa != fb) {
                        return fa - fb;
                    }
                    else {
                        return a.compareTo(b);
                    }
                })
                .collect(Collectors.toList());
    }
}
