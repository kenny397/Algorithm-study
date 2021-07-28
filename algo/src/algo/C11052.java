package algo;

import java.util.Scanner;

public class C11052 {
static int n;
static int[] cards;
static int[] cache;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cache=new int[n+1];
		cards=new int[n+1];
		for(int i=1; i<=n; i++) {
			cards[i]=sc.nextInt();
		}
		System.out.println(dp(n));
	}
	static int dp(int remain) {
		if(remain<0) {
			return Integer.MIN_VALUE;
		}
		if(remain==0) {
			return 0;
		}
		if(cache[remain]!=0)return cache[remain];
		
		for(int i=1; i<=n; i++) {
			cache[remain]=Math.max(cache[remain], dp(remain-i)+cards[i]);
		}
		return cache[remain];
	}

}
