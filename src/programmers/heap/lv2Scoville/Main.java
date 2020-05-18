package programmers.heap.lv2Scoville;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		
		System.out.println(solution(scoville, k));
	}
	
	public static int solution(int[] scoville, int k) {
		
		//입력부
		Queue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 0; i < scoville.length; i++) {
			q.add(scoville[i]);
		}
		
		//연산부
		int ans = 0;
		while(q.size()>1) {
			if(q.peek() >= k) break;
			q.add(q.poll() + (q.poll()*2));
			ans++;
		}
		//출력부
		if(q.peek()<k) ans=-1;
		
		return ans;
	}

}