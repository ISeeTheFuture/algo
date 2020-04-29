package baekjoon.search.bj7576;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

	static Scanner sc = new Scanner(System.in);
	
	// bfs로 풀어 스텝수를 구하는 문제
	static int m; // 가로
	static int n; // 세로
	
	static int[][] map; // 전체 지도
//	static int[][] map; // 방문여부
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int turn;
	
	static Queue<Point> q = new LinkedList<>(); // bfs 이므로  일단 q 쓰고보자 
	
	
	public static void main(String[] args) {
		// 입력부
		m = sc.nextInt(); // 가로 길이 받음
		n = sc.nextInt(); // 세로 길이 받음

		map = new int[n][m];
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1)q.offer(new Point(i,j));
//				if(map[i][j] == -1) {
//					visited[i][j] = -1; // 못가는 곳은 미리 체크
//				}
//				else if(map[i][j] == 1) {
//					q.offer(new Point(i,j)); // 시작점도 체크
//					visited[i][j] = 1; // 출발지를 방문하지 않도록 처리. 어차피 출발지는 바로 위에서 큐에 넣어놨다.
//				}
			}
		}

		// 연산부
		outer:
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
//				if(map[i][j]==1&&visited[i][j] == 0) { 
				if(map[i][j]==1) { // 모든 시작점을 큐에 저장해 놨으므로, visited[i][j]
					bfs(i,j);
					break outer; // 어차피 한 번 들어가면 끝날 때까지 안나옴. 나오면 바로 break; 없어도 별 상관없음.
				}
			}
		}
		
		
		// 확인 : 혹시 방문 안한 곳이 있는지 확인해서 하나라도 있을 경우 -1을 리턴
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(map[i][j]+"	");
				if(map[i][j] ==0) turn = -1;
			}
			System.out.println();
		}
		
		// 
		if(turn==-1) // 방문 안한 곳이 있을 경우,
			System.out.println(-1);
		else if(turn == 0) // 시작하자마자 끝날 경우,
			System.out.println(0);
		else
			System.out.println(turn-1); // 시작점의 값이 1로 고정되어 있어, 첫날부터 2가 들어가므로.. 답은 하나씩 감해줘야함.
		
	}

	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < 4; i++) { // 사방 탐색
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) { // 일단 지도 범위 내에 있는가 판단.
					if(map[nx][ny]!=-1&&map[nx][ny]==0) {
						q.offer(new Point(nx,ny));
						map[nx][ny] = map[now.x][now.y]+1;
//						turn = turn < visited[nx][ny]?visited[nx][ny]:turn;
						turn = map[nx][ny];
					}					
				}
				
			}			
		}	
		
	}
}
