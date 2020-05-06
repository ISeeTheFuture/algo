package baekjoon.search.bj7569.w;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static Scanner sc = new Scanner(System.in);
	static int m,n,h,count,day;
	static int[][][] map;
	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	static Queue<Integer> q3 = new LinkedList<Integer>();
	
	public static void main(String[]args) {
		//입력
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		map = new int[n][m][h];
		count = m * n * h; //검사할 토마토 수
		for(int k=0; k<h; k++) {
			for(int j=0; j<m; j++) {
				for(int i=0; i<n; i++) {
					map[i][j][k] = sc.nextInt();
				}
			}
		}
		bfs();
		
		for(int k=0; k<h; k++) {
			for(int j=0; j<m; j++) {
				for(int i=0; i<n; i++) {
					System.out.print(map[i][j][k]+" ");
					
				}
				
			}
		
		}
	}
	public static void bfs() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<h; k++) {
					if(map[i][j][k]==1) {
						--count; // 이미 검사완료 -1
						q1.offer(i);
						q2.offer(j);
						q3.offer(k);
					} else if(map[i][j][k]==-1) {
						--count; // 비었네 -1
					}
				}
			}
		}
		while(!q1.isEmpty()) {
			int x = q1.poll();
			int y = q2.poll();
			int z = q3.poll();
			// 6방향 확인 상하좌우앞뒤?
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				// 맵 내에서
				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < n  && ny < m && nz < h ) {
					// 안익은 토마토 발견 시
					if(map[nx][ny][nz]==0) {
						q1.offer(nx);
						q2.offer(ny);
						q3.offer(nz);
						// 익어라
						map[nx][ny][nz] = map[x][y][z]+1;
						// 검사완료 -1
						--count;
						// 날이 밝았어요.
						day = map[x][y][z];
						System.out.println(day);
					}
				}
			}
		}
		//출력부
		//모두 검사완료 시 날짜출력
		if(count == 0) {
			System.out.println(day);
		//그렇지 않을시 -1
		}else if(count>0) {
			System.out.println("-1");
		}
	}
	
}