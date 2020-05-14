package programmers.hash.lv3Best;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args){
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(solution(genres, plays));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		
		// 입력부
		Map<String, Integer> genPla = new HashMap<String, Integer>();
		Map<Integer, Integer> idxPla = new HashMap<Integer, Integer>();
		Map<Integer, String> idxGen = new HashMap<Integer, String>();
		
		
		for(int i = 0; i < plays.length; i++) {
			// genPla에 담기
			if(!genPla.containsKey(genres[i])) {
				genPla.put(genres[i], plays[i]);				
			} else {
				int tmp = genPla.get(genres[i]);
				genPla.replace(genres[i], tmp + plays[i]);
			}
			// idxPla에 담기
			idxPla.put(i, plays[i]);
			// idxArr에 담기
			idxGen.put(i, genres[i]);
		}
		
		
		
		// 연산부
		// genPla play합 기준 내림차순 정렬
		List<Entry<String, Integer>> sortedGen = new ArrayList<Entry<String, Integer>>(genPla.entrySet());
		Collections.sort(sortedGen, new Comparator<Entry<String, Integer>>() {
			// compare로 값 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		// 개별 play 수 기준 idx 내림차순 정렬 
		List<Entry<Integer, Integer>> sortedIdx = new ArrayList<Entry<Integer, Integer>>(idxPla.entrySet());
		Collections.sort(sortedIdx, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		
		int[] ansTmp = new int[plays.length];
		int ansIdx = 0;
		for(int i = 0; i < sortedGen.size(); i++) {
			String selectedGenre = sortedGen.get(i).getKey(); // 출력할 장르
			
			int cnt = 0; // idx 정하기 위해
			for(int j = 0; j < sortedIdx.size(); j++) {
				if(cnt==2) break;
				if(selectedGenre.equals(idxGen.get(sortedIdx.get(j).getKey()))) {
					ansTmp[ansIdx++] = sortedIdx.get(j).getKey();
//					System.out.println(sortedIdx.get(j).getKey());
					cnt++;
				}				
			}			
		}
		
		// 답을 무조건 int[] 로 제출해야돼...
		int[] ans = new int[ansIdx];
		for(int i = 0; i < ans.length; i++) {
			ans[i] = ansTmp[i];
		}
		return ans;
	}

}