package baekjoon.search.bj11403;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static List<Integer>[] list;
	static int[][] arr;
	static int arrSize;
	static Boolean[] visited;
	
	public static void main(String[] args) {
		// 입력부
		arrSize = sc.nextInt()+1;
		arr = new int[arrSize][arrSize];
		list = new ArrayList[arrSize];
		visited = new Boolean[arrSize];
		
		
		
		for(int i = 1; i < arrSize; i++) {
			list[i] = new ArrayList<Integer>();
			visited[i] = new Boolean(false);
		}
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
			
		}
		
		// 연산부
		for(int i = 1; i < arrSize; i++) {
			for(int j = 1; j < arrSize; j++) {
				if(arr[i][j] != 0) dfs(i, j);
			}
		}
		
		// 출력부
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < arrSize; i++) {
			for(int j = 0; j < list[i].size(); j++) {
				arr[i][list[i].get(j)] = 1;
			}
			for(int j = 1; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void dfs(int a, int b) {
		if(list[a].contains(b)) return; // DFS 가지치기 : 쓸데없는 중복 연산 줄여줌. 이거 없으면 시간초과. 
		if(visited[a]) return; // 재귀 종료
		
		list[a].add(b); // 새로운 좌표일 경우, 답안 배열에 추가.
		
		visited[b] = true;		
		for(int i = 1; i < arrSize; i++) {
			if(!visited[i]&&arr[b][i]==1) dfs(a, i);
		}
		visited[b] = false;
	}
}