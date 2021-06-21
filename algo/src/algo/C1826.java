package algo;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C1826 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		PriorityQueue<Node>pq=new PriorityQueue<>();
		PriorityQueue<Integer>fpq=new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			int d=sc.nextInt();
			int f=sc.nextInt();
			pq.add(new Node(d,f));
		}
		int l=sc.nextInt();
		int p=sc.nextInt();
		if(l<=p) {
			System.out.println(0);
		}else {
			int ret=0;
			int current=p;
			
			while(current<l) {
				while(!pq.isEmpty()&&pq.peek().distance<=current) {
					Node node=pq.poll();
					
					fpq.add(node.fuel);
				}
				if(fpq.isEmpty()) {
					ret=-1;
					break;
				}else {
					ret++;
					current+=fpq.poll();
				}
			}
			System.out.println(ret);
			
		}
		
	}
	static class Node implements Comparable <Node>{
		int distance;
		int fuel;
		Node(int distance,int fuel){
			this.distance=distance;
			this.fuel=fuel;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance-o.distance;
		}
		
	}

}
