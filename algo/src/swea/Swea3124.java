package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;

public class Swea3124 {
static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
		StringTokenizer st= new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		parent=new int[V+1];
		ArrayList<Node>adj=new ArrayList<>();
		for(int i=0; i<V+1; i++) {
			parent[i]=i;
		}
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj.add(new Node(a,b,c));
		}
		Collections.sort(adj,(t1,t2)->{
			if(t1.w>t2.w)return 1;
			else return -1;
		});
		int cnt=0;
		long sum=0;
		for(int i=0; i<adj.size(); i++) {
			if(cnt==V-1)break;
			if(find(adj.get(i).start)!=find(adj.get(i).end)) {
				union(adj.get(i).start,adj.get(i).end);
				cnt++;
				sum+=adj.get(i).w;
			}
		}
		System.out.println("#"+t+" "+sum);
		}
	}
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x,int y) {
		int nx=find(x);
		int ny=find(y);
		if(nx==ny)return;
		if(nx<ny) {
			parent[ny]=nx;
		}else {
			parent[nx]=ny;
		}
	}
	static class Node{
		int start,end;
		long w;
		public Node(int start,int end, long w) {
			super();
			this.start=start;
			this.end = end;
			this.w = w;
		}
	}

}
