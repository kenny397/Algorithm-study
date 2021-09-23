package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_1681 {
static int n;
static boolean[]v;
static int[][]map;
static int ret;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		ret=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		v=new boolean[n];
		dfs(0,0,0);
		System.out.println(ret);
		
		
	}
	static void dfs(int deep,int start,int cnt) {
		if(cnt>=ret) {
			return;
		}if(deep==n-1) {
			if(map[start][0]==0)return;
			ret=Math.min(ret, cnt+map[start][0]);
			return;
		}
		
		for(int i=1; i<n; i++) {
			if(!v[i]&&map[start][i]!=0) {
				v[i]=true;
				dfs(deep+1,i,cnt+map[start][i]);
				v[i]=false;
			}
		}
		
	}

}
