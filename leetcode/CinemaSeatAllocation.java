import java.util.*;

public class CinemaSeatAllocation {

    // 영화관 좌석을 배치하는 문제
    // 좌석은 1~3 4~7 8~10 으로 나누어져 있고, 나누어진 의자에 앉는 방법은 2명씩 앉는 것 뿐이다.
    // 예약된 좌석 정보가 주어질 때, 4명 그룹의 사람들을 가장 많이 배치하는 방법을 찾는 문제.
    // 사실상 1, 10 번째 자리는 신경쓸 필요가 없고,
    // 2~5 에 예약된 좌석이 있을 경우 왼쪽은 사용 못하고,
    // 4~7 에 예약된 좌석이 있을 경우 중간은 사용 못하고,
    // 6~9 에 예약된 좌석이 있을 경우 오른쪽은 사용 못한다.
    // 최대로 앉을수 있는 좌석수는 2*n 개이고,
    // 위의 로직을 각 row 에 적용하면서 left, mid, right 사용 여부를 셋에 기록한다.
    // 각 row 의 set 의 크기가 3이라면, 해당 row 는 전부 사용 못하므로 2를 빼주고,
    // 아닐경우 left, mid, right 중 하나는 사용 가능한 것이므로 1을 빼준다.
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int len = reservedSeats.length;
        int ans = n * 2;
        Map<Integer, Set<Integer>> map = new HashMap<>();

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[][] t = {{0, 1}};

        for (int i = 0; i < len; i++) {
            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (seat >= 2 && seat <= 5) {
                // left
                Set<Integer> set = map.getOrDefault(row, new HashSet<>());
                set.add(0);
                map.put(row, set);
            }
            if (seat >= 4 && seat <= 7) {
                // mid
                Set<Integer> set = map.getOrDefault(row, new HashSet<>());
                set.add(1);
                map.put(row, set);
            }
            if (seat >= 6 && seat <= 9) {
                // right
                Set<Integer> set = map.getOrDefault(row, new HashSet<>());
                set.add(2);
                map.put(row, set);
            }
        }

        Iterator<Integer> keys = map.keySet().iterator();

        while(keys.hasNext()) {
            Integer key = keys.next();
            Set<Integer> set = map.get(key);

            if (set.size() == 3) ans -= 2;
            else ans -= 1;
        }

        return ans;

    }
}
