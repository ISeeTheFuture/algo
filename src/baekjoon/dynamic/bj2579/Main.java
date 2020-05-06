package baekjoon.dynamic.bj2579;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] ns;
	static long[] dp;
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		ns = new int[n+1];
		dp = new long[n+1];
		
		for(int i = 1; i <= n; i++) {
			ns[i] = sc.nextInt();
		}
		if(n==0) {
			System.out.println(0);
			return;
		} else if(n==1) {
			System.out.println(ns[1]);
			return;
		} else if(n==2) {
			System.out.println(ns[1]+ns[2]);
			return;
		}
		// 연산부
		ns[0] = 0;
		dp[0] = 0;
		// dp0 = 0
		// dp1 = 1
		// dp2 = 1 + 2
		// dp3 = 1 + 3 또는 2 + 3 => dp(i-2) + i 또는 dp(i-3) + (i-1) + i
		
		// dp4 = 1 2 4 또는 1 3 4 => dp(i-2) + i 또는 dp(i-3) + (i-1) + i
		
		// dp5 = 1 2 4 5 => dp(i-3) + (i-1) + i
		// dp5 = 1 3 5 / 2 3 5 => dp(i-2)+i
		
		dp[1] = ns[1];
		dp[2] = ns[1]+ns[2];
		for(int i = 3; i <= n; i++) {
			long tmp1 = dp[i-3] + ns[i-1] + ns[i];
			long tmp2 = dp[i-2] + ns[i];
			
			dp[i]=Math.max(tmp1, tmp2);
//			System.out.println(dp[i]);
		}
		
		System.out.println(dp[n]);

		// 9
		// 20 1 20 1 20 1 20 5 1
		// dp[n]의 최대값
		// dp의 최대값
		// dp[8] = 85
		// dp[9] = 81
	}

}
