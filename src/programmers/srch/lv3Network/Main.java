package programmers.srch.lv3Network;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

		System.out.println(solution(n, computers));
	}
	
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static int solution(int n, int[][] computers) {
		// 유사 인접행렬로 되어 있는 배열을, 인접 리스트로 변환시켜야함. 
		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
			for(int j = 1; j <= n; j++) {
				if(computers[i-1][j-1]==1) {
					list[i].add(j);
				}
			}
		}
		visited = new boolean[n+1];
		int ans = 0;
		
		for(int i = 1; i < list.length; i++) {
			if(!visited[i]) {
				dfs(list, i);
				ans++;
			}
		}
		
		return ans;
	}
	
	// 늘 하던대로 재귀함수형 dfs
	public static void dfs(ArrayList<Integer>[] list, int x) {
		visited[x] = true;
		
		for(int i = 0; i < list[x].size(); i++) {
			int tmp = list[x].get(i);
			if(!visited[tmp]) dfs(list, tmp);
		}
		
	}
}