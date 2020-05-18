package programmers.heap.lv2Ramen;

import java.awt.Point;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main2 {

	public static void main(String[] args){
		int stock = 4;
		int[] dates = {1, 2, 3, 4};
		int[] supplies = {10,40,20,30};
		int k = 100;
//		int stock = 4;
//		int[] dates = {4, 10, 15};
//		int[] supplies = {20, 5, 10};
//		int k = 30;
		
		System.out.println(solution(stock, dates, supplies, k));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		Queue<PointMine> q = new PriorityQueue<PointMine>();
		// x = dates, y = supplies
		// 날짜는 오름차순
		// 물량은 내림차순
		// 물량 기준으로 먼저 정렬
		
		int nowDate = 0;
		int ans = 0;
		
		outer:
		while(true) {
			for(int i = 0; i < dates.length; i++) {
				// 입력부
				if(dates[i] <= stock) {
					q.add(new PointMine(dates[i], supplies[i]));				
				}
			}
			// 연산부
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				if(tmp.x < nowDate)	continue; // 현재 날짜보다 빠르면 못받으므로 버려 
				else if(stock >= k) break outer; // stock이 k 넘어가면 충분하므로
				nowDate = tmp.x;
				stock += tmp.y;
				ans++;
			}
		}
		
		
		return ans;
	}
}

class PointMine extends Point implements Comparable<PointMine>{	
	private static final long serialVersionUID = 1L;	
	public PointMine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointMine(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public PointMine(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(PointMine o) {
		// x = dates, y = supplies
		// 날짜는 오름차순
		// 물량은 내림차순
		// 물량 기준으로 먼저 정렬
		if(this.y < o.y) { // 앞이 뒤보다 물량이 더 적을경우
			return 1; // 바꿔.
		} else if(this.y == o.y) { // 같을 경우
			if(this.x > o.x) { // 앞이 뒤보다 날짜가 느릴경우
				return 1; // 바꿔
			}
		}
		return -1;
	}
	
}