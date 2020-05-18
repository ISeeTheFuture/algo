package programmers.greedy.lv2Joystick;

public class Main {

	public static void main(String[] args){
//		String name = "JEROEN"; 
//		String name = "JEEEAAAAEE"; 
//		String name = "JAN";
		String name = "ABAAAAAAAAABB";

		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		// 일단 방향을 정해야됨.
		// 정방향
		int rDir = name.length()-1;
		// 중간 역방향
		int lDir = name.length()-1;
		int idxA = -1;
		int idxNoA = -1;
		for(int i = 1; i < name.length(); i++) { // 단, 첫글자가 'A'인 경우는 빼고 돌린다. "ABAAAAAAAAABB" 같은 경우가 있음.
			if(name.charAt(i)=='A') {
				idxA = i;
				for(int j = idxA; j < name.length(); j++) {
					if(name.charAt(j)!='A') {
						idxNoA = j;
						break;
					}
				}
				break;
			};
		}
		if(idxA!=-1) lDir = (idxA-1)*2 + name.length()-idxNoA;
		// 더 작은애로 답에 넣음
		
		int ans = Math.min(lDir, rDir);
		for(int i = 0; i < name.length(); i++) {
			ans += Math.min((name.charAt(i)-'A'),('Z'-name.charAt(i)+1));
		}
		
		return ans;
	}
}