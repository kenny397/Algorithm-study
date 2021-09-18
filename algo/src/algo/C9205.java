package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C9205 {

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
			int[][] adj=new int[n+2][n+2];
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j)continue;
					if(Math.abs(map[i].x-map[j].x)+Math.abs(map[i].y-map[j].y)<=1000) {
						adj[i][j]=1;
					}else {
						adj[i][j]=10000;
					}
				}
			}
			for(int k=0; k<n+2; k++) {
				for(int i=0; i<n+2; i++) {
					for(int j=0; j<n+2; j++) {
						adj[i][j]=Math.min(adj[i][k]+adj[k][j], adj[i][j]);
					}
				}
			}
			
			if(adj[0][n+1]>=10000) {
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
