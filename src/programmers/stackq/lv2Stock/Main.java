package programmers.stackq.lv2Stock;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		int[] prices = {1,2,3,2,3};
		System.out.println(solution(prices));
	}
	
	// 맞는데, 효율성에서 떨어지네..
	public static int[] solution(int[] prices) {
		// 입력부
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qCopied;
		int[] ans = new int[prices.length];
		for(int i = 0; i < prices.length; i++) {
			q.add(prices[i]);
		}
		
		
		// 연산부
		for(int i = 0; i < prices.length; i++) {
			int sec = 0;
			if(!q.isEmpty()) {
				int tmp = q.poll();
				qCopied = new LinkedList<>(q); // 깊은 복사. stack: clone(), queue : (q);
				while(!qCopied.isEmpty()) {
					sec++;
					if(qCopied.poll() < tmp) {
						break;
					}
				}				
			}
			ans[i] = sec;
		}
//		for(int i = 0; i < ans.length; i++) {
//			System.out.println(ans[i]);
//		}
		return ans;
	}

}