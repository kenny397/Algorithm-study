package algo;

import java.util.Scanner;

public class C14499 {
static int[][] map;
static int n;
static int[] dice;
static int m;
static int x;
static int y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		dice=new int[6];
		n=sc.nextInt();
		m=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		int k=sc.nextInt();
		map=new int[n][m];
		for(int i=0; i<n;i++) {
			for(int j=0; j<m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<k; i++) {
			move(sc.nextInt());
		}
		
	}
	static void move(int dir) {
		
		if(dir==1) {
			if(y+1>=m)return;setDice(dir);
			if(map[x][y+1]==0) {
				map[x][y+1]=dice[5];
			}else {
				dice[5]=map[x][y+1];
				map[x][y+1]=0;
				
			}y++;
			
		}if(dir==2) {
			if(y-1<0)return;setDice(dir);
			if(map[x][y-1]==0) {
				map[x][y-1]=dice[5];
			}else {
				dice[5]=map[x][y-1];
				map[x][y-1]=0;
			}y--;
		}
		if(dir==3) {
			if(x-1<0)return;setDice(dir);
			if(map[x-1][y]==0) {
				map[x-1][y]=dice[5];
			}else {
				dice[5]=map[x-1][y];
				map[x-1][y]=0;
			}x--;
		}
		if(dir==4) {
			if(x+1>=n)return;setDice(dir);
			if(map[x+1][y]==0) {
				map[x+1][y]=dice[5];
			}else {
				dice[5]=map[x+1][y];
				map[x+1][y]=0;
			}x++;
			
		}
		System.out.println(dice[0]);
		
	}
	static void setDice(int dir) {
		int[]t=dice.clone();
		if(dir==1) {
			dice[0]=t[3];
			dice[2]=t[0];
			dice[3]=t[5];
			dice[5]=t[2];
		}if(dir==2) {
			dice[0]=t[2];
			dice[2]=t[5];
			dice[3]=t[0];
			dice[5]=t[3];
		}if(dir==3) {
			dice[0]=t[4];
			dice[1]=t[0];
			dice[4]=t[5];
			dice[5]=t[1];
		}if(dir==4) {
			dice[0]=t[1];
			dice[1]=t[5];
			dice[4]=t[0];
			dice[5]=t[4];
		}
		
		
	}

}
