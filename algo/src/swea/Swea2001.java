package swea;

import java.util.Scanner;

public class Swea2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			int[][]map=new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			int ret=0;
			for(int i=0; i<=n-m; i++) {
				for(int j=0; j<=n-m; j++) {
					int sum=0;
					for(int z=0; z<m; z++ ) {
						for(int r=0; r<m; r++) {
							sum+=map[i+z][j+r];
						}
					}
					ret=Math.max(ret, sum);
				}
			}
			System.out.println("#"+t+" "+ret);
			
		}
	}

}
