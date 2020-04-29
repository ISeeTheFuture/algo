package baekjoon.greedy.bj2875;

import java.util.Scanner;

public class Main {

	// 남학생 * 2 보다 여자가 많으면 여자에서 -1
		// 적으면 남자에서 -1
		// 같을 경우 남자에서 -1
	
	// 변수선언
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int k;
	
	public static void main(String[] args) {
		// 변수 입력부
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		// 남자는 여성 인원수의 1/2이 되도록 맞춰야만 팀 구성이 원활하다.
			// 이 규칙에 맞게 차례로 n이나 m에서 -1 씩 감해준다.
		for(int i = 0; i < k; i++) {
			if(n>m*2) n -= 1;
			else m -= 1;
		}
		
		while(true) { // k를 전부 감했음에도 남자 인원이 남는다면, 여자 인원에 맞춰 남자 인원을 감해준다.
			if(n>=m *2) break;
			else m -= 1;
		}
		
		System.out.println(m);// 답안으로 제출할 팀 수는 남자 인원 수를 그대로 출력하면 된다.
		
		

	}

}
