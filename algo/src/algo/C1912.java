package algo;

import java.util.Scanner;

public class C1912 {
static int[]map;
static int[]cache;
static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cache=new int[n];
		map=new int[n];
		for(int i=0; i<n; i++) {
			map[i]=sc.nextInt();
			cache[i]=Integer.MIN_VALUE;
		}
		int max=map[0];
		cache[0]=map[0];
		dp(n-1);
		for(int i=1; i<n; i++) {
			max=Math.max(max, cache[i]);
		}
		System.out.println(max);
	}
	static int dp(int idx) {
		if(idx==0) {
			return map[0];
		}
		if(cache[idx]!=Integer.MIN_VALUE)return cache[idx];
		cache[idx]=Math.max(map[idx], dp(idx-1)+map[idx]);
		return cache[idx];
		
	}

}
