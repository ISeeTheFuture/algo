package baekjoon.bj2667.dfs;

import java.util.Arrays;
import java.util.Scanner;


// DFS 로 풀어본 백준 2667
public class Main {

	//변수 선언부
	static Scanner sc = new Scanner(System.in);
	static int n; //지도의 크기
	static int[][] map; // 지도 int배열
	static boolean[][] visited;  // 방문 여부 boolean 배열
	static int grpId;  // 단지 번호
	static int[] grps;  // 각 단지별 집의 수
	static int dx[] = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static int dy[] = {1, -1, 0, 0}; // 상, 하, 좌, 우
	
	
	// 메인 함수
	public static void main(String[] args) {		
		// 문제 입력부 : 변수 입력
		n = sc.nextInt(); // 지도의 크기 N
		
		map = new int[n][n]; // 지도 int배열
		visited = new boolean[n][n]; // 방문 여부 boolean 배열
		String tmp; // 망할 백준이 입력를 C++ 기준으로 던져줌.
		
		grpId = 0; // 단지 번호
		grps = new int[n*n]; // 각 단지별 집의 수. n*n 인 이유는 편의상 최대값.
		
		//문제 입력부 : 지도 입력
		for(int i = 0; i < n; i++) {
			tmp = sc.next();
			for(int j = 0; j < n; j++) {
				map[i][j] = tmp.charAt(j)-'0'; // char '0'을 빼줌으로써 char 숫자를 int형으로 변환.
			}
		}
		
		
		// 전체 지도 탐색
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				// 주택이면서(1이면서) 방문하지 않았다면 if문 접근해 새로운 단지넘버 부여
				if(map[i][j]==1 && !visited[i][j]) {
					grpId++; //  단지넘버 부여					
					// 탐색
					dfs(i, j);
				}
			}
		}
		
		
		// 출력부
			// 출력 조건 꼭 확인.
		Arrays.sort(grps);
		System.out.println(grpId); // 답안 첫째줄. 총 단지수. grpId가 순서대로 증가하였으므로, 이거 그대로 주면 됨.
		
		for(int i = 0; i < grps.length; i++) {
			if(grps[i] != 0) { // 기존에 49개 grpId를 미리 확보해 놓았으므로,있는 번호만 출력.
				System.out.println(grps[i]); // 답안 둘째줄~ 각 단지별 주택 갯수 출력.				
			}
		}
	}
	
	public static void dfs(int x, int y) {
		// 방문처리
		visited[x][y] = true; // 방문했으므로 방문 처리
		grps[grpId]++; // grpId번 단지의 갯수 카운트
		
		// 상하좌우 주변 "탐색"
			// ☆★ "탐색"과 "방문처리"를 구분해 생각할 것 ☆★
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			

			// 만약 nx, ny 좌표가 "지도 내에 존재할 때"
				// 즉, 지도 밖으로 벗어나지 않았을 때 
			if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
				if(map[nx][ny] == 1 && !visited[nx][ny]) { // 주택인 것, 그리고 방문하지 않았다는 것 다시 확인. 이게 없으면 무한루프 => 스택 오버플로우
					dfs(nx, ny); // 재귀 함수.
					// 탐색된 해당 주변지를 방문으로 처리하고, grpId 번 단지의 갯수 카운트					
				}
			}
			
		}
		
	}

}
