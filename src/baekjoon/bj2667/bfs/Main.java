package baekjoon.bj2667.bfs;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//BFS 로 풀어본 백준 2667
public class Main {

	//변수 선언부
	static Scanner sc = new Scanner(System.in);
	static int n; //지도의 크기
	static int[][] map; // 지도 int배열
	static boolean[][] visited;  // 방문 여부 boolean 배열
	static int grpId;  // 단지 번호
	static int[] grps;  // 각 단지별 집의 수
	static Queue<Point> q = new LinkedList<Point>();
		// Queue : 선입선출. 랜덤접근 불가능한 선형 자료구조
		// Point :  Point(a,b) 형태로 사용. 원래 원 만들 때 쓰는 용도의 클래스인듯. 마침 7*7 지도 형태 좌표이므로 사용하기 좋을듯.
			// int x = q.peek().x ; 의 방식으로 Point의 변수까지 접근 가능. peek().x, peek().y 로 xy로만 꺼낼 수 있음. 
	static int dx[] = {0, 0, -1, 1}; // 상, 하, 좌, 우, direction x
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
					bfs(i, j);
				}
				
			}
		}
		
		
		// 출력부
			// 출력 조건 꼭 확인.
		Arrays.sort(grps);
		System.out.println(grpId); // 답안 첫째줄. 총 단지수. grpId가 순서대로 증가하였으므로, 이거 그대로 주면 됨.
		
		for(int i = 0; i < grps.length; i++) {
			if(grps[i] != 0) { // 기존에 25개 grpId를 미리 확보해 놓았으므로,있는 번호만 출력.
				System.out.println(grps[i]); // 답안 둘째줄~ 각 단지별 주택 갯수 출력.				
			}
		}

	}
	
	public static void bfs(int x, int y) {
		
		visited[x][y] = true; // 방문했으므로 방문 처리
		grps[grpId]++; // grpId번 단지의 갯수 카운트
		
		q.offer(new Point(x, y));
		
		
		while(!q.isEmpty()) {
			Point now = q.poll(); // 선입 선출. 가장 먼저 들어간 값 하나를 now로 뽑아옴.
			
			for(int i=0; i < 4; i++) { // 주변 네 방향 탐색
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				// 상하좌우 주변 탐색
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) { // 만약 지도 바깥이 아니라면
					if(map[nx][ny] == 1 && !visited[nx][ny]) { // 주택인 것, 그리고 방문하지 않았다는 것 다시 확인. 이게 없으면 무한루프 => 스택 오버플로우
						q.offer(new Point(nx,ny)); // 현재 좌표 잡아서 큐에다 집어넣음.
						visited[nx][ny] = true; // 해당 좌표를 방문처리
						grps[grpId]++; // 깨알같이 단지 갯수는 늘려주고.
					}
				}
			}
		}
	}
}
