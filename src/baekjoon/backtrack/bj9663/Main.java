package baekjoon.backtrack.bj9663;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int ans;
	static boolean[][] map;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		ans = 0;
		map = new boolean[n][n];

		
		bt(0);
		System.out.println(ans);
	}
	public static void bt(int a) {
		
		if(a == n) { // 만렙 여부 파악
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(map[i][j]+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			ans++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if((!map[a][i])&&check(a, i)) { // 퀸을 놓을 수 있는 자리인가?
				map[a][i] = true;
				bt(a+1);
				map[a][i] = false;
			}
		}
		return;
	}

	public static boolean check(int x, int y) { // true 가 나와야 통과
		for(int i = 0; i < n; i++) { // 가로줄 체크
			if(map[x][i]) return false;
		}
		for(int i = 0; i < n; i++) { // 세로줄 체크
			if(map[i][y]) return false;
		}
		for(int i = 0; x + i < n || y + i < n; i++) { // 대각선 체크
			if(x+i >= n || y+i >=n) break;
			if(map[x+i][y+i]) return false;
		}
		for(int i = 0; x - i >= 0 || y - i >= 0; i++) { // 대각선 체크
			if(x-i < 0 || y-i < 0) break;
			if(map[x-i][y-i]) return false;
		}
		for(int i = 0; x + i < n || y - i >= 0; i++) { // 대각선 체크
			if(x+i >= n || y-i < 0) break;
			if(map[x+i][y-i]) return false;
		}
		for(int i = 0; x - i >= 0 || y + i < n; i++) { // 대각선 체크
			if(x-i < 0 || y+i >=n) break;
			if(map[x-i][y+i]) return false;
		}
		
		
		return true;
	}
}
