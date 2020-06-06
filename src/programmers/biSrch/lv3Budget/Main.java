package programmers.biSrch.lv3Budget;

public class Main {

	public static void main(String[] args) {
//		int[] budgets = {120, 110, 140, 150};
//		int M = 485;
		int[] budgets = {1,1,1,1,1};
		int M = 1000000000;
//		int[] budgets = {1,2,3,4,5};
//		int M = 1000000000;
//		int[] budgets = {9,8,5,6,7};
//		int M = 5;
		
		System.out.println(solution(budgets, M));
	}

	public static int solution(int[] budgets, int M) {
//		int lV = M;
		int lV = 0;
		int rV = 0;
		for(int i = 0; i < budgets.length; i++) {
//			lV = Math.min(lV, budgets[i]); // 이게 있으면 위에 네번째 테케를 못품.  
			rV = Math.max(rV, budgets[i]);
		}
		int mid = rV/2;
		int ans = 0;
		
		while(lV <= rV) {
			int tmp = 0;
			for(int i = 0; i < budgets.length; i++) {
				if(budgets[i] > mid) tmp += mid;
				else tmp += budgets[i];
			}
		
			if(tmp > M) {
				rV = mid - 1;
			} else {
				lV = mid + 1;
				ans = Math.max(mid, ans);
			}
			mid = (lV+rV)/2;
		}
		
		
		return ans;
	}
}
