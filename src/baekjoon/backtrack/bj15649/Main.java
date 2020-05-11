package baekjoon.backtrack.bj15649;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int m;
	static int[] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		n = sc.nextInt(); // n까지의 자연수
		m = sc.nextInt(); // m개
		visited = new boolean[n+1]; // 방문 여부
		list = new int[n+1]; // 답으로 제출할 수열
		
		bt(0);

		return;
	}

	public static void bt(int a) {
		if (a >= m) { // 마지막 m개 까지 탐색했다면
			for(int i = 0; i < m; i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {// 1 ~ n 까지 
			if(!visited[i]) { // 숫자 겹치지 않게
				visited[i] = true; // 이미 i에 방문한 것으로 가정하고 하위 트리에 진입하기 위해 true로 설정
				list[a] = i;
				bt(a+1); // 레벨링
				visited[i] = false; // 동일 레벨 트리에서는 false로 두고 시작해야 하므로.
			}
		}
	}
}
