package baekjoon.search.bj7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	static int m; // 가로, y, k
	static int n; // 세로, x, j
	static int h; // 높이, z, i
	
	static int[][][] map;
	
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {-1,1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	
	static Queue<String> q = new LinkedList<>();
	
	static int ans;
	
	public static void main(String[] args) {
		
		m = sc.nextInt(); // 가로
		n = sc.nextInt(); // 세로
		h = sc.nextInt(); // 높이
		
		map = new int[h][n][m];
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					map[i][j][k] = sc.nextInt();
					if(map[i][j][k] == 1) {
						String tmpQ = i+","+j+","+k; 
						q.add(tmpQ);
					}
				}
			}
		}

		bfs();
		
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(map[i][j][k] ==0) {// 하나라도 안 익은 것이 있다면 바로 -1 출력 후 종료
						ans = -1;
						System.out.println(ans);
						return;
					}
					else if(map[i][j][k]  - 1 > ans){
						ans = map[i][j][k] - 1;
					}
				}
			}
		}
		System.out.println(ans);

		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					System.out.print(map[i][j][k]+" ");
				}
				System.out.println();
			}
		}
	}
	
	
	// 높이 : i, h, z
	// 세로 : j, n, x
	// 가로 : k, m, y
	// map[z][x][y]
	public static void bfs() {
		while(!q.isEmpty()) {
			String[] qArr = q.poll().split(",");
			int z = Integer.parseInt(qArr[0]);		
			int x = Integer.parseInt(qArr[1]);	
			int y = Integer.parseInt(qArr[2]);	
			
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < m && nz < h) {
					if(map[nz][nx][ny]==0) {
						map[nz][nx][ny] = map[z][x][y] + 1;
						String tmpQ = nz+","+nx+","+ny; 
						q.add(tmpQ);
					}
				}
				
			}
		}
		
		
		
	}
}
