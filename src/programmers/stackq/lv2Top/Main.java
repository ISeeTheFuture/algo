package programmers.stackq.lv2Top;

import java.awt.Point;
import java.util.Stack;

public class Main {

	public static void main(String[] args){
//		int[] heights = {3, 9, 9, 3, 5, 7, 2};
		int[] heights = {6, 9, 5, 7, 4};
		System.out.println(solution(heights));
	}
	
	public static int[] solution(int[] heights) {

		Stack<Point> st = new Stack<>(); // 송전탑 기준용
		Stack<Point> stCopied = new Stack<>(); // 답 구하는 용도, 비교하는 용도
		// Point => x : index, y : height
		int[] ans = new int[heights.length];
		
		for(int i = 0; i < heights.length; i++) {
			// 입력부
			st.add(new Point(i+1, heights[i]));
			stCopied = (Stack<Point>) st.clone(); // clonable class, non-clonable class
													// stack : clonable, queue : non-cloneable
			
			// 얕은 복사, 깊은 복사
			// stCopied = st; // 이름만 다르지, 같은 주소를 갖게 됨.
			
			// 연산부
			int sender = stCopied.pop().y;
			while(!stCopied.isEmpty()) {
				Point receiver = stCopied.pop();
				if(receiver.y > sender) {
					ans[i] = receiver.x;
					break;
				}
			}
		}
//		for(int i = 0; i < heights.length; i++) {// stack 객체에 들어있는 애들 
//			Point tmp = st.pop();
//			System.out.println(tmp.x+" "+tmp.y);
//		}
//		for(int i = 0; i < ans.length; i++) { // 답
//			System.out.println(ans[i]);
//		}
		return ans;
	}

}