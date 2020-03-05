public class LargestRectangle {

    // 히스토그램에서 가장 큰 사각형의 크기를 찾는 문제
    // 각 지점에서 가장 큰 사각형을 만들수 있는 경우는
    // 왼쪽 방향으로 연속적으로 현재 높이보다 같거나 크면서 제일 먼 지점,
    // 오른쪽 방향으로 연속적으로 현재 높이보다 같거나 크면서 제일 먼 지점.
    // 두 지점을 구하면 넓이를 구할수 있다.
    // O(n^2) 인데.. 스택으로 풀면 O(n) 이 가능하다 하는데 스택으로 푸는건 이해가 잘 안된다.
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] sum = new int[len];
        int max = 0;

        for (int i = 0; i < len; i++) {
            int mid = heights[i];

            int left = i, right = i;

            for (int j = i-1; j >= 0; j--) {
                if (heights[j] >= mid) {
                    left = j;
                } else {
                    break;
                }
            }

            for (int j = i+1; j <len; j++) {
                if (heights[j] >= mid) {
                    right = j;
                } else {
                    break;
                }
            }

            sum[i] = (right - left + 1) * heights[i];
            max = max < sum[i] ? sum[i] : max;

        }

        return max;
    }
}
