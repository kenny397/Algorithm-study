package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C11726 {
static int cache[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		cache=new int[n+1];
		Arrays.fill(cache, -1);
		System.out.println(dp(n));
	}
	static int dp(int n) {
		if(n<0) return 0;
		if(n==0) {
			return 1;
		}
		if(cache[n]!=-1)return cache[n];
		cache[n]=0;
		cache[n]+=dp(n-2)+dp(n-1);
		
		return cache[n]%10007;
	}

}
