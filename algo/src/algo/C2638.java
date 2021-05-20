package algo;

import java.util.Scanner;

public class C2638 {

	static int n;
	static int m;
	static int count;
	static int[][]map;
	static int[] dy= {0,0,1,-1};
	static int[] dx= {1,-1,0,0};
	static boolean flag=false;
	static int[][]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		 m=sc.nextInt();
		map=new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int ret=0;
		while(true) {
			v=new int[n][m];
			flag=false;
			dfs(0,0);
			cmap();
			for(int i=0; i<n; i++) {
				for(int j=0;j<m; j++ ) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
			ret++;
			if(!flag) {
				
				break;
			}
		}
		System.out.println(ret);
		
	}	
	static void dfs(int x,int y) {
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m)continue;
			if(v[nx][ny]==0&&map[nx][ny]==0) {
				v[nx][ny]=1;
				for(int j=0; j<4; j++) {
					int cx=nx+dx[j];
					int cy=ny+dy[j];
					if(cx<0||cy<0||cx>=n||cy>=m)continue;
					if(map[cx][cy]==1)v[cx][cy]++;
				}
				dfs(nx,ny);
			}
		}
	}
	static void cmap() {
		 count=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1)count++;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(v[i][j]>=2)map[i][j]=0;
				if(map[i][j]==1)flag=true;
			}
		}
	}

}