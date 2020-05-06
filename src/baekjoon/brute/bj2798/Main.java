package baekjoon.brute.bj2798;

import java.util.Scanner;

public class Main {

	
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int limit;
	static int[] ns;
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		limit = sc.nextInt();
		ns = new int[n];
		
		for(int i = 0; i < n; i++) {
			ns[i] = sc.nextInt();
		}
		
		
		// 연산부
		int result = 0;
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				for(int k = j+1; k < n; k++) {
					int tmp = ns[i] + ns[j] + ns[k] ;
					if(tmp <= limit) result = Math.max(result, tmp);
				}
			}
		}
		System.out.println(result);
	}
}