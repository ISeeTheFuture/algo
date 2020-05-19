package programmers.dp.lv3Tile;


public class Main2 {

	public static void main(String[] args){
		int N = 5;


		System.out.println(solution(N));
	}

	
	public static long solution(int N) {
		//		dp0 = 0
		//		dp1 = 1*4
		//			= 4
		//		dp2 = dp1-1 + 1*3
		//			= dp1+1*2
		//			= 4+2 = 6
		//		dp3 = dp2-2+2*3
		//			= dp2+2*2
		//			= 6+4 = 10
		//		dp4 = dp3-3+3*3
		//			= dp3+3*2
		//			= 10+6 = 16
		//		dp5 = dp4-5+5*3
		//			= dp4+5*2	
		
		// 입력부 : 0,1,1,2,3,5,8...
		int[] fibo = new int[N+1];
		fibo[0] = 0;
		fibo[1] = 1;
		if(N>2) {
			for(int i = 2; i < fibo.length; i++) {
				fibo[i] = fibo[i-1]+fibo[i-2];
			}			
		}
		
		// 연산부
		if(N==1) return 4; // 예외적인 경우 일단 처리
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 4;
		for(int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1]+fibo[i]*2;
		}
		
		return dp[N];
	}
}