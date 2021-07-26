package algo;

import java.util.Scanner;

public class C14501 {
static int[][] sch;
static int[]cache;
static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cache=new int[n+1];
		sch=new int[n][2];
		for(int i=0; i<n; i++) {
			sch[i][0]=sc.nextInt();
			sch[i][1]=sc.nextInt();
			
		}
		System.out.println(dp(0));
		
	}
	static int dp(int start) {
		if(start>=n)return 0; 
		if(cache[start]!=0)return cache[start];
		
		if(start+sch[start][0]<=n) {
			cache[start]=Math.max(cache[start], dp(start+sch[start][0])+sch[start][1]);
		}
		cache[start]=Math.max(cache[start], dp(start+1));
		
		return cache[start];
	}

}
