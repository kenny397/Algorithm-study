package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea_보급로 {
static int[]dx= {0,0,1,-1};
static int[]dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n= Integer.parseInt(br.readLine());
			int[][] map=new int[n][n];
			int[][]distanceMap=new int[n][n];
			String temp[][]=new String[n][n];
			for(int i=0; i<n; i++) {
				temp[i]=br.readLine().split("");
				for(int j=0; j<n; j++) {
					map[i][j]=Integer.parseInt(temp[i][j]);
					distanceMap[i][j]=Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Node>pq=new PriorityQueue<>();
			pq.add(new Node(0,0,0));
			distanceMap[0][0]=0;
			while(!pq.isEmpty()) {
				Node node=pq.poll();
				for(int d=0; d<4; d++) {
					int nx=node.x+dx[d];
					int ny=node.y+dy[d];
					if(nx>=n||ny>=n||nx<0||ny<0)continue;
					if(distanceMap[nx][ny]>node.distance+map[node.x][node.y]) {
						distanceMap[nx][ny]=node.distance+map[node.x][node.y];
						pq.add(new Node(nx,ny,node.distance+map[node.x][node.y]));
					}
				}
				
				
			}
			System.out.println("#"+t+" "+distanceMap[n-1][n-1]);
			
		}
	}
	static class Node implements Comparable<Node>{
		int x,y,distance;

		public Node(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.distance-o.distance;
		}
		
	}

}
