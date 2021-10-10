package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C4485 {
static int []dx= {0,0,1,-1};
static int []dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx=0;
		while(true) {
			idx++;
			int n=Integer.parseInt(br.readLine());
			if(n==0)break;
			int[][] map=new int[n][n];
			int[][]distance=new int[n][n];
			PriorityQueue<Node>pq=new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			distance[0][0]=map[0][0];
			pq.offer(new Node(0,0,map[0][0]));
			while(!pq.isEmpty()) {
				Node node= pq.poll();
				
				for(int d=0; d<4; d++) {
					int nx=node.x+dx[d];
					int ny=node.y+dy[d];
					if(nx<0||ny<0||nx>=n||ny>=n)continue;
					if(distance[nx][ny]>distance[node.x][node.y]+map[nx][ny]) {
						distance[nx][ny]=distance[node.x][node.y]+map[nx][ny];
						pq.offer(new Node(nx,ny,distance[nx][ny]));
					}
				}
			}
			
			System.out.println("Problem "+idx+": "+distance[n-1][n-1]);
			
		}
	}
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int dis;
		
		
		public Node(int x, int y, int dis) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
		}


		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dis-o.dis;
		}
	}

}
