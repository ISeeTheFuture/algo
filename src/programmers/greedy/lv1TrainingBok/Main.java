package programmers.greedy.lv1TrainingBok;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
//		int n = 5;
//		int[] lost = {2,4};
//		int[] reserve = {1,3,5};
		int n = 10;
		int[] lost = {3,9,10};
		int[] reserve = {3,8,9};
				

		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		
		// 입력부
		
		// 일단 lost, reserve 겹치는거 제거. 얘넨 없는게 나은 쓰레기값.
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i]==reserve[j]) {
					lost[i] = 0;
					reserve[j] = 0;
				}
			}
		}
		Queue<Integer> lostQ = new PriorityQueue<Integer>();
		Queue<Integer> lostReserve = new PriorityQueue<Integer>();
		
		for(int i = 0; i < lost.length; i++) {
			if(lost[i]!=0) lostQ.add(lost[i]);
		}
		for(int i = 0; i < reserve.length; i++) {
			if(reserve[i]!=0) lostReserve.add(reserve[i]);
		}
		
		// 연산부
		n -= lostQ.size(); // 일단 빌려주기전 체육 수업 듣는 애들 수
		while(!lostQ.isEmpty()&&!lostReserve.isEmpty()) {
			int lostOne = lostQ.poll();
			int reserveOne = lostReserve.poll();
			if(lostOne+1==reserveOne||lostOne-1==reserveOne||lostOne==reserveOne) n++; // 빌려 줄 수 있으면 ++
			// 아래가 바로 그리디. 작은 애 버리고, 큰 애를 큐에 다시 돌려 놓는다. 
			else if(lostOne>reserveOne) lostQ.add(lostOne);
			else if(lostOne<reserveOne) lostReserve.add(reserveOne);
		}
		
		// 출력부
		return n;
	}
}