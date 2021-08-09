package swea;

import java.util.Scanner;

public class SweaLadder1 {
	static int answer;
	static int[][]map;
	static boolean[][]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			answer=0;
			int n=sc.nextInt();
			map=new int[100][100];
			v=new boolean[100][100];
			int startx=0;
			int starty=0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==2) {
						startx=i;
						starty=j;
					}
				}
			}
			solution(startx,starty);
			System.out.println("#"+t+" "+answer);
			
			
		}
	}
	static void solution(int x, int y) {
		if(x==0) {
			
			answer=y;
			return;
		}//System.out.println(x+" "+y);
		if(y+1<100&&map[x][y+1]==1&&!v[x][y+1]) {
			v[x][y+1]=true;
			solution(x,y+1);
		}else if(y-1>=0&&map[x][y-1]==1&&!v[x][y-1]) {
			v[x][y-1]=true;
			solution(x,y-1);
		}else if(map[x-1][y]==1) {
			v[x-1][y]=true;
			solution(x-1,y);
		}
		
	}

}
