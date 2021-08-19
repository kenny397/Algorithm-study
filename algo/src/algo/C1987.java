package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C1987 {
static boolean [] v;
static int[] dx= {0,0,1,-1};
static int r;
static int c;
static int[] dy= {1,-1,0,0};
static char[][]map;
static int max;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		v=new boolean[26];
		map=new char[r][c];
		for(int i=0;i<r; i++) {
			String a=br.readLine();
			map[i]=a.toCharArray();
		}
		
		v[map[0][0]-'A']=true;
		dfs(0,0,1);
		System.out.println(max);
	}
	static void dfs(int x,int y,int ret) {
		
		for(int i=0; i<4; i++) {
			int cx=x+dx[i];
			int cy=y+dy[i];
			if(cx<0||cy<0||cx>=r||cy>=c)continue; 
			if(v[map[cx][cy]-'A'])max=Math.max(max, ret);
			else {
				v[map[cx][cy]-'A']=true;
				dfs(cx,cy,ret+1);
				v[map[cx][cy]-'A']=false;
			}
		}
	}

}
