package baekjoon.tree.bj11725;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> order; // 스택이던 큐던 별 상관 없음
	static ArrayList<Integer>[] tree;
	static int[] level;
	static int[] parent;
	static int n;
	
	public static void main(String[] args) {

		//입력부
		n = sc.nextInt();
		order = new Stack();
		tree = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) { // 여기서 미리 초기화
			tree[i] = new ArrayList<>();
		}
		
		level = new int[n+1]; // 전부 0; idx 0 ~ 7 : 0
		parent = new int[n+1]; // 전부 0; idx 0 ~ 7 : 0 
		
		for(int i = 0; i < n-1; i++) { // 양방향 인접리스트
			int x = sc.nextInt();
			int y = sc.nextInt();
			tree[x].add(y);
			tree[y].add(x);
		}
		
		
		//연산부: 백트래킹(dfs)
		bt(1);
		
		// 출력부
		for(int i = 2; i <= n; i ++) {
			System.out.println(parent[i]);
		}
		
	}

	public static void bt(int node) { // 백트래킹. 이번엔 재귀대신 while 문 써서.

		order.add(node); // 여기에 이제 방문 예정
		level[node] = 1; // 1은 레벨 0 확실함.
		parent[node] = 0; // 1은 루트노드라 부모 없다. 없는 숫자 아무거나 집어넣으면 됨.
		
		while(!order.isEmpty()) { // 이제 여기서 못나옴
			int nowNode = order.pop(); // 방문 확정
//			System.out.println("nowNode : " + nowNode);
			
			for(int i = 0; i < tree[nowNode].size(); i++) {
				int linkedNode = tree[nowNode].get(i);// nowNode의 연결된 노드
//				System.out.println("linkedNode : " + linkedNode);
				if(level[linkedNode] == 0) { // 연결된 애 레벨 몇이야? 아직 안정해서 몰랐으므로 0.
					order.add(linkedNode); // 다음 방문 예정
					level[linkedNode] = level[nowNode] + 1; // 부모 노드보다 레벨 1업
					parent[linkedNode] = nowNode; // linkedNode의 부모노드는 nextNode
				}
			}
			
		}
	}

}
