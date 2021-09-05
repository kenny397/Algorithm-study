package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1197 {
static int[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int v=Integer.parseInt(st.nextToken());
		int e=Integer.parseInt(st.nextToken());
		Node[] nodes=new Node[e];
		parent=new int[v+1];
		for(int i=1; i<=v; i++) {
			parent[i]=i;
		}
		for(int i=0; i<e; i++) {
			st=new StringTokenizer(br.readLine());
			nodes[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(nodes);
		int cnt=0;
		
		int ret=0;
		int index=0;
		while(cnt!=v-1) {
			if(find(nodes[index].x)!=find(nodes[index].y)) {
				cnt++;
				ret+=nodes[index].weight;
				union(nodes[index].x,nodes[index].y);
			}
			index++;
		}
		System.out.println(ret);
		
		
		
		
		
	}
	static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)return;
		if(x<y) {
			parent[y]=x;
		}
		else {
			parent[x]=y;
		}
	}
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	static class Node implements Comparable<Node>{
		int x,y,weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
	}

}
