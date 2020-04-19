public class SearchInRotatedSortedArray {

	// 회전된 정렬된 리스트가 있을때, target 값이 있는지 찾는 문제. O(logN) 제한
	// 바이너리 서치를 이용 하는데, 일반적인 바이너리 서치를 이용할 수는 없다.

	// 다음 값이 오른쪽 범위인지 왼쪽 범위인지 판단을 해야하는데,
	// 1. target < nums[mid]
	// 타겟이 미들값 보다 작을때, 다음 값이 오른쪽 범위에 있을 조건은.
	// 타켓이 nums[low] 보다 작고, nums[mid] 가 nums[low] 보다 같거나 커야 한다.
	// 4 5 6 7 0 1 2
	// target = 0 이라고 하면,
	// nums[mid] 값인 7 보다 작으니 다음 범위를 찾는다.
	// target 이 nums[low] 보다는 작고, nums[mid] 가 nums[low] 보다 크므로, 왼쪽에 포함되지 않는다.

	// 2. target > nums[mid]
	// 타켓이 미들값보다 클 때, 다음값이 왼쪽 범위에 있을 조건은
	// 타켓이 로우값보다 같거나 크고, 미들값이 로우값보다 작아야 한다.
	// 8 9 2 3 4
	// target = 9
	// target > nums[mid] , target >= nums[low], nums[mid] < nums[low]

	// 배열 몇개를 생각하며 규칙을 세웠는데, 증명을 어떻게 해야할지는 모르겠다..
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;

		int low = 0;
		int high = nums.length - 1;

		while(low <= high) {
			int mid = (low + high) / 2;

			if (nums[mid] == target) return mid;

			if (target < nums[mid]) {
				if (target < nums[low] && nums[mid] >= nums[low]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (target >= nums[low] && nums[mid] < nums[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}

		return -1;
	}
}
