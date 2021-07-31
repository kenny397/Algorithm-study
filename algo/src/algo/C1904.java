package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C1904 {
static int[] cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		cache=new int[1000001];
		Arrays.fill(cache, -1);
		cache[0]=0;
		cache[1]=1;
		cache[2]=2;
		
		System.out.println(dp(n));
	}
	static int dp(int n) {
		if(cache[n]!=-1) {
			return cache[n];
		}
		cache[n]=(dp(n-1)+dp(n-2))%15746;
		
		return cache[n];
	}

}
