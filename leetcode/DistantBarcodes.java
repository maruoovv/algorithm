import java.util.*;

public class DistantBarcodes {

    // 1~10000 까지의 숫자들이 주어지면, 인접한 수가 같은 수가 아니게 반환하는 문제.
    // 답이 무조건 존재한다고 가정한다.
    // 답이 무조건 존재하므로, 답이 나올수 있는 경우 중 한가지는 가장 많이 나온 수를 0,2,4.... 이런식으로 배열하고
    // 그 다음 많이 나온수를 이어서 6, 8... 이렇게 배열 하는 경우다.
    // 이렇게 하기 위해 먼저 각 수가 나온 횟수를 카운팅 하고, 많이 나온 순으로 정렬한다.
    // 그 후 0,2,4... 에 큰수를 넣고 이어서 다음 수를 넣는다. 이 때 INDEX 가 배열의 크기를 넘어가면 다시 홀수 번째에
    // 넣기 시작한다.
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] ans = new int[len];


        int[][] count = new int[10001][2];

        for (int i = 0; i < len; i++) {
            int num = barcodes[i];
            count[num][0] = num;
            count[num][1]++;
        }

        Arrays.sort(count, Comparator.comparingInt(o -> -o[1]));

        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < count[i][1]; j++) {
                ans[index] = count[i][0];
                index += 2;

                if (index >= len) index = 1;

                if (index == len) break;
            }
        }

        return ans;
    }
}
