package programmers.stackq.lv2Printer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args){
		int[] priorites = {2,1,3,2};
		int location = 2;
		
		System.out.println(solution(priorites, location));
	}
	public static int solution(int[] priorities, int location) {
        int ans = 1;

        Queue priorQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int task : priorities){
            priorQ.add(task);
//            System.out.println(priority);
        }


//        System.out.println(priority);
        while(!priorQ.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == (int)priorQ.peek()) {
                    if(i == location){
                        return ans;
                    }
                    priorQ.poll();
                    ans++;
                }
            }
        }

        return ans;
	}
}