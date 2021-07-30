package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C9465 {
static int n;
static int[][] stickers;
static int [][]cache;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n=Integer.parseInt(br.readLine());
			stickers=new int[n][2];
			cache=new int[n+1][2];
			for(int i=0; i<=n; i++) {
				cache[i][0]=-1;
				cache[i][1]=-1;
			}
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				stickers[i][0]=Integer.parseInt(st.nextToken());
			}
		
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				stickers[i][1]=Integer.parseInt(st.nextToken());
			}
			int ret=Math.max(dp(n-1,1), dp(n-1,0));
			System.out.println(ret);
		}
	}
	static int dp(int x,int y) {
		if(x<0) {
			return 0; 
		}
	
		if(cache[x][y]!=-1)return cache[x][y];
		if(y==1) {
			cache[x][y]=Math.max(dp(x-1,y-1),dp(x-2,y-1))+stickers[x][y];			
		}else {
			cache[x][y]=Math.max(dp(x-1,y+1),dp(x-2,y+1))+stickers[x][y];			
		}
		return cache[x][y];
	}

}
