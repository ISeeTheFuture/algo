package programmers.dp.lv3Tile;


public class Main {

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
		//			= 16+10	=26
		
		// 입력부:그딴거 없다
		// 연산부
		if(N==1) return 4; // 예외적인 경우 일단 처리
		if(N==2) return 6;
		
		// 진짜는 3부터 시작이지
			//인생도 30대부터..
		long[] dp = new long[N+1];
//		dp[0] = 0;
		dp[1] = 4;
		dp[2] = 6;
		for(int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		return dp[N];
	}
}