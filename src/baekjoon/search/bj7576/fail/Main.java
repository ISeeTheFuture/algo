package baekjoon.search.bj7576.fail;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 논리는 맞는데... 왜 자꾸 런타임 에러가 뜨는겨
// 폐기
public class Main {

	static Scanner sc = new Scanner(System.in);
	
	// dfs로 풀어 스텝수를 구하는 문제
	static int m; // 가로
	static int n; // 세로
	
	static int[][] map; // 전체 지도
	static int[][] visited; // 방문여부
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static int turn;
	static int stop;
	
	static Queue<Point> q = new LinkedList<>(); // dfs 이므로  일단 q 쓰고보자 
	
	
	public static void main(String[] args) {
		// 입력부
		m = sc.nextInt(); // 가로 길이 받음
		n = sc.nextInt(); // 세로 길이 받음

		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == -1) {
					visited[i][j] = -1; // 못가는 곳은 미리 체크
				} else if(map[i][j] == 1) {
					visited[i][j] = 1; // 시작점도 체크
				}
			}
		}

		// 연산부
		outer:
		while(!check(visited)) { // 전체를 전부 방문했는지 확인
			turn++; // 턴 시작
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(map[i][j]==1&&visited[i][j] == turn) { // 익은 토마토(1)부터 숙성이 시작되므로
						bfs(i,j);
//						visited[i][j] = turn; // 필요 없음.
					}
					if(turn > stop+1) { // 만약 최대치까지 돌려도 끝나지 않으면... -1 넣고 종료.
						turn = -1;
						break outer;
					};
				}
			}
			for(int i = 0; i < n; i++){ // 확인용
				for(int j = 0; j < m; j++){
					System.out.print(visited[i][j]+"	");
				}
				System.out.println();
			}
		}
		
		System.out.println(turn);
		
	}

	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i = 0; i < 4; i++) { // 사방 탐색
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx>=0&&ny>=0&&nx<n&&ny<m) { // 일단 지도 범위 내에 있는가 판단.
					if(map[nx][ny]!=-1&&visited[nx][ny]==0) {
						map[nx][ny] = 1;
						visited[nx][ny] = turn+1;
						stop = turn+1;
					}					
				}
				
			}			
		}	
		
	}
	
	public static boolean check(int[][] visited) {
		
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited.length; j++) {
				if(visited[i][j]==0) return false;
			}
		}
		return true;
	}
}
