package swea;

import java.util.Scanner;

public class Swea1894 {
static char[][] map;
static int dir;
static int[]dx= {-1,1,0,0};
static int[]dy= {0,0,-1,1};
static int tankx;
static int tanky;
static char[]tank= {'^','v','<','>'};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T; t++) {
			int row=sc.nextInt();
			int col=sc.nextInt();
			map=new char[row][col];
			for(int i=0; i<row; i++) {
				map[i]=sc.next().toCharArray();
			}
			tankx=0;
			tanky=0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(map[i][j]=='^') {
						tankx=i;
						tanky=j;
						dir=0;
						break;
					}
					if(map[i][j]=='v') {
						tankx=i;
						tanky=j;
						dir=1;
						break;
					}
					if(map[i][j]=='<') {
						tankx=i;
						tanky=j;
						dir=2;
						break;
					}
					if(map[i][j]=='>') {
						tankx=i;
						tanky=j;
						dir=3;
						break;
					}
					
				}
			}
			int len=sc.nextInt();
			String command=sc.next();
			for(int i=0; i<len; i++) {
				move(tankx,tanky,command.charAt(i));
				
			}
			System.out.print("#"+t+" ");
			for(int z=0; z<row; z++) {
				for(int j=0; j<col; j++) {
					System.out.print(map[z][j]);
				}
				System.out.println();
			}
			
			
			
		}
	}
	static void move(int x,int y,char command) {
		if(command=='S') {
			shoot(x,y);
			
		}
		else if(command=='U') {
			dir=0;
			map[x][y]=tank[dir];
			x+=dx[0];
			y+=dy[0];
//			System.out.println(x+" "+y);
//			System.out.println(nx+" "+ny);
			if(checkmap(x,y)&&map[x][y]=='.') {
				map[x][y]=tank[0];
			
				map[x-dx[0]][y-dy[0]]='.';
				tankx=x;
				tanky=y;
			}
			
		}
		else if(command=='D') {
			dir=1;
			map[x][y]=tank[dir];
			x+=dx[1];
			y+=dy[1];
			if(checkmap(x,y)&&map[x][y]=='.') {
				map[x][y]=tank[1];
				map[x-dx[1]][y-dy[1]]='.';
				
				tankx=x;
				tanky=y;
			}
			
		}
		else if(command=='L') {
			dir=2;
			map[x][y]=tank[dir];
			x+=dx[2];
			y+=dy[2];
			if(checkmap(x,y)&&map[x][y]=='.') {
				map[x][y]=tank[2];
				map[x-dx[2]][y-dy[2]]='.';
				dir=2;
				tankx=x;
				tanky=y;
			}
			
		}
		else if(command=='R') {
			dir=3;
			map[x][y]=tank[dir];
			x+=dx[3];
			y+=dy[3];
			
			if(checkmap(x,y)&&map[x][y]=='.') {
				map[x][y]=tank[3];
				map[x-dx[3]][y-dy[3]]='.';
				tankx=x;
				tanky=y;
			}
		}
		
		
		
		
	}
	static void shoot(int x,int y) {
		
		while(true) {
			x+=dx[dir];
			y+=dy[dir];
			if(!checkmap(x,y)||map[x][y]=='#')break;
			if(map[x][y]=='*') {
				map[x][y]='.';
				break;
			}
		}
	}
	static boolean checkmap(int nx, int ny) {
		if(nx<0||nx>=map.length||ny<0||ny>=map[0].length)return false;
		return true;
	}

}
