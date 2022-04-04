public class minDeletion_2216 {

    // 배열의 길이가 짝수이고
    // 짝수번째 인덱스에 대해 nums[i] != nums[i+1] 이 성립하면 아름다운 배열이라고 한다
    // 아름다운 배열을 만들기 위해 배열에서 원소를 제거할 수 있는데, 제거된 원소의 오른쪽 원소들은 왼쪽으로 shift 된다.
    // 아름다운 배열을 만들기 위한 최소 제거 개수를 구하는 문제

    // 배열을 순회하면서 짝수번째 인덱스일 경우 nums[i] == nums[i+1] 일 경우 제거한 개수를 늘려준다.
    // 이때 제거된 개수만큼 왼쪽으로 shift 되므로, 짝수번째 인덱스인지 판단하는 조건에 제거된 개수만큼 인덱스를 빼줘야 한다
    // 원본 배열 길이 - 제거한 개수가 짝수가 아닐 경우 배열이 짝수여야 한다는 조건이 성립하지 않으므로 하나를 더 제거한다.
    public int minDeletion(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i - count) % 2 == 0) {
                if (nums[i] == nums[i + 1]) count++;
            }
        }

        return (nums.length - count) % 2 == 0 ? count : count + 1;
    }
}
