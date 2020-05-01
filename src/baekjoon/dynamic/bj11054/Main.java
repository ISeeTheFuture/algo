package baekjoon.dynamic.bj11054;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] a;
	static int[] dpFront;
	static int[] dpBack;
	static int[] sum;
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		a = new int[n];
		dpFront = new int[n];
		dpBack = new int[n];
		sum = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(dpFront[i] == 0) dpFront[i] = 1;
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					if(dpFront[i] < dpFront[j] + 1) { 
						dpFront[i] = dpFront[j] + 1;
					}
				}
			}
		}
		for(int i = n-1; i >= 0; i--) {
			if(dpBack[i] == 0) dpBack[i] = 1;
			for(int j = n-1; j > i; j--) {
				if(a[i] > a[j]) {
					if(dpBack[i] < dpBack[j] + 1) { 
						dpBack[i] = dpBack[j] + 1;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			sum[i] = dpFront[i] + dpBack[i] - 1;
		}
		
		Arrays.sort(sum);
		System.out.println(sum[n-1]);			

	}
}
