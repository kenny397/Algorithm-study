package swea;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Swea_3499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n=sc.nextInt();
			Queue<String>left=new LinkedList<>();
			Queue<String>right=new LinkedList<>();
			int center=(n%2==0)?n/2:n/2+1;
			for(int i=0; i<center; i++) {
				left.add(sc.next());
			}
			
			for(int i=center; i<n; i++) {
				right.add(sc.next());
			}
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		//		Scanner sc=new Scanner(System.in);
//		int T=sc.nextInt();
//		for(int t=1; t<=T; t++) {
//			
//
//			
//			int n=sc.nextInt();
//			String[]cards=new String[n];
//			for(int i=0; i<n; i++) {
//				cards[i]=sc.next();
//			}
//			String[]left;
//			String[]right;
//			if(n%2==0) {
//				left=new String[n/2];
//				right=new String[n/2];
//				for(int i=0; i<n/2; i++) {
//					left[i]=cards[i];
//				}
//				for(int i=0; i<n/2; i++) {
//					right[i]=cards[i+n/2];
//				}
//				
//			}else {
//				left=new String[n/2+1];
//				right=new String[n/2];
//				for(int i=0; i<n/2+1; i++) {
//					left[i]=cards[i];
//				}
//				for(int i=0; i<n/2; i++) {
//					right[i]=cards[i+n/2+1];
//				}
//			}
//			
//			String[] answer=new String[n];
//			int idx=0;
//			for(int i=0; i<n; i+=2) {
//				answer[i]=left[idx++];
//			}
//			idx=0;
//			for(int i=1; i<n; i+=2) {
//				answer[i]=right[idx++];
//			}
//			System.out.print("#"+t+" ");
//			for(int i=0; i<n; i++) {
//				if(i==n-1) {
//					System.out.println(answer[i]);
//				}
//				else System.out.print(answer[i]+" ");
//			}
			
//		Scanner sc=new Scanner(System.in);
//		int T=sc.nextInt();
//		for(int t=1; t<=T; t++) {
//			int n=sc.nextInt();
//			PriorityQueue<Node> pq=new PriorityQueue<>();
//			
//			int v=0;
//			int center=(n%2==0)?n/2:n/2+1;
//			for(int i=0; i<center; i++) {
//				pq.offer(new Node(v,sc.next()));
//				v+=2;
//			}
//			v=1;
//			for(int i=center; i<n; i++) {
//				pq.add(new Node(v,sc.next()));
//				v+=2;
//			}
//			System.out.print("#"+t+" ");
//			while(!pq.isEmpty()) {
//				if(pq.size()==1)System.out.println(pq.poll().v);
//				else System.out.print(pq.poll().v+" ");
//			}
//		}
//	}
//	}

//	static class Node implements Comparable <Node> {
//		int idx;
//		String v;
//		public Node(int idx, String v) {
//			this.idx = idx;
//			this.v = v;
//		}
//		@Override
//		public int compareTo(Node o) {
//			// TODO Auto-generated method stub
//			return this.idx-o.idx;
//		}
//	}
	}
}
