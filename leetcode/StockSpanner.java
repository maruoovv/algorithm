import java.util.*;
class StockSpanner {

    private Stack<int[]> stocks;
    public StockSpanner() {
        stocks = new Stack<>();
    }

    // stock 의 price 가 주어지면, 이전에 나온 연속된 가격 중 현재가 보다 낮은 것의 개수를 세는 문제.
    // next 의 호출량이 많으므로, 시간을 줄이는게 중요하다.
    // price 가 나오면 스택에 (현재가격, 연속된 낮은 가격의 개수)를 저장을 한다.
    // 새 price 가 들어오면, 이전 가격이 현재 보다 높을 때 까지 순회를 하며
    // 연속된 낮은 가격의 개수를 더해준다.
    public int next(int price) {
        int sum = 1;
        while(!stocks.isEmpty() && stocks.peek()[0] <= price) {
            int[] prev = stocks.pop();
            sum += prev[1];
        }

        stocks.push(new int[]{price, sum});
        return sum;
    }
}