package baekjoon.backtrack.bj15652;

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
		int j;
		if (a >= m) { // 마지막 m개 까지 탐색했다면
			String tmp = "";
			
			for(j = 0; j < m - 1; j++) {
				if(list[j] > list[j+1]) break; // 배열 중에 하나라도 오름차순으로 되어 있지 않다면 break
			}
			
			if(j == m-1) {
				for(int i = 0; i < m; i++) {
					tmp += list[i] + " ";
				}
				bf.write(tmp+"\n");
				bf.flush();		
			}
			return;				
		}
		
		for(int i = 1; i <= n; i++) {// 1 ~ n 까지 
			list[a] = i;
			bt(a+1); // 레벨링
		}
	}
}
