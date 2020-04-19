package codeup.hundred.h1099;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] st = new int[10][10];
		int b_ = 1;
		//여기서부터 입력부
		for(int a = 0; a < st.length; a++) {
			for(int b = 0; b < st[a].length; b++) {				
				st[a][b] = sc.nextInt();
			}	
		}
		
		//여기서부터 연산부
		outer:
		for(int a = 2-1; a < st.length; a++) {
			for(int b = b_; b < st[a].length; b++) {
				if(st[a][b]==0) {
					st[a][b] = 9;
					b_++; // 길 확정이므로 전진
				}
				else if(st[a][b]==2) {
					st[a][b] = 9;
					break outer;
				}
				else {
					b_--; // 길이 없으므로 후퇴
					break;
				}
			}	
		}
		// 여기서부터 출력부
		for(int a = 0; a < st.length; a++) {
			for(int b = 0; b < st[a].length; b++) {				
				System.out.print(st[a][b]+" ");
			}	
			System.out.println("");
		}
	}
}
