package baekjoon.greedy.bj2220.sh;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	       
	        int n = sc.nextInt(); //노드의갯수 입력
	        int a[] = new int[n+1]; // 이진트리 배열
	        for(int i=1; i<n; i++) {
	            for(int j=i; j>1; j/=2) {
	                a[j] = a[j/2];       //자식 노드에 부모노드의 값을 대입함
	            }
	            a[1] = i+1;
	        }
	        a[n] = 1; // 마지막 노드에 1이여야 가장 많이 swap이 된다.
	        for(int i=1; i<=n; i++)
	            System.out.print(a[i] + " ");
		
		
	}
}