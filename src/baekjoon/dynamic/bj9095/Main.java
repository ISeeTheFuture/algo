package baekjoon.dynamic.bj9095;

import java.util.Scanner;

public class Main {

	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt(); // 입력할 변수 갯수
		int[] DP = new int[11]; // 이미 n은 11이하의 수로 정해져 있으므로 11로 선언
		
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 4;
//		DP[4] = 7;
//		DP[5] = 13;
//		DP[6] = 24;
		
		for(int i = 0; i < n; i++) {
			int ipt = sc.nextInt(); // 변수 입력
			for(int j = 4; j <= ipt; j++) { // 입력된 변수 ipt만큼 for문 실행 
				DP[j] = DP[j-1]+DP[j-2]+DP[j-3];
			}
			System.out.println(DP[ipt]);
		}
	}
}
