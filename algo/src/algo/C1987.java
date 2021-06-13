package algo;

import java.util.Scanner;

public class C1987 {
static boolean [] v;
static int[] dx= {0,0,1,-1};
static int r;
static int c;
static int[] dy= {1,-1,0,0};
static char[][]map;
static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		v=new boolean[26];
		map=new char[r][c];
		for(int i=0;i<r; i++) {
			String a=sc.next();
			map[i]=a.toCharArray();
		}
		
		v[map[0][0]-'A']=true;
		dfs(0,0,0);
		System.out.println(max+1);
	}
	static void dfs(int x,int y,int ret) {
		max=Math.max(max, ret);
		for(int i=0; i<4; i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=r||cy>=c)continue; 
			if(v[map[cx][cy]-'A'])continue;
			v[map[cx][cy]-'A']=true;
			dfs(cx,cy,ret+1);
			v[map[cx][cy]-'A']=false;
		}
	}

}
