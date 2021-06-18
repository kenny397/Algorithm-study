package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class C1644 {
static boolean[]prime;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		prime=new boolean[n+1];
		checkPrime(n);
		ArrayList<Integer>primes=new ArrayList<>();
		for(int i=2; i<=n; i++) {
			if(!prime[i])primes.add(i);
		}
		int cnt=0;
		int sum=0;
		int start=0;
		int end=0;
		while(true) {
			if(primes.size()==0)break;
			if(sum>n) {
				sum-=primes.get(start);
				start++;
			}else {
				if(sum==n) {
				cnt++;
				}
				sum+=primes.get(end);
				end++;
			}
			if(end==primes.size()) {
				break;
			}
			
		}
		if(!prime[n]) {
			cnt++;
		}
		
		System.out.println(cnt);
	}
	static void checkPrime(int input) {
		prime[0]=true;
		prime[1]=true;
		if(input<2)return;
		for(int i=2; i<=Math.sqrt(input);i++) {
			if(prime[i])continue;
			for(int j=i*i; j<prime.length;j+=i) {
				prime[j]=true;
			}
		}
	}

}
