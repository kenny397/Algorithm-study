package algo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C1092 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] crains=new int[n];
		for(int i=0; i<n; i++) {
			crains[i]=sc.nextInt();
		}
		int m=sc.nextInt();
		int[] targets=new int[m];
		for(int i=0; i<m; i++) {
			targets[i]=sc.nextInt();
		}
		Arrays.sort(crains);
		Arrays.sort(targets);
		Queue<Integer>q=new LinkedList<>();
		int[]avail=new int[n];
		int ret=0;
		if(crains[n-1]<targets[m-1]) {
			System.out.println(-1);
		}else {
			int idx=0;
			for(int i=0; i<m;) {
				if(targets[i]<=crains[idx]) {
					avail[idx]++;
					i++;
				}else {
					idx++;
				}
			}
			
			while(true) {
				boolean flag=false;
				for(int i=0; i<n; i++) {
					if(avail[i]!=0) {
						avail[i]--;
						flag=true;
					}else {
						for(int j=i-1; j>=0; j--) {
							if(avail[j]!=0) {
								avail[j]--;
								flag=true;
								break;
							}
						}
					}
				}
				if(!flag)break;
				ret++;
			}
			System.out.println(ret);
			
		}
	
	}

}
