package baekjoon.backtrack.bj6603;

import java.util.Scanner;
 
public class Main {
	
	static Scanner sc = new Scanner(System.in);
    static final int NO = 6;
    static int[] arr;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception{
        
        while(true) {
        	// 입력부
            int num = sc.nextInt();
            if(num == 0) break;
            
            arr = new int[num]; // 매번 초기화
            visited = new boolean[num]; // 매번 초기화
            
            int idx = 0;
            while(idx < arr.length) {
                arr[idx++] = sc.nextInt();
            }
            
            
            // 연산부 : 백트래킹 시작
            for(int i = 0; i < arr.length; i++) {
                visited[i] = true;
                bt(i, 1, arr[i] + " ");
                visited[i] = false;
            }
            
            System.out.println();
        }
        System.exit(0);
    }
    
    public static void bt(int idx, int level, String str) { // str : arr[i] + " ";
        if(level == NO) { // 길이가 6 되면 종료
            System.out.println(str);
            return;
        }
        
        for(int i=idx+1; i < arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            bt(i, level+1, str + arr[i] + " "); // DFS
//            1 2 3 4 5 6
//            1 2 3 4 5 7
//            1 2 3 4 6 7
//            1 2 3 5 6 7
//            1 2 4 5 6 7
//            1 3 4 5 6 7
//            2 3 4 5 6 7
            visited[i] = false;
        }
    }
}