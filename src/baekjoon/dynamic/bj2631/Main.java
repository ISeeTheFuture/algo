package baekjoon.dynamic.bj2631;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] c;
	static int[] dp;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		c = new int[n];
		dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			c[i] = sc.nextInt();
		}
		
		// 해설
		// 3 7 5 2 6 1 4
		// dp[1] 3 => 3 : 1
		// dp[2] 7 => 3 7 : 2
		// dp[3] 5 => 3 7 5 : 2

		// dp[4] 2 =>  : 정렬 기준점 없음 : 1

		// dp[5] 6 => 3 5 2 : 3개 경우
				//	3 기준 : 1+1 : 2
				//	5 기준 : 2+1 : 3
				//	2 기준 : 1+1 : 2
		
			// 5를 기준으로 했을 때
				// 5는 또 3을 기준으로 했으므로
				// 3 5 6 => 기준점 3개
				// 전체 5 - 3 => 2만큼만 바꾸면 됨.
			// 
			// 3 7 5 2 6 => 3 5 6 은 고정하고 7 2만 움직여서 
			//	=>  2 3 7 5 6 => 2 3 5 6 7
		
		
		// 연산부
		for(int i = 0; i < n; i++) {
			if(dp[i] == 0) dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(c[i] > c[j]) {
					if(dp[i] < dp[j] + 1) { 
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		Arrays.sort(dp); // 정렬해서 최대값을 맨 뒤로 보낸다.
		System.out.println(n-dp[n-1]);
		
	}

}
