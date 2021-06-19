package algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class C2109 {
static boolean[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Node>pq=new PriorityQueue<>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			int p=sc.nextInt();
			int q=sc.nextInt();
			pq.offer(new Node(p,q));
		}
		int sum=0;
		v=new boolean[10001];
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			if(checkday(node.day)) {
				sum+=node.price;	
			}
				
			
		}
		System.out.println(sum);
		
	}
	static boolean checkday(int day) {
		int cnt=day;
		while(v[cnt]) {
			cnt--;
		}
		if(cnt==0) {
			return false;
		}else {
			v[cnt]=true;
			return true;
		}
		
	}
	static class Node implements Comparable<Node>{
		int price;
		int day;
		Node(int price, int day){
			this.price=price;
			this.day=day;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.price==o.price) {
				return this.day-o.day;
			}
			return o.price-this.price;
		}
	}
}
