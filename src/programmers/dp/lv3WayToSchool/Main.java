package programmers.dp.lv3WayToSchool;


public class Main {

	public static void main(String[] args){

		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};

		System.out.println(solution(m, n, puddles));
	}

	// Map형 DP 문제. pratice 패키지의 "가장 큰 정사각형"과 유사
		//	0 0 0 0 0
		//	0 1 1 1 1
		//	0 1 0 1 2
		//	0 1 1 2 4
			// 0은 벽이나 웅덩이
			// 0 이상의 각 숫자는 해당 지점까지 갈 수 있는 경우의 수를 의미.
			// 경우의 수 표현식 : map[i][j] = map[i-1][j] + map[i][j-1]
    public static int solution(int m, int n, int[][] puddles) {
    	int[][] map = new int[m+1][n+1];
    	map[1][1] = 1;
    	for(int i = 0; i < puddles.length; i++) {
    		map[puddles[i][0]][puddles[i][1]] = -1;
    	}
    	
    	
    	for(int i = 1; i < map.length; i++) {
    		for(int j = 1; j < map[i].length; j++) {
    			if(i==1&&j==1) continue; // 시작점인 map[1][1]의 경우는 이미 넣어 놨으므로 생략
    			if(map[i][j]==-1) map[i][j] = 0; // 다음 연산에 써줘야 하므로 0으로 바꿔준다.
    			else {
    				map[i][j] = (map[i-1][j] + map[i][j-1])%1000000007; // 문제에서 저걸로 나눠주라 했으므로ㅡㅡ
    			}
    		}
    	}
    	
        return map[m][n];
    }
}