package baekjoon.dynamic.bj1932;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n; // 삼각형의 크기
	static List<int[]> tri; // 정수 삼각형 값

// 사고 과정
	
//	-1단계-
//	7
//	3 8
//	8 1 0
//	2 7 4 4
//	4 5 2 6 5
//
//	-2단계-
//	7
//	10 15
//	18 16 15
//	20 25 20 19
//	24 30 27 26 24
//
// -3단계-
//	0 7 0
//	0 10 15 0
//	0 18 16 15 0
//	0 20 25 20 19 0
//	0 24 30 27 26 24 0
	// 이후 마지막 줄의 최대값을 제출
	
	
	public static void main(String[] args) {
		// 입력부
		n = sc.nextInt();
		tri = new ArrayList<int[]>();
		
		for(int i = 0; i < n; i++) {
			int[] tmp = new int[i+3];
			for(int j = 1; j < tmp.length-1; j++) {
				tmp[j] = sc.nextInt();
			}
			tri.add(tmp);
		}
		
		// 연산부
		for(int i = 1; i < tri.size(); i++) {
			for(int j = 1; j < tri.get(i).length-1; j++) {
				tri.get(i)[j] += Math.max(tri.get(i-1)[j-1], tri.get(i-1)[j]);
			}
		}
		
		// 출력부
		Arrays.sort(tri.get(n-1));
		System.out.println(tri.get(n-1)[n+1]);
	}

}