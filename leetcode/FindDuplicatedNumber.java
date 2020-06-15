public class FindDuplicatedNumber {

    // N + 1 길이의 배열에 1~N 까지의 숫자가 있고, 중복된 수를 찾는 문제.
    // 중복된 수는 단 하나만 존재한다.
    // 원본 배열을 바꾸지 않고, 공간복잡도 O(1), 시간복잡도 O(N^2) 아래로 풀어야 함
    // 1~N 까지의 수를 binary search 로 줄여나가면서 찾는다.
    // 현재 수보다 작은것의 개수, 큰것의 개수를 세고
    // 이 합이 배열의 길이 - 1 보다 작으면, 현재 수가 중복된 수이다.
    // 현재수 - 작은것의 개수가 1보다 크면, 중복된 수는 현재 수 보다 큰 범위에 존재한다.
    public  int findDuplicate(int[] nums) {
        int len = nums.length;

        int low = 1;
        int high = len - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int s = 0;
            int l = 0;

            for (int i = 0; i < len; i++) {
                if (nums[i] < mid) s++;
                else if (nums[i] > mid) l++;
            }

            if (s + l < len - 1) return mid;

            if (mid - s >= 1) low = mid + 1;
            else high = mid - 1;
        }

        return 0;
    }
}
