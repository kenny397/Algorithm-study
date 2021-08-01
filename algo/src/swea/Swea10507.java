package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea10507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n=sc.nextInt();
			int p=sc.nextInt();
			int[]studyday=new int[n];
			boolean[]v=new boolean[1000001];
			for(int i=0; i<n; i++) {
				studyday[i]=sc.nextInt();
				v[studyday[i]]=true;
			}
			Arrays.sort(studyday);
			int max=studyday[n-1];
			int ret=p+1;
			int count=p;
			int l=1;
			int r=1;
			int cnt=0;
			while(r<=max) {
				
				if(v[r]) {
					r++;
					cnt++;
					ret=Math.max(ret, cnt);
				}else {
					if(count==0) {
						if(!v[l]) {
							count++;
						}
						cnt--;
						l++;
					}else {
						count--;
						cnt++;
						r++;
					}
				}
				
			}
			System.out.println("#"+t+" "+ret);
			
			
			
		}
}

}
