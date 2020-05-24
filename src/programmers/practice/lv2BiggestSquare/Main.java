package programmers.practice.lv2BiggestSquare;

public class Main {

	public static void main(String[] args){
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}; // 3*3 = 9 나와야함
		
		System.out.println(solution(board));
	}
	// map형 DP 문제, 등굣길과 유사
	public static int solution(int[][] board) {
		// 입력부
		int ans = 0;
		int[][] boardArr = new int[board.length+1][board[0].length+1];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j]==1) boardArr[i+1][j+1] = 1;
				else boardArr[i+1][j+1] = 0;
			}
		}
		
		// 연산부
		for(int i = 1; i < boardArr.length; i++) {
			for(int j = 1; j < boardArr[i].length; j++) {
				if(boardArr[i][j] == 1) {
					int tmp = Math.min(boardArr[i-1][j], boardArr[i][j-1]);
					tmp = Math.min(tmp, boardArr[i-1][j-1]);
					boardArr[i][j] = tmp+1;
					ans = Math.max(ans, boardArr[i][j]);
				}
			}
		}
		return (ans*ans);
	}
}