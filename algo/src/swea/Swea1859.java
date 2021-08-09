package swea;

import java.util.Scanner;

public class Swea1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int test=1;test<=t; test++) {
			int n=sc.nextInt();
			int[]price=new int[n];
			for(int i=0; i<n; i++) {
				price[i]=sc.nextInt();
			}
			int ret=0;
			int max=0;
			for(int i=n-1; i>=0; i--) {
				max=Math.max(max, price[i]);
				if(max>price[i]) {
					ret+=max-price[i];
				}
			}
			System.out.println(ret);
		}
	}

}
