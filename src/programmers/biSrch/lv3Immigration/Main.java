package programmers.biSrch.lv3Immigration;

public class Main {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		long ans = Long.MAX_VALUE;
		long left = 0;
		long right = 0;
		long mid;

		for (int time : times) { // 굳이 필요는 없지만, 연산 횟수 줄이기 위해
			right = Math.max(time, right);
		}
		right *= n;
		
		while (left <= right) {
			long tmp = 0;
			mid = (left + right)/2;
			
			for (int time : times) {
				tmp += mid / time;
			}
//			System.out.println("tmp : "+tmp);
//			System.out.println("left : "+left);
//			System.out.println("mid : "+mid);
//			System.out.println("right : "+right);
			if (tmp < n) { // n개 심사해야되는데 tmp가 그에 미달할 경우. 답이 우측 어딘가 존재.
				left = mid + 1; // 일단 좌측 값을 미드로
			} else if (tmp >= n) { // n개 이상 심사는 해서, 답이 좌측 어딘가 존재.
				ans = Math.min(ans, mid);
				right = mid - 1; // 일단 우측 값을 미드로.
			}
//			System.out.println("ans : "+ans);
//			System.out.println();
		}
		return ans;
	}
}
