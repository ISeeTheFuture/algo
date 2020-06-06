package baekjoon.greedy.bj1120;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	// d => 1자리
	// aabdbbc => 7자리
		// 6자리 차이
	// 앞,뒤에 다음 자릿수 만큼 추가.
	// 0,6
	// 1,5
	// 2,4
	// 3,3
	// 4,2
	// 5,1
	// 6,0
		// Math.min 으로 최소값 구할 것. 
	
	public static void main(String[] args) {
		// 변수부
		String A = sc.next();
		String B = sc.next();
		int diff = B.length()-A.length();
		int ans = Integer.MAX_VALUE;
		
		// 연산부
		for(int i = 0; i < diff+1; i++) {
			String newA = B.substring(0, i)+A+B.substring(B.length()-diff+i);
			int tmpAns = 0;
//			System.out.println(newA); // 확인용
			
			// 두 문자열 비교
			for(int j = 0; j < B.length(); j++) {
				if(newA.charAt(j)!=B.charAt(j)) tmpAns++;
			}
			
			// 최소 차
			ans = Math.min(ans, tmpAns);
		}
		
		// 출력부
		System.out.println(ans);
	}

}
