package baekjoon.dynamic.bj2579.fail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] ns;
	static long[] dp;
	static String[] dps; // 풀 수는 있었지만, => 램을 128mb
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		ns = new int[n+1];
		dp = new long[n+1];
		dps = new String[n+1];
		
		
		for(int i = 1; i <= n; i++) {
			ns[i] = sc.nextInt();
		}

		
		// 연산부
		ns[0] = 0;
		dp[0] = 0;
		dps[0] = "";
		
		for(int i = 1; i <= n; i++) {
			dp[i] = 0;
			dps[i] = "";
			
			inner:
			for(int j = 0; j < i; j++) {
				String dpsTmp = "";
				dpsTmp = dps[j] +","+ i;
				
				String[] tmpArr = dpsTmp.split(",");
				
				if(tmpArr.length >= 4) { 
					for(int k = 3; k < tmpArr.length; k++) {
						int n1 = Integer.parseInt(tmpArr[k-2]);
						int n2 = Integer.parseInt(tmpArr[k-1]);
						int n3 = Integer.parseInt(tmpArr[k]);
						
						if(n1+1 == n2 && n1+2 == n3) {// 123 연속되는지 확인
							continue inner;
						}
						if(n3 > n2+2) { // 3칸 이상 건너뛰는지 확인
							continue inner;
						}
					}					
					long tmp = dp[j] + ns[i];
					if(tmp > dp[i]) {
						dp[i] = tmp;
						dps[i] = dps[j] +","+ i;						
					}
					
				} else if(tmpArr.length < 4){
					long tmp = dp[j] + ns[i];
					if(tmp > dp[i]) {
						dp[i] = tmp;
						dps[i] = dps[j] +","+ i;						
					}					
				}
				
			}
		}
		
//		Arrays.sort(dp);
		System.out.println(dp[n]);

	}

}
