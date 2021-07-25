package algo;

import java.util.Scanner;

public class C9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		long[] dp= new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		dp[6]=3;
		for(int i=7; i<101; i++) {
			dp[i]=dp[i-1]+dp[i-5];
		}
		for(int t=0; t<testcase; t++) {
			int n=sc.nextInt();
			System.out.println(dp[n]);
		}
	}

}
