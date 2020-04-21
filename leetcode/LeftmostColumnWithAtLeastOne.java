import java.util.List;

public class LeftmostColumnWithAtLeastOne {

    interface BinaryMatrix {
        int get(int x, int y);
        List<Integer> dimensions();
    }

    // 0,1 로만 이루어진 배열이 주어진다.
    // 이 배열은 각 row 가 asc order 로 정렬되어 있다.
    // 배열에 직접 access 하지 않고 주어진 메소드를 통해 접근해야 한다.
    // 1 이 나타나는 가장 왼쪽 컬럼의 인덱스를 반환하라.
    // get 을 1000번 이하로 사용해야 함.
    // 각 row 는 정렬되어 있으므로, 각 row의 1의 가장 왼쪽 위치를 저장한다.
    // 각 row의 1의 위치를 찾을 때, binarySearch 를 이용하여 콜 횟수를 줄인다.
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int n = list.get(0);
        int m = list.get(1);

        int[] rows = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;
            int find = -1;

            while(low <= high) {
                int mid = (low + high) / 2;
                int num = binaryMatrix.get(i, mid);
                if (num == 1) {
                    find = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            rows[i] = find;
        }

        int ans = m + 1;
        for (int i = 0; i < n; i++) {
            if (rows[i] != -1 && rows[i] < ans) {
                ans = rows[i];
            }
        }

        return ans == m + 1 ? -1 : ans;
    }
}
