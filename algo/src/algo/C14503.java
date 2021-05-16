package algo;

import java.util.Scanner;

public class C14503 {
static int[][] map;
static int sum;
static int[] dx= {-1,0,1,0};
static int[] dy= {0,1,0,-1};
static boolean[][] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		int dir=sc.nextInt();
		sum=0;
		map=new int[n][m];
		v=new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		dfs(x,y,dir);
		System.out.println(sum);
	}
	
	
	
	static void dfs(int x, int y, int dir) {
		if(map[x][y]==1)return;
		if(!v[x][y]) {
			sum++;
			v[x][y]=true;
			
		}
		int mdir=dir;
		for(int i=0; i<4; i++) {
			mdir=(mdir+3)%4;
			int nx=x+dx[mdir];
			int ny=y+dy[mdir];
			if(nx<0||ny<0||nx>=map.length||ny>=map[0].length) continue;
			if(map[nx][ny]==1||v[nx][ny])continue;
			if(map[nx][ny]==0&&!v[nx][ny]) {
				
				dfs(nx,ny,mdir);
				return;
			}
		
		}
		dfs(x-dx[dir],y-dy[dir],dir);
	}

}
