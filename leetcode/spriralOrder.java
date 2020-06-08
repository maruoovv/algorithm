import java.util.*;
public class spriralOrder {

    // 배열을 뱀모양으로 순회하는 문제.
    // 겉에서부터 오른쪽 -> 아래쪽 -> 왼쪽 -> 위쪽 으로 순회한다.
    // 주의할 점은 같은 점이 여러번 포함 될 수 있다는 건데,
    // 1 2 3 4
    // 5 6 7 8
    // 9 1 2 3
    // 이런 배열이 있을 때, (1,2) (1,3) 은 오른쪽 순회, 왼쪽 순회에 두번 포함될 수 있다. (3*4 가 아닌 4*3 이라면 아래쪽, 위쪽에 두번 포함)
    // 이를 방지 하지 위해 왼쪽 -> 위쪽 순회는 x0 < x1 -1 && y0 < y1 -1 이란 조건을 넣었다.
    // 위의 경우는 정사각형 순회가 아닌 경우에 발생하므로 정사각형인지 체크를 함.
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;

        if (m == 0) return ans;
        int n = matrix[0].length;
        int x0 = 0;
        int x1 = m;
        int y0 = 0;
        int y1 = n;

        while(x0 < x1 && y0 < y1) {
            for (int i = y0; i < y1; i++) {
                ans.add(matrix[x0][i]);
            }

            for (int i = x0 + 1; i < x1; i++) {
                ans.add(matrix[i][y1 - 1]);
            }

            if (x0 < x1 - 1 && y0 < y1 - 1) {
                for (int i = y1 - 2; i >= y0; i--) {
                    ans.add(matrix[x1-1][i]);
                }

                for (int i = x1 - 2; i > x0; i--){
                    ans.add(matrix[i][x0]);
                }
            }

            x0++;
            y0++;
            x1--;
            y1--;
        }

        return ans;
    }
}
