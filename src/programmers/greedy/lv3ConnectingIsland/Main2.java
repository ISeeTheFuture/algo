package programmers.greedy.lv3ConnectingIsland;

public class Main2 {

	public static void main(String[] args){
//		int n = 4;
//		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n = 5;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,3},{2,3,8},{3,4,1}};

		System.out.println(solution(n, costs));
	}

	static boolean[] visitedIsland;
	static boolean[] visitedBridge;
	static int ans;
	
    public static int solution(int n, int[][] costs) {
    	visitedIsland  = new boolean[n];
    	visitedBridge = new boolean[costs.length];
    	ans = 2000000000;
    	
		dfs(n, costs, 0);
        return ans;
    }
	private static void dfs(int n, int[][] costs, int sum) {
    	int tmp = visitedIsland.length;
		for(int i = 0; i < visitedIsland.length; i++) {
    		if(!visitedIsland[i]) {
    			tmp--;
    			break;
    		}
    	}
		if(tmp==visitedIsland.length) {
//			System.out.println(sum);
			ans = Math.min(ans, sum);
			return;
		}		
		for(int i = 0; i < costs.length; i++) {
    		if(visitedBridge[i]) continue;
    		else {
    			visitedBridge[i] = true;
    			visitedIsland[costs[i][0]] = true; 
    			visitedIsland[costs[i][1]] = true;
    			sum += costs[i][2];
    			if(sum>=ans) return; // 중간에라도 초과값 나오면 바로 리턴
    			dfs(n, costs, sum);
    			sum -= costs[i][2];
    			visitedBridge[i] = false;
    			visitedIsland[costs[i][0]] = false; 
    			visitedIsland[costs[i][1]] = false;     			
    		}
		}
	}
}