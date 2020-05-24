package programmers.srch.lv2TgtNo.test;


public class Main {

	public static void main(String[] args){
		int[] numbers = {1,1,1,1,1};
		int target = 3;


		System.out.println(solution(numbers, target));
	}
	static int answer = 0;
	
    public static int solution(int[] numbers, int target) {
        bt(numbers, target, 0, 0);
        return answer;
    }
    
    public static void bt(int[] numbers, int target, int level, int sum){ // 재귀 DFS 문제
    	if(numbers.length==level) {
    		if(sum==target) answer++;
    		return;
    	}
    	
    	bt(numbers, target, level+1, sum+numbers[level]);
    	bt(numbers, target, level+1, sum-numbers[level]);
    	
    }
}