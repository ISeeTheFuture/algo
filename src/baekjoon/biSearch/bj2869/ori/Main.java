package baekjoon.biSearch.bj2869.ori;

import java.util.Scanner;

// 대체 이게 왜 이분탐색???
	//NA-(N-1)B = V
	//NA-NB+B
	//N(A-B)+B = V
	//N(A-B)= V-B
	//N = (V-B)/(A-B)
public class Main {

	static Scanner sc = new Scanner(System.in);
	static double a;
	static double b;
	static double v;
	
	public static void main(String[] args) {
		a = sc.nextDouble();
		b = sc.nextDouble();
		v = sc.nextDouble();
		
		int ans = (int) Math.ceil((v-b)/(a-b));
		
		System.out.println(ans);
	}
}
