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
	        int l=priorities.length;
	        int[]answers=new int[l];
	        Queue<Node> q=new LinkedList<>();
	        for(int i=0; i<l; i++){
	            q.offer(new Node(priorities[i],i));
	        }
	        Arrays.sort(priorities);
	        int idx=l-1;
	        int count=1;
	        while(true){
	            if(q.isEmpty())break;
	            if(priorities[idx]==q.peek().value){
	                idx--;
	                answers[q.poll().idx]=count++;
	                continue;
	            }
	            
	             
	            Node node=q.poll();
	            q.offer(node);
	            
	        }
	        for(int i : answers){
	            System.out.println(i);
	        }
	        return answers[location];
	    }
	    
	    
	    static class Node {
	        int value;
	        int idx;
	        Node(int value, int idx){
	            this.value=value;
	            this.idx=idx;
	        }
	    }
	}