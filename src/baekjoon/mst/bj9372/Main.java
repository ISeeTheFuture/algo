package baekjoon.mst.bj9372;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	//변수선언
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			ArrayList<Integer>[] list = new ArrayList[sc.nextInt()+1];
			for(int j = 1; j < list.length; j++) {
				list[j] = new ArrayList<Integer>();
			}
			int jMax = sc.nextInt();
			for(int j = 0; j < jMax; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
				list[b].add(a);
			}
			System.out.println(list.length-2);
		}
	}
}
