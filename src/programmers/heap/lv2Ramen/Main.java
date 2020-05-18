package programmers.heap.lv2Ramen;

import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
//		int stock = 4;
//		int[] dates = {1, 2, 3, 4};
//		int[] supplies = {10,40,20,30};
//		int k = 100;
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		
		System.out.println(solution(stock, dates, supplies, k));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		
		// 입력부
		int ans = 0;		
		Queue<Point> qIpt = new LinkedList<Point>();
		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < dates.length; i++) {
			qIpt.add(new Point(dates[i], supplies[i]));
		}
		

		// 연산부
			// stock보다 날짜가 큰 값을 넣는 경우만 제외하면 됨.
				// stock보다 날짜가 작을 때, 그 넣는 순서는 고려할 필요 없음.
				// 어차피 사용가능한 범위이므로, ans에 들어간 순서가 다르더라도 무관.
					// ans에 3일 1일 2일 이런 식으로 들어가더라도, 3일이 들어간 순간 1일, 2일은 당연히 사용가능하단 얘기이므로,
					// 실제 집행은 1일, 2일, 3일 순으로 진행 가능.
		while(stock < k) { // k 보다 stock이 커지는 순간 break
			while(!qIpt.isEmpty()&&qIpt.peek().x <= stock){ // 날짜가 stock 보다 작으면, 
				q.add(qIpt.poll().y); // 해당 (날짜, 공급량) 전부 q에 추가
			}
			stock += q.poll(); // q에 들어있는것 중에서 가장 큰 값 stock에 더해줌
			ans++;
		}
		
		
		return ans;
	}
}