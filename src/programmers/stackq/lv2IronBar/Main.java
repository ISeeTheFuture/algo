package programmers.stackq.lv2IronBar;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		
		String arrangement = "()(((()())(())()))(())";
		// 0, 3, 3, 1, 3, 1, 2, 1, 1, 1, 1 => 17
		System.out.println(solution(arrangement));
	}
	
	public static int solution(String arrangement) {
		// 입력부 : 이게 왜 필요한지는 모르겠지만, q로 풀어봅시다...
		// 이 문제 어떻게 설명해야 할 지 각이 안잡혀서 겁난다ㅠ
		Queue<Character> q = new LinkedList<>();
		for(int i = 0; i < arrangement.length(); i++) {
			q.add(arrangement.charAt(i));
		}
		
		// 연산부
		int stack = 0;
		int ans = 0;
		
		int open = 0;
//		int close = 0; // 필요 없었네..
		
		while(!q.isEmpty()) {
			if(q.poll()=='(') {
				stack++;
				open = 1;
//				close = 0;
			}
			else {
				stack--;
//				close = 1;
				if(open==1) {
					ans+=stack;
//					System.out.println(stack);
					open = 0;
				} else if(open==0) {
					ans++; // 닫힘 만나서 +1 한거
//					System.out.println(1);
				}
			}
		}
		
		return ans;
	}

}