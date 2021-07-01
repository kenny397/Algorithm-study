package algo;

import java.util.Scanner;

public class C1107 {
static String n;
static boolean[]re;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		re=new boolean[10];
		for(int i=0; i<m; i++) {
			int x=sc.nextInt();
			re[x]=true;
		}
		int max=Math.abs(100-n);
		for(int i=0; i<=1000000;i++) {
			int x=bf(i);
			if(x>0) {
				
				max=Math.min(Math.abs(n-i)+x,max );
			}
		}
		
		System.out.println(max);
		
	}
	static int bf(int q) {
		int len=0;
		if(q==0) {
			if(re[0]) {
				return 0;
			}else {
				return 1;
			}
		}
		while(q>0) {
			if(re[q%10]) {
				return 0;
			}
			len++;
			q=q/10;
		}	
		
		return len;
	}

}
