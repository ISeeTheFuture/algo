package baekjoon.biSearch.bj2869;

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		// 주의할 점 : left, right, mid, ans 는 전부 날짜. 거리 개념이 아님.
				// 다만, (A-B)는 무조건 1이상이므로 소요 날짜는 V값을 절대 초과할 수 없음을 추론 해야함.
//				int left = 0;
//				int right = v;
//				int mid = v;
//				int ans = v;		
		
				// 수정하면..
				int left = 0;
				int right = v/(a-b)+1;
				int mid = v/(a-b)+1;
				int ans = v/(a-b)+1;
		
				// 다른 언어라면 밑에처럼 나올 수 있는 최대 날짜 값을 수동으로 입력하는 것이 맞음.
					// 자바라서 시간초과 나고, 더 어렵게 추론해야함.
						// 문제에 주어진 날짜 최대값이 없으므로 더 어려움. 다른 언어면 그냥 변수 최대값 숫자 입력하고 끝인데.
					// 이분탐색으로써는 문제 자체의 의도가 조금 빗나갔다 볼 수 있음
					// 생각보다 이분탐색으로 풀기 어려운 문제 => 교육 목적 상으로는 좋은 문제가 아닌듯.
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
