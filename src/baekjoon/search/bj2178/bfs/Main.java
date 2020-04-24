package baekjoon.search.bj2178.bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n; // 세로축
	static int m; // 가로축
	static int[][] map; // 전체 지도 배열(n,m)
	static int[][] visited; // 방문 지도 배열 upgrade 버전. 기존 boolean으로 방문여부만 체크하는 것이 아니고, 몇번째 스텝인지를 저장.
	
	static int[] dx = {-1,1,0,0}; // 상,하,좌,우
	static int[] dy = {0,0,-1,1}; // 상,하,좌,우
	
	static Queue<Point> q = new LinkedList<Point>();
	 
	

	public static void main(String[] args) {
		
		//입력부
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m]; 
		
		for(int i = 0; i < n; i++) {
			String tmp = sc.next();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j) -'0';
			}
		}
		
		// 연산부
			// 1. (1,1)에서 시작해서 (n,m)에서 끝남.
			// 2. 모든 1은 이어져 있음.
			// 3. 따라서 별도의 for문은 필요없고, 어차피 원트에 끝남.
		bfs(0,0);
		
		
		// 답안 제출
		System.out.println(visited[n-1][m-1]);
		
		
		
	}
	
	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		visited[x][y] = 1; // 문제 조건에 따라 첫 (0,0) 의 스텝을 1로 지정.
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i]; // nx => next x
				int ny = now.y + dy[i]; // ny => next y
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny]==1&&visited[nx][ny]==0) {
						visited[nx][ny] = visited[now.x][now.y]+1;
						q.offer(new Point(nx,ny));
					}				
				}
			}
		}
	}
}
