public class JumpGame {

    // 배열이 주어지고, 각 인덱스에서는 최대 각 인덱스의 수만큼 다음으로 건너 뛸 수 있다.
    // 첫번째에서 시작하여 마지막까지 건너갈수 있는지 판단하는 문제.
    // 해당 인덱스에 방문했는지 여부를 체크하는 boolean 배열을 선언하고,
    // visit == true 일 경우 1부터 해당 인덱스의 크기 만큼 앞의 방문 배열을 true 로 해준다.
    // 최대 인덱스까지 도달할 경우 true 반환
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return true;

        boolean[] visit = new boolean[len];
        visit[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j < len)
                        visit[i+j] = true;
                    if (i + j >= len - 1) return true;
                }
            }
        }

        return false;
    }
}
