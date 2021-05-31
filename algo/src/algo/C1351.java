package algo;

import java.util.HashMap;
import java.util.Scanner;

public class C1351 {
static long p; 
static long q;
static HashMap<Long,Long>hm=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		p=sc.nextLong();
		q=sc.nextLong();
		
		System.out.println(dp(n));			
		
	}
	static long dp(long input) {
		if(input==0) {
			return 1;
		}
		if(!hm.containsKey(input)) {
			hm.put(input,dp(input/p)+dp(input/q));
		
		}else {
			return hm.get(input);
		}
		return hm.get(input);
	}

}
