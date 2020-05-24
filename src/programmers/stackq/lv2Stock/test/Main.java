package programmers.stackq.lv2Stock.test;

import java.util.Stack;

public class Main {

	public static void main(String[] args){
		int[] prices = {5,2,3,4,1,1,2,3,2,3};
		System.out.println(solution(prices));
	}
	
    public static int[] solution(int[] prices) {
        Stack<Integer[]> st = new Stack<>(); // [0] : 가격, [1] : sec
        int[] ans = new int[prices.length];
        
        for(int i = prices.length-2; i >= 0; i--) {
        	int sec = 0;
        	while(!st.isEmpty()&&st.peek()[0]>=prices[i]) {
        		sec+= st.pop()[1];
        	}
        	ans[i] = st.push(new Integer[] {prices[i], sec+1})[1];
        }
        
        return ans;
    }

}