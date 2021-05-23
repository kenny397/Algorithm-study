package algo;

import java.util.Scanner;

public class C13460 {
static int n;
static int m;
static int[]dx= {0,-1,0,1};
static int[]dy= {-1,0,1,0};
static String map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new String[n][m];
		for(int i=0; i<n; i++) {
			String s=sc.next();
			map[i]=s.split("");
		}
		
	}
	static void move(int x, int y,int dir) {
		int nx=dx[dir]+x;
		int ny=dy[dir]+y;
		if(map[nx][ny].equals(".")) {
			map[nx][ny]=map[x][y];
			map[x][y]=".";	
		}
		
	}

}
