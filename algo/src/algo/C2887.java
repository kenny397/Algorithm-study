package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C2887 {
	static int[]parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Planet[] plants=new Planet[n];
		parent=new int[n];
		for(int i=0; i<n; i++) {
			parent[i]=i;
			StringTokenizer st= new StringTokenizer(br.readLine());
			plants[i]=new Planet(i,Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		
		PriorityQueue<Node>pq=new PriorityQueue<>();
		Arrays.sort(plants,(p1,p2)->{
			if(p1.x<p2.x)return -1;
			else return 1;
		});
		for(int i=0; i<n-1; i++) {
			long w=Math.abs(plants[i].x-plants[i+1].x);
			pq.add(new Node(plants[i].num,plants[i+1].num,w));
		}
		
		Arrays.sort(plants,(p1,p2)->{
			if(p1.y<p2.y)return -1;
			else return 1;
		});
		for(int i=0; i<n-1; i++) {
			long w=Math.abs(plants[i].y-plants[i+1].y);
			pq.add(new Node(plants[i].num,plants[i+1].num,w));
		}
		
		Arrays.sort(plants,(p1,p2)->{
			if(p1.z<p2.z)return -1;
			else return 1;
		});
		for(int i=0; i<n-1; i++) {
			long w=Math.abs(plants[i].z-plants[i+1].z);
			pq.add(new Node(plants[i].num,plants[i+1].num,w));
		}
		
		long ret=0;
		int cnt=0;
		while(cnt!=n-1) {
			Node node= pq.poll();
			if(find(node.start)!=find(node.end)) {
				cnt++;
				union(node.start,node.end);
				ret+=node.distance;
			}
		}
		System.out.print(ret);
	}
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y)return;
		if(x<y) {
			parent[y]=x;
		}else {
			parent[x]=y;
		}
	}
	static class Planet {
		int num;
		long x,y,z;

		public Planet(int num,long x, long y, long z) {
			super();
			this.num=num;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		

		
		
	}
	static class Node implements Comparable<Node>{
		int start,end;
		long distance;

		public Node(int start, int end, long distance) {
			super();
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.distance<o.distance)return -1;
			else return 1;
		}
		
	}

}
