package codeup.hundred.h1097;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 19;
		int y = 19;
		int[][] nums = new int[x][y];
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++ ) {
				nums[i][j] = sc.nextInt();
			}
		}
		
		int n = sc.nextInt(); // 변환 횟수
		for(int i = 0; i < n; i++) { // 변환부
			int x_ = sc.nextInt()-1;
			int y_ = sc.nextInt()-1;
			
			//가로줄 흑백 바꾸기
			for(int j = 0; j < x; j++) {
				if(nums[x_][j] == 0) nums[x_][j] = 1;
				else nums[x_][j] = 0;
			}

			//세로줄 흑백 바꾸기
			for(int k = 0; k < x; k++) {
				if(nums[k][y_] == 0) nums[k][y_] = 1;
				else nums[k][y_] = 0;
			}
			
		}
		
		for(int a = 0; a <nums.length; a++) {//출력부
			for(int b = 0; b < nums[a].length; b++) {
				System.out.print(nums[a][b]+" ");
			}
			System.out.println("");
		}
	}
}
