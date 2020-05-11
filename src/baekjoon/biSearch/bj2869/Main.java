package baekjoon.biSearch.bj2869;

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		// 주의할 점 : left, right, mid, ans 는 전부 날짜. 거리 개념이 아님.
				// 채점하면 이게 맞다고 하는데, 논리적으로는 오히려 틀림.
				int left = 0;
				int right = v;
				int mid = v;
				int ans = v;
		
				// 밑에처럼 나올 수 있는 최대 날짜 값을 입력하는 것이 맞음.
					// 문제에 주어진 날짜 최대값이 없으므로, 이분탐색으로써는 문제 자체가 잘못되었다고 볼 수 있음.
		//		int left = 0;
		//		int right = 2000000000;
		//		int mid = 2000000000;
		//		int ans = 2000000000;
		
		int n = 1;
		while(left < right) {
			System.out.println("--------------------");
			System.out.println("페이즈 : "+ n++);
			mid = (left + right)/2; // mid 기준 : 날짜
			System.out.println("mid : " + mid);
			if((mid-1)*(a-b)+a >= v){ //  (n-1)일밤낮 * (낮 - 밤) + n일차낮 
				right = mid;
				ans = Math.min(ans,  mid); // 최소값 구하는 것이므로
				System.out.println("right : "+right);
				System.out.println("ans : "+ ans);
			} else {
				left = mid + 1;
				System.out.println("left : "+left);
			}
		}
		System.out.println(ans);
		
	}

}
