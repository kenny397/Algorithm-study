package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C1932 {
static int tri[][];
static int n;
static int[][]cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cache=new int[n+1][n+1];
		tri=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				tri[i][j]=sc.nextInt();
			}
		}
		for(int[] i:cache) {
			Arrays.fill(i, -1);
			
		}
		System.out.println(dp(0,0));
		
	}
	static int dp(int x, int y) {
		if(x==n-1) {
			return tri[x][y];
		}
		if(cache[x][y]!=-1)return cache[x][y];
		int max=Math.max(dp(x+1,y), dp(x+1,y+1))+tri[x][y];
		cache[x][y]=Math.max(cache[x][y],max);
		return  cache[x][y];
	}

}
