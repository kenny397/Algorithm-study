package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C1194 {
static char[][]map;
static int[]dx= {0,0,1,-1};
static int[]dy= {1,-1,0,0};
static int n;
static int m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new char[n][m];
		int cx=0;
		int cy=0;
		for(int i=0; i<n; i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(map[i][j]=='0') {
					cx=i;
					cy=j;
				}
			}
		}
		int ret=bfs(cx,cy);
		System.out.println(ret);
		
		
		
	}
	private static int bfs(int cx, int cy) {
		// TODO Auto-generated method stub
		Queue<Node>q=new LinkedList<>();
		boolean[][][] v=new boolean[n][m][1<<6];
		q.add(new Node(cx,cy,0,0));
		map[cx][cy]='.';
		v[cx][cy][0]=true;
		int ret=-1;
		while(!q.isEmpty()) {
			Node node= q.poll();
			for(int d=0; d<4; d++) {
				int nx=node.x+dx[d];
				int ny=node.y+dy[d];
				if(nx<0||ny<0||nx>=n||ny>=m)continue;
				if(map[nx][ny]=='#')continue;
				if(map[nx][ny]=='.') {
					if(!v[nx][ny][node.key]) {
						v[nx][ny][node.key]=true;
						q.add(new Node(nx,ny,node.key,node.cnt+1));
					}
				}
				if(map[nx][ny]>='a'&&map[nx][ny]<='f') {
					if(!v[nx][ny][node.key]) {
						v[nx][ny][node.key]=true;
						q.add(new Node(nx,ny,node.key|(1<<map[nx][ny]-'a'),node.cnt+1));
					}
				}
				if(map[nx][ny]>='A'&&map[nx][ny]<='F') {
					if(!v[nx][ny][node.key]) {
						v[nx][ny][node.key]=true;
						if((node.key&(1<<map[nx][ny]-'A'))!=0) {
							q.add(new Node(nx,ny,node.key,node.cnt+1));					
						}
					}
				}
				if(map[nx][ny]=='1') {
					return node.cnt+1;
				}
				
			}
			
			
		}
		
		return ret;
	}
	static class Node{
		int x,y;
		int key,cnt;
		public Node(int x, int y, int key, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.cnt = cnt;
		}
		
		
	}

}
