package algo;

import java.util.Scanner;

public class C2573 {
static int[][]map;
static boolean[][]v;
static boolean[][]v2;
static int[]dx= {0,0,1,-1};
static int[]dy= {1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		map=new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				map[i][j]=sc.nextInt();	
			}
		}
		int answer=0;
		int count=0;
		while(answer<2) {
			v=new boolean[row][col];
			
			
			boolean flag=false;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(map[i][j]!=0) {
						melt(i,j);
						flag=true;
					}
				}
			} answer=dfsAll();
			count++; 
			if(!flag) {
				count=0;
				break;
			}
		}
		System.out.println(count);
			
		
	}
	static void melt(int x, int y) {
		
		v[x][y]=true;
		int count =0;
		for(int i=0; i<4; i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=map.length||cy>=map[0].length)continue;
			if(v[cx][cy])continue;
			if(map[cx][cy]==0)count++;
		}
		map[x][y]=map[x][y]-count;
		if(map[x][y]<0)map[x][y]=0;
		
	}
	static boolean check() {
		return true;
	}
	static int dfsAll() {
		int count=0;
		v2=new boolean[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(!v2[i][j]&&map[i][j]!=0) {
					v2[i][j]=true;
					dfs(i,j);
					count++;
				}
			}
		}
		return count;
	}
	static void dfs(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=map.length||cy>=map[0].length)continue;
			if(v2[cx][cy])continue;
			if(!v2[cx][cy]&&map[cx][cy]!=0) {
				v2[cx][cy]=true;
				dfs(cx,cy);
			}
		}
	}

}
