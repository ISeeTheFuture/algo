package programmers.stackq.lv2Stock;

import java.util.Stack;

public class Main2 {

	public static void main(String[] args){
		int[] prices = {5,2,3,4,1,1,2,3,2,3};
		System.out.println(solution(prices));
	}
	
    public static int[] solution(int[] prices) {
        Stack<Integer[]> st = new Stack<>(); // [0] : 가격, [1] : sec
        int[] ans = new int[prices.length];
        
        for (int i = prices.length - 2; i >= 0; i--) { // 뒤에서부터 시작하고, 맨뒤는 어차피 0이므로 생략
            int sec = 0;
            while (!st.isEmpty()&&st.peek()[0] >= prices[i]) {
        		sec += st.pop()[1];
            }
            ans[i] = st.push(new Integer[]{prices[i], sec + 1})[1];
        }
        // DP인가?, Stack이 아니구...
        // (1,4), 4 o
        // (2,3), 3 x 
        // (3,1), 1 x
        // (2,1), 1 x
        // (0,0), 0 x
//		for(int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
        return ans;
    }

}