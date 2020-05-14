package programmers.hash.lv1Sportsman;

import java.util.HashMap;

public class Main {

	public static void main(String[] args){
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));
	}
	
	// 그냥 정렬해서 비교하다 다르면 바로 출력 시키면 되는 문제인데..
		// 왜 해시 써야돼 ㅡㅡ
	public static String solution(String[] participant, String[] completion) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < participant.length; i++) {
			if(map.get(participant[i]) == null) {
				map.put(participant[i], 1);
			} else {
				int tmp = map.get(participant[i]);
				map.replace(participant[i], tmp+1);
			}
		}
		
		for(int i = 0; i < completion.length; i++) {
			if(map.containsKey(completion[i])) {
				int tmp = map.get(completion[i]);
				map.replace(completion[i], tmp-1);
			}
		}
		
		String ans = "";
		for(String key : map.keySet()) {
			if(map.get(key) != 0) ans = key;
		}
		
		return ans;
	}

}