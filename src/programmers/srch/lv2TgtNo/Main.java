package programmers.srch.lv2TgtNo;


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
        if(level == numbers.length){ // 만렙이고
            if(sum==target) answer++; // 타겟 넘버가 맞다면, 답++
            return;// 타겟넘버와 무관하게 만렙이면 return
        }
        bt(numbers, target, level+1, sum+numbers[level]); // 더하던가 1=> 1+1 => 1+1+1 / 1+1-1 => 1+1+1+1 / 1+1+1-1 / 1+1-1+1 / 1+1-1-1 => 결과가 3인 경우만 구하겠다.  
        bt(numbers, target, level+1, sum-numbers[level]); // 빼던가
        // 중요한건 위 두 개의 재귀함수 간 파라미터를 완전히 분리시켜야 한다는 점.
        // level++, sum+=numbers[level] 이딴거 쓰는 순간 망하는거임.
        // 원래는 visited 쓰려고 했지만, 단순 +-만 결정하면 되는 문제고 오히려 숫자의 순서 같은거 생각하면 망함.
    }
}