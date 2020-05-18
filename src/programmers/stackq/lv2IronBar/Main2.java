package programmers.stackq.lv2IronBar;

import java.util.Stack;

public class Main2 {

	public static void main(String[] args){
		
		String arrangement = "()(((()())(())()))(())";
		// 0, 3, 3, 1, 3, 1, 2, 1, 1, 1, 1 => 17
		System.out.println(solution(arrangement));
	}
	
	// 이게 모범답안인듯. 얘 왜케 잘 풀었어..
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                st.push(i);
            } else if (arrangement.charAt(i) == ')') {
                if (st.peek() + 1 == i) {
                    st.pop();
                    answer += st.size();
                } else {
                    st.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }

}