package baekjoon.sort.bj2750;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static Integer[] ns; // int[]은 Collections에 사용할 수 없어 내림차순 정렬 불가능
	
	public static void main(String[] args) {
		n = sc.nextInt();
		ns = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			ns[i] = sc.nextInt();
		}

		Arrays.sort(ns, Collections.reverseOrder()); // 내림차순
		Arrays.sort(ns); // 오름차순
		
		for(Integer i:ns) {
			System.out.println(i);
		}
	}
}