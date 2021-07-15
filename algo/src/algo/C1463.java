package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C1463 {
static int ret;
static int cache[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ret=Integer.MAX_VALUE;
		cache=new int[n+1];
		Arrays.fill(cache, Integer.MAX_VALUE);
		System.out.println(dp(n));
	}
	static int dp(int a) {
		if(a==1) {
			return 0;
		}
		if(cache[a]!=Integer.MAX_VALUE)return cache[a];
		if(a%3==0) {
			cache[a]=Math.min(cache[a],dp(a/3)+1);
		}
		if(a%2==0) {
			cache[a]=Math.min(cache[a],dp(a/2)+1);
		}
		cache[a]=Math.min(cache[a],dp(a-1)+1);
		return cache[a];
	}

}
