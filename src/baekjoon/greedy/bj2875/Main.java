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
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		
		for(int i = 0; i < k; i++) {
			if(n>m*2) n = n - 1;
			else m = m - 1;
		}
		
		while(true) {
			if(n>=m *2) break;
			else m = m - 1;
		}
		
		System.out.println(m);
		
		

	}

}
