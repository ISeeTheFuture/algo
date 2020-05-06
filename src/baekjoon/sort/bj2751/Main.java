package baekjoon.sort.bj2751;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static Integer[] ns; // int[]은 Collections에 사용할 수 없어 내림차순 정렬 불가능
	
	
	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		ns = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			ns[i] = sc.nextInt();
		}

		Arrays.sort(ns); // 오름차순, 그리고 얘가 바로 quick sort 방식을 사용함.(정확히는 개선판인 dual pivot quicksort)
						// 반면, Collections.sort 는 merge sort
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(Integer i:ns) {
			bf.write(i+"\n");
		}
		bf.flush();
	}
}