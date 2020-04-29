package baekjoon.dynamic.bj2748;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static long[] arr;
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		arr = new long[n+2];// 0부터 시작하므로 크기를 하나 만큼 늘려준다.
		
		// DP 케이스 : 문제에서 주어짐
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
		
	}

}
