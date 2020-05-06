package baekjoon.divide.bj2630;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[][] map;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		n = sc.nextInt();
		map = new int[n][n];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 연산부
		dnc(map, 0, 0, n);
		
		
		System.out.println(sb.toString());
		int wNum = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)=='0') wNum++;
		}
		int bNum = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)=='1') bNum++;
		}
		
		System.out.println(wNum);
		System.out.println(bNum);
	}

	public static void dnc(int[][] data, int x, int y, int s) {
		int color = data[x][y];
		boolean isMerged = true; 
		
		// 병합 가능 여부 체크
		for(int i = x; i < x + s; i++) {
			for(int j = y; j < y + s; j++) {
				if(color != data[i][j]) {
					isMerged = false;
					break;
				}
			}
		}
		
		// 1. 병합이 가능한 경우
		if(isMerged) {
			sb.append(color);
			return; // 이거 없으면 stack Overflow
		}
		
		// 2. 병합이 불가능한 경우 : 4분할
		int newS = (int) (s*0.5);
		sb.append("(");
		dnc(data, x, y, newS);
		dnc(data, x, y+newS, newS);
		dnc(data, x+newS, y, newS);
		dnc(data, x+newS, y+newS, newS);
		sb.append(")");
	}
}
