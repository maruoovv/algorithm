public class SingleElementInSortedArray {

    // 정렬된 정수 배열이 주어진다.
    // 이 배열은 2개씩 중복된 수들과, 단 하나만 있는 하나의 수로 이루어져 있다.
    // 하나로 이루어진 수를 찾아라.

    // 일단 single element 는 단 하나만 주어지기 때문에, 어떠한 경우에도 이 수는 짝수 번째 인덱스에 존재한다.
    // 1 1 3 5 5
    // 1 3 3 5 5
    // 1 1 3 3 5
    // 이진 탐색을 하는데, single element 는 짝수 번째 인덱스에 있으므로, mid 를 짝수로 만들어 준다.
    // 만약 mid == mid - 1 이라면, 찾아야 할 수는 왼쪽 범위에 존재한다.
    // 전체 배열의 크기는 홀수 이고, 우리는 짝수 번째 인덱스로 검사 하기 때문에,
    // mid 가 mid - 1 과 같다면, 오른쪽 범위엔 짝수개의 수가, 왼쪽에는 홀수개의 수가 존재 하므로 왼쪽 범위에 존재한다.
    // mid == mid + 1 이라면, 찾는 수는 오른쪽 범위에 존재한다.
    // 마찬가지로, mid 가 mid + 1 과 같다면, 오른쪽 범위에는 홀수개의 수, 왼쪽 범위에는 짝수개의 수가 존재한다.
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length;
        int mid = 0;
        while(low < high) {
            mid = (low + high) / 2;

            if (mid % 2 == 1) mid++;

            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                high = mid - 1;
            } else if (mid + 1 < high && nums[mid] == nums[mid + 1]){
                low = mid + 1;
            } else break;
        }

        return nums[mid];
    }
}
