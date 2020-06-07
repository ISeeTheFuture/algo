package baekjoon.search.bj2644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 입력부
		int[] arr = new int[sc.nextInt()+1];
		int st = sc.nextInt();
		int ed = sc.nextInt();
		
		int iptSize = sc.nextInt();

		for(int i = 0; i < iptSize; i++) {
			int tmp = sc.nextInt();
			arr[sc.nextInt()] = tmp;
		}
		
		// 연산부
			// 시작 지점에서 루트노드까지의 경로
		List<Integer> frmSt = new ArrayList<Integer>();
		while(true) {
			frmSt.add(st);
			st = arr[st];
			if(st == 0) {
				break;
			}
		}
			// 끝 지점에서 루트노드까지의 경로
		List<Integer> frmEd = new ArrayList<Integer>();
		while(true) {
			frmEd.add(ed);
			ed = arr[ed];
			if(ed == 0) {
				break;
			}
		}
		
		// 출력부
			// 두 경로 중 겹치는 부모노드가 있는지 확인
				// 겹치면 해당 지점까지의 거리를 각기 더하고
		for(int i = 0; i < frmSt.size(); i++) {
			for(int j = 0; j < frmEd.size(); j++) {
				if(frmSt.get(i)==frmEd.get(j)) {
					System.out.println(i+j);
					return;
				}
			}
		}
				// 겹치는 부모노드가 없다면 친척이 아니므로 -1
		System.out.println(-1);
	}
}
