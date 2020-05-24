package programmers.dp.lv3NumTriangle;


public class Main {

	public static void main(String[] args){
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};


		System.out.println(solution(triangle));
	}

	
	public static int solution(int[][] triangle) {
		// 입력부
		int[][] map = new int[triangle.length][];
		
		for(int i = 0; i < map.length; i++) {
			map[i] = new int[triangle[i].length+2];
			map[i][0] = 0;
			map[i][triangle[i].length] = 0;
			for(int j = 1; j < map[i].length-1;j++) {
				map[i][j] = triangle[i][j-1];
			}
		}
		
		// 연산부
		for(int i = 1; i < map.length; i++) {
			for(int j = 1; j < map[i].length-1; j++) {
				int tmp;
				tmp = Math.max(map[i][j]+map[i-1][j-1], map[i][j]+map[i-1][j]);
				map[i][j] = tmp;
			}
		}
		
		// 출력부
		int ans = 0;
		for(int i = 1; i < map[triangle.length-1].length-1; i++) {
			ans = Math.max(ans, map[triangle.length-1][i]);
		}
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
				
		return ans;
	}
}