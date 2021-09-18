package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C9205_bfs {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n=Integer.parseInt(br.readLine());
			Node[]map=new Node[n+2];
			for(int i=0; i<n+2; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				map[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			boolean[][] adj=new boolean[n+2][n+2];
			for(int i=0; i<n+2; i++) {
				for(int j=i; j<n+2; j++) {
					if(i==j)continue;
					if(Math.abs(map[i].x-map[j].x)+Math.abs(map[i].y-map[j].y)<=1000) {
						adj[i][j]=true;
						adj[j][i]=true;
					}
				}
			}
			boolean[]v=new boolean[n+2];
			Queue<Integer>q=new LinkedList<>();
			q.offer(0);
			v[0]=true;
			boolean flag=false;
			while(!q.isEmpty()) {
				int num=q.poll();
				if(num==n+1) {
					flag=true;
					break;
				}
				for(int i=0; i<n+2; i++) {
					if(!v[i]&&adj[num][i]) {
						v[i]=true;
						q.add(i);
					}
				}
			}
			
			if(!flag) {
				System.out.println("sad");
			}else {
				System.out.println("happy");				
			}
			//System.out.println(adj[0][n+1]);
			
			
			
		}
	}
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}