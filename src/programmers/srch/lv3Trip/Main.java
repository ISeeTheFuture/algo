package programmers.srch.lv3Trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
	public static void main(String[] args){
		String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};

		System.out.println(solution(tickets));
	}
	
	static List<String> list = new ArrayList<>();
	static String route = "";
	static boolean[] visit;
	
	public static String[] solution(String[][] tickets) {
		for(int i = 0; i < tickets.length; i++) {
			visit = new boolean[tickets.length];
			String st = tickets[i][0], ed = tickets[i][1];
			
			if(st.equals("ICN")) {
				route = st + ","; visit[i] = true; 
				dfs(tickets, ed, 1);
			}
		}
		
		Collections.sort(list);
		String[] ans = list.get(0).split(",");
		
		return ans;
	}
	
	public static void dfs(String[][] tickets, String ed, int cnt) {
		route += ed + ",";
		
		if(cnt == tickets.length) {
			list.add(route); return;
		}
		
		for(int i = 0; i < tickets.length; i++) {
			String tmp = tickets[i][0], e = tickets[i][1];
			if(tmp.equals(ed) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, e, cnt + 1);
				visit[i] = false; route = route.substring(0, route.length()-4);
			}
		}
	}
}