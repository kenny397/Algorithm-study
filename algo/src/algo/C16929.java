package algo;

import java.util.Scanner;

public class C16929 {
static char[][]map;
static int[]dx= {0,1,0,-1};
static int[]dy= {1,0,-1,0};
static String answer="No";
static int row;
static int col;
static boolean[][]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		map=new char[row][col];
		v=new boolean[row][col];
		for(int i=0; i<row; i++) {
			String t=sc.next();
			for(int j=0; j<col; j++) {
				map[i][j]=t.charAt(j);
			}
		}
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				dfs(i,j,i,j,1);
				if(answer.equals("Yes")) {
					break;
				}
			}
			if(answer.equals("Yes")) {
				break;
			}
		}
		System.out.println(answer);
		
		
	}
	static void dfs(int x,int y,int targetx,int targety,int deep) {
		if(x==targetx&&y==targety&&deep>=4) {
			
			answer="Yes";
			return;
		}
		for(int i=0; i<4; i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=row||cy>=col) {
				continue;
			}
			if(!v[cx][cy]&&map[cx][cy]==map[targetx][targety]) {
				v[cx][cy]=true;
				dfs(cx,cy,targetx,targety,deep+1);
				v[cx][cy]=false;
			}
		}
		
	}

}
