package programmers.heap.lv3DiskController;

import java.awt.Point;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
//		int[][] jobs = {{0, 3},{1, 9},{2, 6}};
//		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 74 맞음
//		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}}; //74 맞음
//		int[][] jobs = {{0, 1}, {0, 2}, {2, 1}}; // 2맞음
//		int[][] jobs = {{0, 6}, {0, 8}, {7, 1}}; // 9 맞음
		int[][] jobs = {{0, 8}, {0, 6}, {7, 1}}; // 9 맞음
//		int[][] jobs = {{0, 3}, {1, 9}, {500, 6}}; // 6맞음
//		int[][] jobs = {{0, 5}, {1, 2}, {5, 5}}; // 6맞음
		// (명령들어온 시점,소요시간)
		
		System.out.println(solution(jobs));
	}
	
	public static int solution(int[][] jobs) {
		Queue<PointDisk> q = new PriorityQueue<>();
		
		int cnt = 0;		
		int nowMs = 0;
		int sum = 0;
		
		while(true) {
			for(int i = 0; i < jobs.length; i++) {
				if(jobs[i][0] <= nowMs&&jobs[i][0]!=-1) {
					q.add(new PointDisk(jobs[i][0], jobs[i][1]));
					jobs[i][0] = -1;
				}
			}
			if(q.isEmpty()) nowMs++; // q에 아무것도 못넣었다면
			
			while(!q.isEmpty()) {
				Point tmp = q.poll();
				nowMs += tmp.y;
				sum += nowMs-tmp.x;
				cnt++;
				break; // 한 번 돌리고 다시 판단해야되서 break; 이게 없어서 하루종일 고생 ㅡㅡ
			}
			if(cnt >= jobs.length) break;
		}
		
		return sum/cnt;
	}

}

class PointDisk extends Point implements Comparable<PointDisk>{	
	private static final long serialVersionUID = 1L;	
	public PointDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointDisk(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public PointDisk(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(PointDisk o) {
		// x = 명령시점, y = 소요시간
		// 소요 시간 기준으로 오름차순 정렬
		if(this.y > o.y) { // 앞이 뒤보다 소요시간이 더 클경우
			return 1; // 바꿔.
		} else if(this.y == o.y) { // 소요시간이 같으면, 더 빠른 시점의 명령을 앞으로
			if(this.x > o.x) return 1; // 바꿔
		}
		return -1;
	}
	
}