package algo;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class C1916 {
static int n;
static ArrayList<ArrayList<Node>>al;
static int[]dist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int m=sc.nextInt();
		al=new ArrayList<>();
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0; i<m; i++) {
			al.get(sc.nextInt()).add(new Node(sc.nextInt(),sc.nextInt()));
		}
		int start=sc.nextInt();
		int end=sc.nextInt();
		dist=new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dijk(start);
		System.out.println(dist[end]);
	}
	static void dijk(int start) {
		PriorityQueue<Node>pq=new PriorityQueue<>();
		dist[start]=0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			
			for(Node i: al.get(node.current)) {
				if(dist[node.current]+i.d<dist[i.current]) {
					dist[i.current]=dist[node.current]+i.d;
					pq.offer(new Node(i.current,dist[i.current]));
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int current;
		int d;
		Node(int current, int d){
			this.current=current; 
			this.d=d;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.d-o.d;
		}
	}
}
