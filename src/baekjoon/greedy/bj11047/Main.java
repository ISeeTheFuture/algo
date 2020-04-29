package baekjoon.greedy.bj11047;

import java.util.Scanner;

public class Main {

	//변수선언
	static Scanner sc = new Scanner(System.in);
	static long n;
	static long k;
	static long[] a;
	static long[] used; // 사용한 코인의 개수
	static int ans;
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextLong();
		k = sc.nextLong();
		
		a = new long[(int) n];
		used = new long[(int) n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		for(int i = 0; i < n; i++) { // 내림차순 정렬
			for(int j = i; j < n; j++) {
				if(a[i]<a[j]) {
					long tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		
		
		// 연산부
		for(int i = 0; i < n; i++) {
			used[i] = k/a[i];
			k = k%a[i];
//			System.out.println(used[i]);
//			System.out.println(k);
			ans += used[i];
		}
		
		
		System.out.println(ans);

	}
}
