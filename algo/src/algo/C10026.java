package algo;

import java.util.Scanner;

public class C10026 {
static boolean [][]v;
static int[]dx= {0,1,-1,0};
static int[]dy= {1,0,0,-1};
static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		String[][] map=new String[n][n];
		for(int i=0; i<n; i++) {
			String s=sc.next();
			map[i]=s.split("");
		}
		int ret=0;
		v=new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					v[i][j]=true;
					dfs(i,j,map[i][j],map);
					ret++;
				}
			}
		}
		System.out.println(ret);
		String[][]map2=map.clone();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map2[i][j].equals("G")) {
					map2[i][j]="R";
				}
			}
		}
		v=new boolean[n][n];
		int ret2=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					v[i][j]=true;
					dfs(i,j,map2[i][j],map2);
					ret2++;
				}
			}
		}
		System.out.println(ret2);
		
	}
	static void dfs(int x,int y,String color,String[][]map) {
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) {
				continue;
			}
			if(!v[nx][ny]&&map[nx][ny].equals(color)) {
				v[nx][ny]=true;
				dfs(nx,ny,color,map);
				
			}
		}
	}

}
