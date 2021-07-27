package algo;

import java.util.Scanner;

public class C1010 {
static int[][] cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int testcase=0; testcase<t; testcase++ ) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			cache=new int[m+1][n+1];
			for(int i=0; i<m; i++) {
				cache[i][0]=1;
				cache[i][1]=i;
			}
			System.out.println(combination(m,n));
		}
	}
	static int combination(int n, int r) {
		if(n<0||r<0||n<r) {
				return 0;
		}else if(cache[n][r]>0) {
			return cache[n][r];
		}else {
			cache[n-1][r]=combination(n-1,r);
			cache[n-1][r-1]=combination(n-1,r-1);
			return cache[n-1][r]+cache[n-1][r-1];
		}
		
			
	}
}
