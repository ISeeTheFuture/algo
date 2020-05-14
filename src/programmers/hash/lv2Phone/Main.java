package programmers.hash.lv2Phone;

public class Main {

	public static void main(String[] args){
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	
	public static boolean solution(String[] phone_book) {
		
		for(int i = 0; i < phone_book.length; i++) {
			for(int j = 0; j < phone_book.length; j++) {
				if(i==j) continue;
				if(phone_book[j].startsWith(phone_book[i])) return false;
			}
		}
		
		return true;
	}

}