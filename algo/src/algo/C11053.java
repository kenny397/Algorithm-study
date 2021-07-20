package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C11053 {
static int n;
static int[]map;
static int[] cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n];
		cache=new int[n];
		for(int i=0; i<n; i++) {
			map[i]=sc.nextInt();
		}
		Arrays.fill(cache,1);
		dp(0);
		int max=1;
		for(int i :cache) {
			max=Math.max(max, i);
		}
		System.out.println(max);
	}
	
	static int dp(int start) {
		if(start==n) {
			return 0;
		}
		if(cache[start]!=1)return cache[start];
		for(int i=start+1; i<n; i++) {
			if(map[start]<map[i]) {
				cache[start]=Math.max(dp(i)+1,cache[start]);
			} 
			if(map[i]<map[start]) {
				cache[i]=Math.max(dp(i), cache[i]);
			}
				
			
		}
		return cache[start];
	}

}
