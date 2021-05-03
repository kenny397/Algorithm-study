package algo;

import java.util.Scanner;

public class C1497 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		long[] gitars=new long[1<<n];
		for(int i=0; i<n; i++) {
			String gitar=sc.next();
			String music=sc.next();
			for(int j=0; j<m; j++) {
				if(music.charAt(j)=='Y') {
					gitars[1<<i]|=1L<<j;
				}
			}
		}
		int max=0;
		for(int i=1; i<(1<<n); i++) {
			for(int j=0; j<n; j++) {
				if((i&(1<<j))!=0) {
					gitars[i]|=gitars[1<<j];
				}
				
			}
			max=Math.max(max, Long.bitCount(gitars[i]));
		}
	/*	for(int i=1; i<(1<<n); i++) {
			System.out.println(Integer.toBinaryString(i)+" "+Integer.toBinaryString(gitars[i]));
		}*/
		int answer=Integer.MAX_VALUE;
		
		for(int i=1; i<(1<<n); i++) {
			if(Long.bitCount(gitars[i])==max) {
				answer=Math.min(answer,Long.bitCount(i));
				
			}
		}
		if(max==0)answer=-1;
		
		System.out.println(answer);
	}

}
