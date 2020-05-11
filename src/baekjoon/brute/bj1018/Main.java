package baekjoon.brute.bj1018;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static char[][] map;
	
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String tmp = sc.next();
			for(int j = 0; j < m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		// 연산부
		int ans = n*m; // 임의의 더미값
		for(int i = 0; i <= n-8; i++) {
			for(int j = 0; j <= m-8; j++) {
				int tmp = bf(i, j);
				ans = Math.min(tmp, ans); // 계속 답안 최소값으로 최신화
			}
		}
		System.out.println(ans);
	}
	
	public static int bf(int a, int b) {
		int bw=0; // BWBWBWBW 기준 바꿔야할 갯수
		int wb=0; // WBWBWBWB 기준 바꿔야할 갯수
		int result = 0;
		
		for(int i = a; i < a+8; i++) {
			for(int j = b; j < b+8; j++) {
				if((i+j)%2==0){ // 짝수칸
					if(map[i][j]=='W')bw++; // BW 아니면
					else wb++; // BW 맞으면
					
				} else { // 홀수칸
					if(map[i][j]=='B')bw++; // BW 아니면
					else wb++; // BW 맞으면
				}
				
			}
		}
		result = Math.min(bw, wb);
		
		return result;
	}
}
