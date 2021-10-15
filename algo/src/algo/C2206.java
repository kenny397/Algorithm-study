package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C2206 {
static int[] dx= {0,0,1,-1};
static int[] dy= {1,-1,0,0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][]map=new int[n][m];
		for(int i=0; i<n; i++) {
			String[] t=br.readLine().split("");
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(t[j]);
			}
		}
		for(int[] i:map) {
			for(int j :i) {
				System.out.print(j);
			}
			System.out.println();
		}
		boolean[][][]v=new boolean[n][m][2];
		Queue<Node>q =new LinkedList<>();
		q.add(new Node(0,0,0,0));
		v[0][0][0]=true;
		v[0][0][1]=true;
		int ret=-1;
		boolean flag=false;
		while(!q.isEmpty()) {
			Node node=q.poll();
			if(node.x==n-1&&node.y==m-1) {
				ret=node.count+1;
		
				
				break;
			}
			for(int d=0; d<4; d++) {
				int x=node.x+dx[d];
				int y=node.y+dy[d];
				if(x<0||y<0||x>=n||y>=m)continue;
				
				if(!v[x][y][node.cnt]) {
					if(map[x][y]==1) {
						if(node.cnt==0) {
							v[x][y][node.cnt+1]=true;
							q.add(new Node(x,y,node.cnt+1,node.count+1));
							
							
							
						}
					}else {
						v[x][y][node.cnt]=true;
						q.add(new Node(x,y,node.cnt,node.count+1));
						
					}
					
				}
					
				
			}
			
		}
		System.out.println(ret);
		
	}
	static class Node{
		int x,y,cnt,count;

		public Node(int x, int y, int cnt,int count) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.count =count;
		}
		
	}

}
