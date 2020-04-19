package codeup.hundred.h1096;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = 19;
		int y = 19;
		int[][] nums = new int[x][y];
		for(int i = 0; i < n; i++) {
			nums[sc.nextInt()-1][sc.nextInt()-1] = 1;
		}
		for(int j = 0; j <nums.length; j++) {
			for(int k = 0; k < nums[j].length; k++) {
				System.out.print(nums[j][k]+" ");
			}
			System.out.println("");
		}
	}
}
