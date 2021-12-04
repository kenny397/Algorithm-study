package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;



public class C1149 {
static int[][] rgb;
static int[][] home;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		rgb=new int[n+1][3];
		home=new int[n+1][3];
		for(int i=1; i<=n; i++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			rgb[i][0]=Integer.parseInt(st.nextToken());
			rgb[i][1]=Integer.parseInt(st.nextToken());
			rgb[i][2]=Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n+1; i++) {
			Arrays.fill(home[i], Integer.MAX_VALUE);
		}
		int ret=Integer.MAX_VALUE;
		for(int i=0; i<3;i++ ) {
			ret=Math.min(ret,dp(n,i));
		}
		System.out.println(ret);
	}
	static int dp(int k,int color) {
		if(k==0) {
			return 0;
		}
        if(home[k][color]!=Integer.MAX_VALUE)return home[k][color];
		if(color==0) {
			
			home[k][color]=Math.min(home[k][color],dp(k-1,1)+rgb[k][0]);
			home[k][color]=Math.min(home[k][color],dp(k-1,2)+rgb[k][0]);
		}
		if(color==1) {
			
			home[k][color]=Math.min(home[k][color],dp(k-1,0)+rgb[k][1]);
			home[k][color]=Math.min(home[k][color],dp(k-1,2)+rgb[k][1]);
		}
		if(color==2) {
			
			home[k][color]=Math.min(home[k][color],dp(k-1,0)+rgb[k][2]);
			home[k][color]=Math.min(home[k][color],dp(k-1,1)+rgb[k][2]);
		}
		return home[k][color];
		
	}

}