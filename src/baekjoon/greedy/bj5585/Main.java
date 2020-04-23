package baekjoon.greedy.bj5585;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수부
		int n = sc.nextInt(); // 물건 가격
			// 그리디 매커니즘 이해
				// (1000-n)
				// (1000-n)%500
				// (1000-n)%500%100
		int[] coin = {500,100,50,10,5,1}; // 계산에 쓸 동전들. 500원부터 차례대로 계산.
		int cnt = 0; // 동전 갯수
		int remain = 1000-n; // 그리디 연산에 사용할 나머지 계산 변수 
		
		// 연산부
		for(int i = 0; i < coin.length; i++) {
			if(remain/coin[i] != 0) {
				cnt += remain/coin[i]; // 나눠서 동전개수 구하기
				remain = remain%coin[i]; // 다음 연산에 사용할 잔금
//				System.out.println("나머지 : " + remain);
//				System.out.println(coin[i]+" 동전 카운트 : " + cnt);				
			}
		}
		
		// 답안
		System.out.println(cnt);
	}

}
