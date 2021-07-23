package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C2156 {
static int[] cache;
static int n;
static int[] glasses;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		glasses=new int[n];
		cache=new int[n+1];
		Arrays.fill(cache, -1);
		for(int i=0; i<n; i++) {
			glasses[i]=sc.nextInt();
		}
		dp(0);
		int max=Math.max(cache[0],cache[1] );
		System.out.println(max);
		
	}
	static int dp(int idx) {
		if(idx>=n) {
			return 0;
		}
		if(cache[idx]!=-1) {
			return cache[idx];
		}
		
		if(idx==n-1) {
			cache[idx]=dp(idx+1)+glasses[idx];
		}else {
			
			cache[idx]=Math.max(dp(idx+2)+glasses[idx],dp(idx+3)+glasses[idx]+glasses[idx+1]);
			cache[idx]=Math.max(cache[idx],dp(idx+1));
		}
		
		return cache[idx];
	}

}
