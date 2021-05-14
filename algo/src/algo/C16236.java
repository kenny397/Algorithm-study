package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C16236 {
static int[] dx= {-1,0,0,1};
static int[] dy= {0,-1,1,0};
static int n;
static int size;
static int[][]d;
static int zx;
static int zy;
static int xx;
static int yy;
static int[][]map;
static int weight;
static boolean [][]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		size=2;
		 zx=0; zy=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9) {
					xx=i; yy=j;
					map[i][j]=0;
				}
			}
		}
//		
		
//		
		int sum=0;
		int eatcount=0;
		while(true) {
			weight=Integer.MAX_VALUE;
			zx=Integer.MAX_VALUE;
			zy=Integer.MAX_VALUE;
			
			bfs(xx,yy);
			
			if(zx==Integer.MAX_VALUE||zy==Integer.MAX_VALUE)break;
			xx=zx;
			yy=zy;
			sum+=weight;
			eatcount++;
			if(eatcount==size) {
				size++;
				eatcount=0;
			}
		}
		System.out.println(sum);
	}
	
	static void bfs(int x,int y) {
		Queue<Node> q=new LinkedList<>();
		

		v=new boolean[n][n];
		v[x][y]=true;
		
		map[x][y]=0;
		q.add(new Node(x,y,0));
		while(!q.isEmpty()) {
			Node node=q.poll();
			int cx=node.x;
			int cy=node.y;
			
			for(int i=0; i<4; i++) {
			int nx=cx+dx[i];
			int ny=cy+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n)continue;
			if(map[nx][ny]>size)continue;
			if(map[nx][ny]>0&&map[nx][ny]<size) {
				if(weight>node.w+1) {
					zx=nx;zy=ny;
					weight=node.w+1;
				}else if( weight==node.w+1) {
					if(zx==nx) {
						if(zy>ny) {
							zy=ny;
							zx=nx;
						}
					}else if(zx>nx) {
						zx=nx;
						zy=ny;
					}
				}
				
				
				
				
			}
			if(!v[nx][ny]) {
				v[nx][ny]=true;
				q.offer(new Node(nx,ny,node.w+1));
			}
			}
		}
		return;
		
	}
	

}
class Node{
	int x;
	int y;
	int w;
	Node(int x, int y,int w){
		this.x=x;
		this.y=y;
		this.w=w;
	}
}
