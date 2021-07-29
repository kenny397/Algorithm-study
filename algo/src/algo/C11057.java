package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C11057 {
static long[][] cache;
static int n;
static int mod=10007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cache=new long[n+1][10];
		for(int i=0; i<10; i++) {
			cache[1][i]=1;
		}
		long ret=0;
		dp(n,0);
		for(int i=0; i<10; i++) {
			ret+=cache[n][i];
		}
		System.out.println(ret%mod);
	}
	static long dp(int m,int w) {
		if(cache[m][w]!=0) {
			return cache[m][w];
		}
		for(int i=0; i<10; i++) {
			for(int j=i; j<10; j++) {
				cache[m][i]+=dp(m-1,j);
				cache[m][i]=cache[m][i]%mod;
			}
		}
		return cache[m][w];
	}

}
