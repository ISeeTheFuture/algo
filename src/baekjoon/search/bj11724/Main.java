package baekjoon.search.bj11724;

import java.util.*;

// dfs로 풀었음.
public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;// 정점의 개수
	static int m;// 간선의 개수
	static boolean[] visited;

	// 1차원이라 얘네는 필요없음.
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
	

	// 정점과 간선만 주어지므로, 인접 리스트 활용이 유용
	static ArrayList<Integer>[] list;
	static int g = 0; // 연결 요소의 개수
	
	
	public static void main(String[] args) {

		// 변수부
		n = sc.nextInt();
		m = sc.nextInt();
		list = new ArrayList[n+1];
		visited = new boolean[n+1];

		// 입력부
		for(int i = 1; i <=n; i++) { // 인접 리스트 n개로 초기화
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) { // 양방향
										// 단방향일경우 갈림길 모양의 테스트케이스에서 막힐 수 있음.
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			list[x].add(y);
			list[y].add(x);
		}
		
//		for(int i = 1; i <= n; i++) { // 정렬해줄 필요 없음.
//			Collections.sort(list[i]);
//		}
		
		// 연산부
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				g++; // 그룹넘버 추가
				dfs(i); // 탐색 시작
			}
		}
		
		System.out.println(g);
	}
	
	public static void dfs(int x) { // dfs, bfs 뭘 써도 무방할듯.
		visited[x] = true;
		
		for(int y:list[x]) {
			if(!visited[y]) dfs(y);
		}
	}
}
