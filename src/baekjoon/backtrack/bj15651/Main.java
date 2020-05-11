package baekjoon.backtrack.bj15651;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int[] list;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		n = sc.nextInt(); // n까지의 자연수
		m = sc.nextInt(); // m개
		list = new int[n+1];
		
		bt(0);

		return;
	}

	public static void bt(int a) throws IOException {
		if (a >= m) { // 마지막 m개 까지 탐색했다면
			String tmp = "";
			for(int i = 0; i < m; i++) {
				tmp += list[i] + " ";
			}
			bf.write(tmp+"\n");
			bf.flush();		
			return;
		}
		
		for(int i = 1; i <= n; i++) {// 1 ~ n 까지 
			list[a] = i;
			bt(a+1); // 레벨링
		}
	}
}
