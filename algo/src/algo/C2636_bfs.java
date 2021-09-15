package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C2636_bfs {
static boolean[][]v;
static int row;
static int col;
static int [][]map;
static int[]dx= {1,0,0,-1};
static int[]dy= {0,1,-1,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		row= Integer.parseInt(st.nextToken());
		col= Integer.parseInt(st.nextToken());
		map=new int[row][col];
		for(int i=0;i<row; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<col; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int ret=0;
		int cnt=-1;
		while(true) {
			v=new boolean[row][col];
			cnt++;
			if(countC()==0) {
				break;
			}
			
			ret=countC();
			bfs();
			operate();
		}
		System.out.println(cnt);
		System.out.println(ret);
		
		
	}
	static void bfs() {
		Queue<Node>q=new LinkedList<>();
		q.offer(new Node(0,0));
		v[0][0]=true;
		while(!q.isEmpty()) {
			Node n=q.poll();
			for(int d=0; d<4; d++) {
				int nx=n.x+dx[d];
				int ny=n.y+dy[d];
				if(nx<0||ny<0||nx>=row||ny>=col)continue;
				if(map[nx][ny]==0&&!v[nx][ny]) {
					v[nx][ny]=true;
					q.add(new Node(nx,ny));
				}
				
			}
			
		}
	}
	static void operate() {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(v[i][j]) {
					for(int d=0; d<4; d++) {
						int nx=i+dx[d];
						int ny=j+dy[d];
						if(nx<0||ny<0||nx>=row||ny>=col)continue;
						if(map[nx][ny]==1)map[nx][ny]=0;
					}
				}
			}
		}
		
	}
	static int countC() {
		int ret=0;
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j]==1)ret++;
			}
		}
		return ret;
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
