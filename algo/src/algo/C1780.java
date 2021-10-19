package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1780 {
static int[][]paper;
static int N;
static int zero;
static int plus;
static int minus;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		paper=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp(0,0,N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		
		
	}
	static void dp(int x,int y,int n) {
		if(isSame(x,y,n)) {
			if(paper[x][y]==0) zero++;
			if(paper[x][y]==1) plus++;
			if(paper[x][y]==-1) minus++;
			return;
		}else {
			dp(x,y,n/3);
			dp(x,y+n/3,n/3);
			dp(x,y+n/3*2,n/3);
			dp(x+n/3,y,n/3);
			dp(x+n/3,y+n/3,n/3);
			dp(x+n/3,y+n/3*2,n/3);
			dp(x+n/3*2,y,n/3);
			dp(x+n/3*2,y+n/3,n/3);
			dp(x+n/3*2,y+n/3*2,n/3);
			
		}
		
	}
	static boolean isSame(int x,int y,int n) {
		int flag=paper[x][y];
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(flag!=paper[i][j])return false;
			}
		}
		return true;
	}

}
