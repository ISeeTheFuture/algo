package baekjoon.backtrack.bj2580.fail;

import java.awt.Point;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int[][] map;
	static Vector<Point> s0;
	
	public static void main(String[] args) {
		// 입력부
		map = new int[9][9];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				if(tmp == 0) s0.add(new Point(i,j));
				
			}
		}
		
		// 연산부
		sudoku(0);

	}

	public static void sudoku(int rnd) {
		
		if(rnd == s0.size()) { // 게임 끝
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		int x = s0.get(rnd).x;
		int y = s0.get(rnd).y;
		
//		Vector<Integer> can = chk(x,y,z);
//		for(int i = 1; i <= 9; i++) { // 놓을 수 있는가?
//			if(chk(a, i)) {
//				map[a][i] = true;
//				bt(a+1);
//				map[a][i] = false;
//			}
//		}
//		return;
		
		
	}

//	public static Vector<Integer> chk(int x, int y, int z) {
//		// 가로줄 체크
//		for(int i = 0; i < 9; i++) {
//			if(map[x][i]==z) return false;
//		}
//		
//		// 세로줄 체크
//		for(int i = 0; i < 9; i++) {
//			if(map[i][y]==z) return false;
//		}		
//		
//		// 3*3 체크(3으로 나눈 몫에 3을 곱한 좌표 기준 3*3 탐색)
//		int i3 = (x/3)*3;
//		int j3 = (y/3)*3;
//		for(int i = i3; i < i3+3; i++) {
//			for(int j = j3; j < j3+3; j++) {
//				if(map[i][j]==z) return false;
//			}
//		}
//		
//		
//		return true;
//	}
}
