package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C1753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		int start=sc.nextInt();
		ArrayList<Edge>[] adj=new ArrayList[v+1];
		for(int i=1; i<=v; i++)adj[i]=new ArrayList<>();
		for(int i=0; i<e; i++) {
			int u=sc.nextInt();
			int u2=sc.nextInt();
			int w=sc.nextInt();
			adj[u].add(new Edge(u2,w));
		}
		boolean[] c=new boolean[v+1];
		int[] dist=new int[v+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Edge(start,0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Edge edge=pq.poll();
			int destination=edge.v;
			if(c[destination])continue;
			c[destination]=true;
			for(Edge next : adj[destination]) {
				if(dist[destination]+next.w<=dist[next.v]) {
					dist[next.v]=dist[destination]+next.w;
					pq.add(new Edge(next.v,dist[next.v]));
				}
			}
		}
		for(int i=1; i<dist.length; i++) {
			if(dist[i]==Integer.MAX_VALUE)
			System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
		
	}

}
