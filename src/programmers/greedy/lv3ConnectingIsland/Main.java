package programmers.greedy.lv3ConnectingIsland;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		int n = 4;
//		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n = 5;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 3 }, { 2, 3, 8 }, { 3, 4, 1 } };

		System.out.println(solution(n, costs));
	}
	
	// 이 풀이법이 문제의 의도에 맞게 푼 것인지는 모르겠음. 내가 보기엔 연결할 수 없는 섬은 없다는 옆구리를 찌른거 같은데...
	public static int solution(int n, int[][] costs) {
		int ans = 0;
		int[][] map = new int[n][n]; // 인접 행렬
		for (int i = 0; i < costs.length; i++) {
			map[costs[i][0]][costs[i][1]] = map[costs[i][1]][costs[i][0]] = costs[i][2];
		}
		boolean[] visit = new boolean[n];
		List<Integer> bridge = new ArrayList<>(n + 1);
		bridge.add(0); // idx 0에 0을 넣는다. 이유 : 일단 0부터 출발
		visit[0] = true; // 다리 도착점 방문 여부. 일단 0부터 출발하므로, 0은 방문했다고 가정하고 시작해야 도착점 방문 여부로 쓸 수 있다.

		while (bridge.size() < n) { // 섬 n개를 모두 잇는데 필요한 다리는 무조건 n-1개. 편의를 위해 n+1 크기만큼 선언해 놓음.
			int min = Integer.MAX_VALUE; // 비교를 위해 일단 변수 최대값
			int minIdx = -1;
			
			// 1페이즈
				// 0 -> N 가는 최소값 탐색
			// 2페이즈
				// 0 -> M 가는 최소값 탐색
				// N -> M 가는 최소값 탐색
			// 3페이즈
				// 0 -> K 가는 최소값 탐색
				// N -> K 가는 최소값 탐색
				// M -> K 가는 최소값 탐색
			//...
			for (int island = 0; island < bridge.size(); island++) {
				int i = bridge.get(island);
				for (int j = 0; j < n; j++) {
					if (!visit[j] && i != j && map[i][j] > 0 && map[i][j] < min) {
						min = map[i][j];
						minIdx = j;
					}
				}
			}
			visit[minIdx] = true;
			bridge.add(minIdx);
			ans += min;
		}
		return ans;
	}
}