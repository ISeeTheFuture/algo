package baekjoon.search.bj11403.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//12부터는 시간초과나서 fail
//5
//0 1 1 1 0
//1 0 1 1 0
//1 1 0 1 0
//1 1 1 0 0
//1 1 1 1 0
//
//10
//0 1 1 1 1 1 1 1 1 0
//1 0 1 1 1 1 1 1 1 0
//1 1 0 1 1 1 1 1 1 0
//1 1 1 0 1 1 1 1 1 0
//1 1 1 1 0 1 1 1 1 0
//1 1 1 1 1 0 1 1 1 0
//1 1 1 1 1 1 0 1 1 0
//1 1 1 1 1 1 1 0 1 0
//1 1 1 1 1 1 1 1 0 0
//1 1 1 1 1 1 1 1 1 0
//
//11
//0 1 1 1 1 1 1 1 1 1 0
//1 0 1 1 1 1 1 1 1 1 0
//1 1 0 1 1 1 1 1 1 1 0
//1 1 1 0 1 1 1 1 1 1 0
//1 1 1 1 0 1 1 1 1 1 0
//1 1 1 1 1 0 1 1 1 1 0
//1 1 1 1 1 1 0 1 1 1 0
//1 1 1 1 1 1 1 0 1 1 0
//1 1 1 1 1 1 1 1 0 1 0
//1 1 1 1 1 1 1 1 1 0 0
//1 1 1 1 1 1 1 1 1 1 0
//
//12
//0 1 1 1 1 1 1 1 1 1 1 0
//1 0 1 1 1 1 1 1 1 1 1 0
//1 1 0 1 1 1 1 1 1 1 1 0
//1 1 1 0 1 1 1 1 1 1 1 0
//1 1 1 1 0 1 1 1 1 1 1 0
//1 1 1 1 1 0 1 1 1 1 1 0
//1 1 1 1 1 1 0 1 1 1 1 0
//1 1 1 1 1 1 1 0 1 1 1 0
//1 1 1 1 1 1 1 1 0 1 1 0
//1 1 1 1 1 1 1 1 1 0 1 0
//1 1 1 1 1 1 1 1 1 1 0 0
//1 1 1 1 1 1 1 1 1 1 1 0
//
//
//15
//0 1 1 1 1 1 1 1 1 1 1 1 1 1 0
//1 0 1 1 1 1 1 1 1 1 1 1 1 1 0
//1 1 0 1 1 1 1 1 1 1 1 1 1 1 0
//1 1 1 0 1 1 1 1 1 1 1 1 1 1 0
//1 1 1 1 0 1 1 1 1 1 1 1 1 1 0
//1 1 1 1 1 0 1 1 1 1 1 1 1 1 0
//1 1 1 1 1 1 0 1 1 1 1 1 1 1 0
//1 1 1 1 1 1 1 0 1 1 1 1 1 1 0
//1 1 1 1 1 1 1 1 0 1 1 1 1 1 0
//1 1 1 1 1 1 1 1 1 0 1 1 1 1 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 0
//1 1 1 1 1 1 1 1 1 1 1 0 1 1 0
//1 1 1 1 1 1 1 1 1 1 1 1 0 1 0
//1 1 1 1 1 1 1 1 1 1 1 1 1 0 0
//1 1 1 1 1 1 1 1 1 1 1 1 1 1 0


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
		if(visited[a]) return;
		list[a].add(b);
		visited[b] = true;
		
		for(int i = 1; i < arrSize; i++) {
			if(!visited[i]&&arr[b][i]==1) dfs(a, i);
		}
		visited[b] = false;
	}
}
