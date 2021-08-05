package programmers;
import java.util.*;

public class PS_프린터 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]p= {2,1,3,2};
		int l=2;
		int[]p2= {1,1,1,9,1,1};
		int l2=0;
	}
	 static public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Node> wait=new LinkedList<>();
	        for(int i=0; i<priorities.length; i++) {
	        	wait.add(new Node(i,priorities[i]));
	        }
	        while(wait.isEmpty()) {
	        	
	        }
	        return answer;
	  }
	 static class Node{
		 int idx;
		 int value;
		public Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	 }
}
