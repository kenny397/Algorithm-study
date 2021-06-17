package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C1744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]score=new int[n];
		for(int i=0; i<n; i++) {
			score[i]=sc.nextInt();
		}
		int sum=0;
		int minus=0;
		int plus=0;
		int one=0;
		boolean zero=false;
		Arrays.sort(score);
		for(int i=0; i<n; i++) {
			if(score[i]<0) {
				minus++;
			}
			if(score[i]==0) {
				zero=true;
			}
			if(score[i]>0) {
				if(score[i]==1) {
					sum++;
				}else {
					plus++;		
				}
			
			}
			
		}
		int idx=0;
		int m=0;
		if(minus!=0) {
			for(int i=0; i<minus/2; i++) {
			sum+=score[idx]*score[idx+1];
			idx+=2;
			}
			if(minus%2==1) {
			m=score[idx];
			}
		}
		
		if(zero) {
			m=0;
		}
		sum+=m;
		idx=n-1;
		if(plus!=0) {
			for(int i=0; i<plus/2; i++) {
				sum+=score[idx]*score[idx-1];
				idx-=2;
			}
			if(plus%2==1) {
				sum+=score[idx];
			}
		}
		
		System.out.println(sum);
	}

}
