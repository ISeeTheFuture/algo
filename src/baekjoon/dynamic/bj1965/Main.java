package baekjoon.dynamic.bj1965;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n; // 상자의 개수
	static int[] s; // 상자의 크기
	static int[] dp; // dp 저장용 배열
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		s = new int[n];
		dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
		}
		
		// 연산부
		for(int i = 0; i < n; i++) {
			if(dp[i] == 0) dp[i] = 1; // 첫 수열 자기 자신이므로 1; => DP1 = 1
			for(int j = 0; j < i; j++) {
				if(s[i] > s[j]) {
					if(dp[i] < dp[j] + 1) {   // 과거의 DP[4] < 현재의 DP[4]
						dp[i] = dp[j] + 1; // DP[4] = DP1+1 = 2
											// DP[4] = DP2+1 = 3
					}
				}
			}
		}
		
		// 설명
//		9
//		10 20 40 25 20 50 30 70 85
//		위에꺼 설명 위해 간략화
//		6
//		10 20 40 25 20 50  
//
//		dp1 1	10 -> 10
//		dp2 2	20 -> 10 20
//		dp3 3	40 -> 10 20 40
//		dp4 3	25 -> 10 20 25
//		dp5 2	20 -> 10 20
//		dp6 4	50 -> 10 20 40 50 또는 10 20 25 50
//
//
//		dp6 50 -> 10				dp[6] = 0 < dp[1] + 1 O => dp[6] = 2
//		dp6 50 -> 10 20				dp[6] = 2 < dp[2] + 1 O => dp[6] = 3
//		dp6 50 -> 10 20 40 			dp[6] = 3 < dp[3] + 1 O => dp[6] = 4 
//		dp6	50 -> 10 20 40 25		dp[6] = 4 < dp[4] + 1 X => dp[6] = 4
//		dp6	50 -> 10 20 40 25 20	dp[6] = 4 < dp[5] + 1 X => dp[6] = 4
//		-------------------------------------------------------
//		dp6	50 -> 10 20 40 50		dp[6] = 4 < dp[3] + 1
//		dp6	50 -> 10 20 25 50		dp[6] = 4 < dp[4] + 1


		
//		마무리 테스트
//		30
//		6 16 4 26 27 1 12 25 9 11 18 19 29 23 20 2 22 10 5 28 24 3 21 30 15 13 7 14 17 8
		Arrays.sort(dp); // 정렬해서 최대값을 맨 뒤로 보낸다.
		System.out.println(dp[n-1]);

	}

}