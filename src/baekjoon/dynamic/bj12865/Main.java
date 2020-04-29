package baekjoon.dynamic.bj12865;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int n;
	static int k;
	static ArrayList<Integer>[] list;
	static Point[] p;
	static int[] ans;
	
	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();
		ans = new int[k+1];
		p = new Point[n];
		
		int heavy = 0;
		for(int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			p[i] = new Point(w,v);
			heavy = heavy<w?w:heavy;
		}
		
		if(heavy > k) {
			list = new ArrayList[heavy+1];			
		} else list = new ArrayList[k+1];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
			list[i].add(0);
		}
		for(int i = 0; i < p.length; i++) {
			int w = p[i].x;
			int v = p[i].y;
			
			list[w].set(0, v);
		}

		for(int i = 0; i < ans.length; i++) {
			ans[i] = 0;
		}
		
//		for(int i = 0; i < list.length; i++) { // 테스트용 코드
//			System.out.println(list[i]);
//		}
		
		
		
		for(int i = 1; i <= k; i++) {
			int tmpV = 0;
			for(int j = 1; j <= i; j++) {
				tmpV = list[i-j].get(0) + list[j].get(0);
				if(ans[i]<tmpV) {
					ans[i] = tmpV;
				}
			}
		}
		System.out.println(ans[k]);

	}

}
