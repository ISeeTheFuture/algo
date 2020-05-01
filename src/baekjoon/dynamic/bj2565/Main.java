package baekjoon.dynamic.bj2565;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static List<Point> line;
	static int[] dp;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		line = new ArrayList<>();
		dp = new int[n];

		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			line.add(new Point(a,b));
		}
		
		PointSort ps = new PointSort();
		Collections.sort(line, ps); // a 기준으로 정렬
		
		//LIS
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(line.get(i).y > line.get(j).y) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
//		for(int i = 0; i < dp.length; i++) {
//			System.out.println("dp"+(i+1)+" : "+ dp[i]);
//		}
		// 설명
		//		dp1 : 1
		//		dp2 : 1
		//		dp3 : 2 // dp1 + 1 해도 되고, dp2 + 1 해도 됨.
		//		dp4 : 1
		//		dp5 : 2 // dp2 + 1 , dp4 + 1
		//		dp6 : 3 // dp5 + 1
		//		dp7 : 4 // dp6 + 1
		//		dp8 : 5 // dp7 + 1
		// 1 8
		// 2 2
		// 3 9
		// 4 1
		// 6 4
		// 7 6
		// 9 7
		// 10 10
		//
		//
		
		Arrays.sort(dp); // 정렬해 최대값 구하기 => 겹치지 않는 전깃줄 최대 갯수. = 최대 유지 가능한 전깃줄 갯수
		System.out.println(n - dp[n]); // 제거할 전깃줄 갯수 = 현재 전깃줄 갯수 - 최대 유지 가능한 전깃줄 갯수
	}
	
}

// Comparable 과 Comparator
//참고 : https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
class PointSort implements Comparator<Point> {
	@Override
	public int compare(Point p1, Point p2) {
		if(p1.x > p2.x) { // 만약 p1.x가 p2.x보다 크다면
			return 1; // 바꿔
		}
		else if(p1.x == p2.x) { // 만약 p1.x가 p2.x와 같다면
			if(p1.y > p2.y) { // y 비교
				return 1; // 바꿔
			}
		}
		return -1; // 안바꿔
	}
}