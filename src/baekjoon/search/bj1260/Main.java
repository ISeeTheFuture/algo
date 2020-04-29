package baekjoon.search.bj1260;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 인접 리스트와 인접 행렬의 개념 설명 필요
		// 인접 리스트 : 이 문제에서 쓸 것. 인접한 접점 좌표만 저장. ArrayList 로 표현하면 됨.
			// 만일 문제가 하나의 클러스터로 해결되면 인접 리스트 쓰면 됨.
		// 인접 행렬 : bj2667에서 사용했던 지도 형태. 2차원 형태의 좌표 지도. int[][] 로 표현 가능. 인접 리스트에 비해 시간복잡도가 높아서 비교적 지양해야 함.
			// 만일 문제에 여러 클러스터가 존재한다면, 인접 행렬이 필요할 수도.
	
	static Scanner sc = new Scanner(System.in);
	
	static int n; // 정점의 개수
	static int m; // 간선의 개수
	static int v; // 탐색을 시작할 정점의 번호 v
	static ArrayList<Integer>[] closed; // 인접 리스트
	static boolean[] visited; // 방문여부[n]

	static Queue<Integer> q = new LinkedList<Integer>(); //bfs용 변수
	
	
	public static void main(String[] args) {
	// 변수부
		n = sc.nextInt(); // 정점의 개수
		m = sc.nextInt(); // 간선의 개수
		v = sc.nextInt(); // 시작 정점 번호
		visited = new boolean[n+1]; // 문제의 모든 값이 1부터 시작하므로,
									// 1을 전부 0으로 바꾸기보단 헷깔리지 않도록 그냥 초기화부터 +1 한다.
		closed = new ArrayList[n+1];
		
	// 입력부
		for(int i = 1; i <= n; i++) { // 인접 리스트 초기화.
			closed[i] = new ArrayList<Integer>(); // 접점은 n개 이고 1부터 시작.
		}
		
		for(int i = 0; i < m; i++) {// 인접 리스트 입력 1 2 3 4
			int x = sc.nextInt(); // 1, 1, 1, 2, 3
			int y = sc.nextInt(); // 2, 3, 4, 4, 4

			closed[x].add(y);
			closed[y].add(x); 
		}
		
		for(int i = 1; i <= n; i++) { // 인접 리스트 정렬. 문제 조건 : 적은 것부터 방문하라
			Collections.sort(closed[i]);
		}
		
		
	// 연산부 : dfs
		dfs(v);
	// 연산부 : 방문여부 리셋
		// reset(); <- 지워줘....
		visited = new boolean[n+1];
	// 연산부 : bfs
		bfs(v);
		
	// 끝.
		sc.close();
	}

	// dfs
	public static void dfs(int x) { // v
		visited[x] = true; // 방문 체크 : 정점(노드)1번 방문 체크
		System.out.println(x); // 답안 출력
		
		for(int y:closed[x]) { // 1번에서 방문할 수 있는 모든 y만큼 for문을 돌림.
			if(!visited[y]) dfs(y); // 역시 dfs는 재귀함수
		}
	}
	// int x <- 1
	// visited 1 <- true
	// 2,3,4 중에서 가장 작은 2
	
	// int x <- 2
	// visited 2 <- true
	// '1', 4**
	
	// int x <- 4
	// visited 4 <- true
	// '1','2',3**
	
	// int x <- 3
	// visited 3 <- true
	// '1','4' 여기서 재귀함수 빠져나옴
	
	// 리셋 메소드
	public static void reset() {
//		for(int i = 1; i <= n; i++) {
//			visited[i] = false;
//		}

	}
	
	// bfs
	public static void bfs(int v) {
		q.add(v); // q에 시작 지점 저장
		visited[v] = true; // 방문 체크
		while(!q.isEmpty()) {
			int x = q.poll(); // 저장된 좌표 중 가장 먼저 것 가져오기
			System.out.println(x); // while 문 밖에 있으면 망함.
			for(int y:closed[x]) {
				if(!visited[y]) {
					visited[y] = true;
					q.add(y); // 이제  while 문 못빠져나감.
				}
			}
		}
	}
	// int v = 1
	// q <= 1 집어넣고
	// 1 : visited
	
	// while 진입
	// q => 1 을 뺀다.(q는 이제 아무것도 없게 되겠지)
	
	// 1과 연관된 애들 다 찾아보면
		// 2**, 3, 4
	
	// 2 : visited
	// q <= 2 집어넣는다.
	
	// while 종료 하려고 했지만, q에 2가 들어있어서 못나감
	// q => 2를 뺀다. (q 비었다)
	// 2와 연관된 애들
		// '1', 4**

	// 4: visited
	// q <= 4집어 넣는다. (q 다시 not null?)
	
	// while 종료하려고 했지만, q에 4가 들어있어서 못나감
	// q => 4를 뺸다. (q 또 빔)
	// 4와 연관된 애들
		// '1','2',3**

	// 3: visited
	// q <= 3 집어넣는다.
	
	// while 종료하려고 했지만, q에 3 들어있어서 못나감
	// q => 3을 뺀다. (q 또 빔)
	// 3과 연관된 애들
		// '1', '4' 전부 visited
	// 결국 q 빔
	// while 문 탈출!
	
}
