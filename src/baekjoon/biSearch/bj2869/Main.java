package baekjoon.biSearch.bj2869;

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		int left = 0;
		int right = v;
		int mid = v;
		int ans = v;
		
		int n = 1;
		while(left < right) {
			System.out.println("--------------------");
			System.out.println("페이즈 : "+ n++);
			mid = (left + right)/2; // mid 기준 : 날짜
			System.out.println("mid : " + mid);
			if((mid-1)*(a-b)+a >= v){ //  (n-1)일밤낮 * (낮 - 밤) + n일차낮 
				right = mid;
				ans = Math.min(ans,  mid); // 최소값 구하는 것이므로
				System.out.println("right : "+right);
				System.out.println("ans : "+ ans);
			} else {
				left = mid + 1;
				System.out.println("left : "+left);
			}
		}
		System.out.println(ans);
		
	}

}
