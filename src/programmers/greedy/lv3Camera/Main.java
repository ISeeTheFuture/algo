package programmers.greedy.lv3Camera;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};

		System.out.println(solution(routes));
	}
	// {진입, 진출}
	// 진출 기준으로 오름차순 정렬
	public static int solution(int[][] routes) {
		Queue<PointRoutes> q = new PriorityQueue<>();
		for(int i = 0; i < routes.length; i++) {
			q.add(new PointRoutes(routes[i][0], routes[i][1]));
		}
		List camList = new ArrayList();
		
		
		int nowCam = q.poll().y;
		camList.add(nowCam);
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			if(tmp.x > nowCam) {
				nowCam = tmp.y;
				camList.add(nowCam);
			}
		}
		return camList.size();
	}
}

class PointRoutes extends Point implements Comparable<PointRoutes>{	
	private static final long serialVersionUID = 1L;	
	public PointRoutes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointRoutes(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public PointRoutes(Point p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(PointRoutes o) {
		// x = 진입, y = 진출
		// 진출 기준으로 오름차순 정렬
		if(this.y > o.y) { // 앞이 진출이 더 클경우
			return 1; // 바꿔.
		} else if(this.y == o.y) { // 진출이 같으면, 더 빠른 진입을 앞으로..
			if(this.x > o.x) return 1; // 바꿔
		}
		return -1;
	}
	
}