package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_벽돌꺠기 {
static int[][]map;
static int[][]mapCopy;
static int w;
static int h;
static int n;
static int ret;
static int[]v;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			ret=Integer.MAX_VALUE;
			map=new int[h][w];
			mapCopy=new int[h][w];
			v=new int[n];
			for(int i=0; i<h; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					mapCopy[i][j]=map[i][j];
				}
			}
			bs(0);
			System.out.println("#"+t+" "+ret);
		}
	}
	static void bs(int deep) {
		if(deep==n) {
			for(int i=0; i<n; i++) {
				operate(v[i]);
				clear();
			}
			
			int ball=count();
			ret=Math.min(ball, ret);
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					map[i][j]=mapCopy[i][j];
				}
			}
			return;
		}
		for(int i=0; i<w; i++) {
			v[deep]=i;
			bs(deep+1);
		}
		
	}
	private static void operate(int target) {
		// TODO Auto-generated method stub
		Queue<Node>q=new LinkedList<>();
		for(int i=0; i<h; i++) {
			if(map[i][target]!=0) {
				q.add(new Node(i,target,map[i][target]));
				map[i][target]=0;
				break;
			}
		}
		while(!q.isEmpty()) {
			Node node= q.poll();
			if(node.distance==1)continue;
			for(int i=node.x+1; i<node.x+node.distance; i++ ) {
				if(i<0||i>=h)break;
				if(map[i][node.y]!=0&&map[i][node.y]!=1) {
					q.add(new Node(i,node.y,map[i][node.y]));
				}
				map[i][node.y]=0;
				
			}
			for(int i=node.x-1; i>node.x-node.distance; i-- ) {
				if(i<0||i>=h)break;
				if(map[i][node.y]!=0&&map[i][node.y]!=1) {
					q.add(new Node(i,node.y,map[i][node.y]));
				}
				map[i][node.y]=0;
			}
			for(int i=node.y+1; i<node.y+node.distance; i++ ) {
				if(i<0||i>=w)break;
				if(map[node.x][i]!=0&&map[node.x][i]!=1) {
					q.add(new Node(node.x,i,map[node.x][i]));
				}
				map[node.x][i]=0;
			}
			for(int i=node.y-1; i>node.y-node.distance; i-- ) {
				if(i<0||i>=w)break;
				if(map[node.x][i]!=0&&map[node.x][i]!=1) {
					q.add(new Node(node.x,i,map[node.x][i]));
				}
				map[node.x][i]=0;
			}
		}
		
	}
	private static void print() {
		for(int i=0; i<h; i++) {
			
			for(int j=0; j<w; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void clear() {
		for(int i=0; i<w;i++) {
			for(int j=h-1; j>0; j--) {
				
				if(map[j][i]==0) {
					for(int z=j-1; z>=0; z--) {
						if(map[z][i]!=0) {
							map[j][i]=map[z][i];
							map[z][i]=0;
							break;
						}
					}
				}
			}
			
			
		}
	}
	static int count() {
		int cnt=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]!=0)cnt++;
			}
		}
		return cnt;
	}
	static class Node{
		int x,y,distance;

		public Node(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
	}

}
