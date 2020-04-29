package baekjoon.greedy.bj1931;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	// 그리디
		// 최초 회의는 종료시간이 가장 빠르고 && 시작시간도 가장 빠르다.
		// 그러고.. 이제 보니 나머지 회의들도 종료시간이 가장 빠르고 && 시작시간도 가장 빠른 순으로 정렬하면 된다! 이걸 왜 몰랐지..
			// => 종료시간이 빠른 기준으로 정렬한 후, 종료 시간 배열 내의 시작 시간도 시작시간이 빠른 순으로 정렬하면 됨.
		// 이후 최초 회의와 아귀가 맞는 회의들만 집어 카운트 하면 풀림.
	
	
	static int n; // 회의의 수
	static ArrayList<Point> p = new ArrayList<Point>(); // 필요없는데....지우고 코드 고치기 귀찮아서 내둠.
	static ArrayList<Integer>[] list; // 여기에 인접리스트 형식으로 회의 시간 저장
	static int maxNo; // list 초기화하기 위해, 종료 시간의 최대 값을 저장
	
	static int cnt; // 답으로 제출할 케이스 개수
	
	
	public static void main(String[] args) {
		
		// 입력부
		n = sc.nextInt();		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			p.add(new Point(x,y));
			maxNo = maxNo<y?y:maxNo; // 종료 시간 최대값 저장
		}
		
		list = new ArrayList[maxNo+1]; // 인접리스트 초기화
		
		for(int i = 0; i <= maxNo; i++) { // 인접 리스트[i] 초기화. 미리 초기화 해놔야 밑에서 데이터 입력 받을 때 원하는 index에 바로 집어 넣을 수 있다 
			list[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < p.size(); i++) { // 인접리스트로 값 옮겨 넣기. 
			list[p.get(i).y].add(p.get(i).x); // 위에서 Point로 입력 받지 않고, 처음부터 list로 받으면 할 필요 없는 짓인데, 이제와서 코드 고치기 빡세서...ㅠ
		}
		for(int i = 0; i < list.length; i++) { // list[i]의 내부 값들을 오름차순으로 정렬
			Collections.sort(list[i]);
		}
		
		// 연산부
//		int x = 0; // 비교는 이전 종료시간인 y와 현재 종료시간인 list[i].get(j) 만 하기 때문에 x는 필요 없음
		int y = 0;
		for(int i = 0; i < list.length; i++) {
//			System.out.println("-----list["+i+"]-----");
			for(int j = 0; j < list[i].size(); j++) {
//				System.out.println(list[i].get(j));
				if(cnt==0 && list[i].get(j)!= null) { // 일단 list의 최초 값은 즉시 물어 오도록
//					x = list[i].get(j);
					y = i;
					cnt++;
//					System.out.println(x+" "+y);
				}
				else if(cnt!=0 && y <= list[i].get(j)) { // 최초값이 아니고&& 이전 종료시간이 현재 시작 시작보다 작을 때
//					x = list[i].get(j);
					y = i;
					cnt++;
//					System.out.println(x+" "+y);
				}
			}
		}
		System.out.println(cnt);
		
		
	}

}
