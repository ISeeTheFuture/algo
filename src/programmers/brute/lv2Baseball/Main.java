package programmers.brute.lv2Baseball;

import java.util.Stack;

public class Main {

	public static void main(String[] args){ 
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}
	
	public static int solution(int[][] baseball) {
		// 입력부
        Stack<String> stack = new Stack<>();
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++) {
                for(int k = 1; k <= 9; k++) {
                    if(i != j && j != k && i != k) {
                        stack.add((i * 100 + j * 10 + k)+"");
                    }
                }
            }
        }
        Stack<String> tmp = new Stack<>();
        boolean visited = true;
        
        //연산부
        while(!stack.isEmpty()) {
            String num = stack.pop();
            for(int i = 0; i < baseball.length; i++) {
                int strike = strike(num, baseball[i][0]+"");
                int ball = ball(num, baseball[i][0]+"") - strike;
                if(strike != baseball[i][1] || ball != baseball[i][2]) {
                    visited = false;
                }
            }
            if(visited) {
                tmp.add(num);
            }
            visited = true;
        }
        
        
        //출력부
        return tmp.size();
    }
     
    public static int strike(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.charAt(i)==target.charAt(i)?cnt+1:cnt;
        }
        return cnt;
    }
     
    public static int ball(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.contains(target.charAt(i)+"")?cnt+1:cnt;
        }
        return cnt;
    }
}