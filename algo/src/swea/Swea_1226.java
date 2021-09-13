package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Swea_1226 {
static int[][] map;
static int endx;
static int endy;
static int[] dx= {0,0,1,-1};
static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int T=0; T<10; T++) {
			int t=Integer.parseInt(br.readLine());
			map=new int[16][16];
			boolean[][] v=new boolean[16][16];
			int startx=0;
			int starty=0;
			for(int i=0; i<16; i++) {
				String []row=br.readLine().split("");
				for(int j=0; j<16; j++) {
					map[i][j]=Integer.parseInt(row[j]);
					if(map[i][j]==2) {
						startx=i;
						starty=j;
					}
					if(map[i][j]==3) {
						endx=i;
						endy=j;
					}
				}
			}
			
			Queue<Node> q=new LinkedList<>();
			q.add(new Node(startx, starty));
			int ret=0;
			v[startx][starty]=true;
			while(!q.isEmpty()) {
				Node node=q.poll();
				if(node.x==endx&&node.y==endy) {
					ret=1;
					break;	
				}
				for(int d=0; d<4; d++) {
					int x=dx[d]+node.x;
					int y=dy[d]+node.y;
					if(x<0||x>=16||y<0|| y>=16)continue;
					if(!v[x][y]&&map[x][y]!=1) {
						q.add(new Node(x,y));
						v[x][y]=true;
					}
				}
				
				
				
			}
			System.out.println("#"+t+" "+ret);
			
			
			
			
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
