package algo;

import java.util.Scanner;

public class C2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long[]dp=new long[91];
		dp[1]=1;
		dp[2]=1;
		dp[3]=2;
		for(int i=4; i<=90; i++  ) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
