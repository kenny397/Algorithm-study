package algo;

import java.util.Scanner;

public class C1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int l=sc.nextInt();
		int[]cnt=new int[n];
		int idx=0;
		int ret=0;
		while(true) {
			
			cnt[idx]++;
			if(cnt[idx]==m)break;
			idx=idx-l;
			if(idx<0) {
				idx=n+idx;
			}
			ret++;
			
		}
		System.out.println(ret);
	}

}
