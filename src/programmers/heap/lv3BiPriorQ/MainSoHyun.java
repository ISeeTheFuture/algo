package programmers.heap.lv3BiPriorQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainSoHyun {
	
	public static void main(String[]args) {
		String [] operations = {"I 7","I 5","I -5","D -1"};
		System.out.println(Arrays.toString(solution(operations)));
	}
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		String[] cmd = new String [2];
		
		//최대값 Queue
		Queue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		//최솟값 Queue
		Queue<Integer> minQueue = new PriorityQueue<>();
		
		for(String operation : operations) { // 들어 온 값 하나씩 입력할지 . 최댓값을 뺄지 , 최솟값을 뺄지 결정
			 cmd = operation.split(" ");
			
			if(cmd[0].equals("I")) {
				maxQueue.add(Integer.parseInt(cmd[1]));
				minQueue.add(Integer.parseInt(cmd[1]));
			} else if (!maxQueue.isEmpty()) {
				if(cmd[1].equals("1")) deleteElement(minQueue, maxQueue.poll());
				else deleteElement(maxQueue,minQueue.poll());
			}
		}
		answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.poll();
		answer[1] = minQueue.isEmpty() ? 0 : minQueue.poll();
		return answer;	
	}
	
	public static void deleteElement (Queue<Integer> queue, int num) {
		List<Integer> temp = new ArrayList<>();
		while(!queue.isEmpty()) {
			int extract = queue.poll();
			if(extract == num) break;
			temp.add(extract);
		}
		queue.addAll(temp);
	}
}