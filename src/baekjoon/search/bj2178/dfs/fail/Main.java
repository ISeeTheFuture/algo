package baekjoon.search.bj2178.dfs.fail;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n; // 세로축
	static int m; // 가로축
	static int[][] map; // 전체 지도 배열(n,m)
	static boolean[][] visited; // 방문 지도 배열
	
	static int[] dx = {1,0,-1,0}; // 하,우,상,좌
	static int[] dy = {0,1,0,-1}; // 하,우,상,좌
	
	static int cnt; // 답으로 제출할 이동 횟수 
	
	// 이거 그냥 dfs로 풀면 안되나? 일단 풀어보고...
		// 결론 : 망. dfs로 안됨.
	public static void main(String[] args) {
		
		//입력부
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m]; 
		
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
		dfs(0,0);
		
		
		
		
	}
	
	public static void dfs(int x, int y) {
		System.out.println("("+x+","+y+")");
		visited[x][y] = true;
		cnt++;
		if(x == n-1 && y == m-1) {
			System.out.println(cnt);
			return;
		}
		
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if(map[nx][ny]==1&&!visited[nx][ny]) {
					dfs(nx, ny);
				}				
			}
		}
	}

}
