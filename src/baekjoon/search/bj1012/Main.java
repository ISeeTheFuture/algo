package baekjoon.search.bj1012;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in); 
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] map;
	static boolean[][] visited;
	static int m;
	static int n;
	static int k;
	
	public static void main(String[] args) {
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			run();			
		}
		

	}
	
	private static void run() {
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		
		int ans = 0;
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[y][x] = 1;
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					dfs(i,j);
					ans++;					
				}
			}
		}
		
		System.out.println(ans);
		
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx >= 0 && ny >= 0 && nx < m && ny <n) {
				if(map[ny][nx]==1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
		
	}
	
}
