package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C1753 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(br.readLine());
		ArrayList<Node>[]al=new ArrayList[V+1];
		for(int i=1; i<=V; i++)
		al[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			al[u].add(new Node(v,w));
		}
		int[] distance=new int[V+1];
		boolean[] visit=new boolean[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		PriorityQueue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start,distance[start]));
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			if(visit[node.v])continue;
			visit[node.v]=true;
			for(Node el: al[node.v]) {
				if(distance[el.v]>node.w+el.w) {
					distance[el.v]=node.w+el.w;
					pq.add(new Node(el.v,distance[el.v]));
				}
			}
			
		}for(int i=1; i<=V; i++) {
				if(distance[i]==Integer.MAX_VALUE)System.out.println("INF");
				else System.out.println(distance[i]);
			}
			
		
		
		
		
		
		
	}
	static class Node implements Comparable<Node>{
		int v,w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
}
