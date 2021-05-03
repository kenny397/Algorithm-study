package algo;

import java.util.Scanner;

public class C3987 {
static int[]dx= {-1,0,1,0};
static int[]dy= {0,1,0,-1};
static char[][] map;
static int max;
static int row;
static int col;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		max=0;
		map=new char[row][col];
		for(int i=0; i<row; i++) {
			String t=sc.next();
			for(int j=0; j<col; j++) {
				map[i][j]=t.charAt(j);
			}
		}
		int pr=sc.nextInt();
		int pc=sc.nextInt();
		int dir=0;
		int max2=-2;
		for(int i=0; i<4; i++) {
			boolean[][][]v=new boolean[row][col][4];
			signal(pr-1,pc-1,i,0,v);
			if(max2<max) {
				max2=max;
				dir=i;
			}
		}
		if(max2==1000000) {
			if(dir==0) {
				System.out.println("U");
			}if(dir==1) {
				System.out.println("R");
			}if(dir==2) {
				System.out.println("D");
			}if(dir==3) {
				System.out.println("L");
			}
			System.out.println("Voyager");
		}else {
			if(dir==0) {
				System.out.println("U");
			}if(dir==1) {
				System.out.println("R");
			}if(dir==2) {
				System.out.println("D");
			}if(dir==3) {
				System.out.println("L");
			}
			System.out.println(max2);
		}
		
	}
	static void signal(int x, int y,int dir,int cost,boolean[][][]v) {
		if(x<0||y<0||x>=row||y>=col) {
			max=cost;
			return;
		}if(map[x][y]=='C') {
			
			max=cost;
			return;
		}
		
		if(map[x][y]=='.') {
			signal(x+dx[dir],y+dy[dir],dir,cost+1,v);
		}
		if(map[x][y]=='/') {
			if(v[x][y][dir]) {
				max=1000000;
				return;
			}
			v[x][y][dir]=true;
			
			if(dir==0) {
				dir=1;
			}else if(dir==1) {
				dir=0;
			}else if(dir==2) {
				dir=3;
			}else {
				dir=2;
			}
			signal(x+dx[dir],y+dy[dir],dir,cost+1,v);
		}
		if(map[x][y]=='\\') {
			if(v[x][y][dir]) {
				max=1000000;
				return;
			}
			v[x][y][dir]=true;
			if(dir==0) {
				dir=3;
			}else if(dir==1) {
				dir=2;
			}else if(dir==2) {
				dir=1;
			}else {
				dir=0;
			}
			signal(x+dx[dir],y+dy[dir],dir,cost+1,v);
		}
		
	}

}
