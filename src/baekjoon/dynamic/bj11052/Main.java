package baekjoon.dynamic.bj11052;

import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		// 변수선언부
		int n; // 민규가 살 카드의 장수
		int[] p; // 각 팩 별 가격 
		
		int[] ans; // 답안용 최대값 배열 
		
		// 입력부
		n = sc.nextInt();
		p = new int[n+1]; // 구매는 1부터 하므로
		ans = new int[n+1]; // 구매는 1부터 하므로
		
		for(int i = 1; i <= n; i++) { // 각 팩 별 가격 입력
			p[i] = sc.nextInt();
		}
		
		
		// 연산부
			// 카드 4개를 구매할 경우
				// 카드 1개가 들어있는 카드팩을 구매 후, 4-1개(3개)를 구입
					// p1 + p3
				// 카드 2개가 들어있는 카드팩을 구매 후, 4-2개(2개)를 구입
					// p2 + p2
				// 카드 3개가 들어있는 카드팩을 구매 후, 4-3개(1개)를 구입
					// p3 + p1
				// 카드 4개가 들어있는 카드팩을 구매 후, 4-4개(0개)를 구입
					// p4 + p0
					// 카드를 5개 산다고 가정
					// 1장 씩 구매할 때 가성비 제일 나쁨 => p1+p1+p1+p1+p1
					// p1+p4
				// 이 중에서 최대값을 구하면 됨.
		
					
				// 위를 공식으로 표현 시
					// 카드 n개를 구매하기 위해서는
					// 카드 i개가 들어있는 카드팩을 구매 => p[i]
					// 그 후, n-i개를 구매 => + p[n-i]
						// p[i] + p[n-i]
					// 위 공식에 최대값을 구하는 공식을 대입할 것.
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j <=i; j++) {
				int tmp = p[j] + ans[i-j]; // 카드 i개를 구매하기 위한 케이스j.
				ans[i] = (ans[i] >= tmp)?ans[i]:tmp; // 이전 값보다 크다면 최신화. 아니라면 내둠.
			}
			System.out.println(ans[i]);
		}
		
		
		// 출력부
//		System.out.println(ans[n]);
	}
}

