package algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C1781 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		boolean[] v=new boolean[10000000];
		PriorityQueue<Node> pq=new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			pq.add(new Node(a,b));
		}
		int timer=0;
		int answer=0;
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			if(!v[node.deadline]) {
				answer+=node.ramencnt;
				v[node.deadline]=true;
			}else {
				int idx=node.deadline;
				while(idx>0) {
					if(!v[idx]) {
						answer+=node.ramencnt;
						v[idx]=true;
						break;
					}
					idx--;
				}
			}
				
		}
		System.out.println(answer);
	}
	static class Node implements Comparable<Node>{
		int deadline;
		int ramencnt;
		Node(int deadline, int ramencnt){
			this.deadline=deadline;
			this.ramencnt=ramencnt;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.ramencnt-o.ramencnt==0) {
				return this.deadline-o.deadline;
			}else {
				return o.ramencnt-this.ramencnt;
			}
		}
	}

}
