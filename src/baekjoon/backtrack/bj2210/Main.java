package baekjoon.backtrack.bj2210;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int[][] map = new int[5][5];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static Set<String> strSet = new HashSet<>();
	
	public static void main(String[] args) {
		// 입력부
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 연산부
			// 이상하게 StringBuilder 로 하면 안됨..
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
//				StringBuilder sb = new StringBuilder();
				String sb = "";
				dfs(i, j, sb);
			}
		}
		
		
		System.out.println(strSet.size());
//		System.out.println(strSet.toString());
		
	}

	public static void dfs(int x, int y, String sb) {
//		sb.append(map[x][y]);
		sb += map[x][y];
		
		if(sb.length() == 6) {
			strSet.add(sb);
//			System.out.println(sb.toString());
//			System.out.println();
			return;
		} else if(sb.length() > 6) return;
		
		for(int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0&&nx<map.length&&ny>=0&&ny<map.length) {
				dfs(nx, ny, sb);
			}
		}
	}
}