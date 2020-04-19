package codeup.hundred.h1098;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		int[][] st = new int[h][w];
		
		//여기서부터 입력부
		for(int a = 0; a < n; a++) {
			int i = sc.nextInt();
			int d = sc.nextInt();
			int x = sc.nextInt()-1; // h
			int y = sc.nextInt()-1; // w
			for(int b = 0; b < i; b++) {				
				if(d==0) {
					st[x][y+b] = 1;
				}
				else {
					st[x+b][y] = 1;
				}
			}	
		}
		//여기서부터 출력부
		for(int a = 0; a < st.length; a++) {
			for(int b = 0; b < st[a].length; b++) {
				System.out.print(st[a][b]+" ");
			}
				System.out.println("");
		}
	}
}
