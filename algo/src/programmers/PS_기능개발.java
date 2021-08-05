package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PS_기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]progresses= {1};
		int[]speeds= {1};
		int[] answer=solution(progresses,speeds);
		for(int i: answer) {
			System.out.print(i+" ");
		}
	}
	static public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer>al=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<speeds.length; i++) {
        	q.add(100-progresses[i]);
        }
        int idx=0;
       
        while(!q.isEmpty()) {
        	int cnt=1;
        	int ret=q.peek()/speeds[idx]+((q.poll()%speeds[idx]!=0)? 1:0);
        	
        	while(!q.isEmpty()&&q.peek()<=speeds[++idx]*ret) {
        		q.poll();
        		cnt++;
        	}
        	al.add(cnt);
        }
        int []answer=new int[al.size()];
        for(int i=0; i<answer.length; i++) {
        	answer[i]=al.get(i);
        }
        return answer;
    }

}
