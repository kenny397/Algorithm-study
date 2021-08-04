package algo;

import java.util.Scanner;

public class C1244 {

	static int[] switchs;
	static int n;
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		switchs=new int[n+1];
		for(int i=1; i<=n; i++) {
			switchs[i]=sc.nextInt();
		}
		int m=sc.nextInt();
		for(int i=0; i<m; i++) {
			operate(sc.nextInt(),sc.nextInt());
			
		}
		for(int i=1; i<=n; i++) {
			
			if(i==n)System.out.print(switchs[i]);
			else System.out.print(switchs[i]+" ");
			
			if(i%20==0)System.out.println();
		}
	}

	private static void operate(int gender, int target) {
		// TODO Auto-generated method stub
		if(gender==1) {
			for(int i=1; i<=n; i++) {
				if(target*i>n)break;
				if(switchs[target*i]==1)  switchs[target*i]=0; 
				else switchs[target*i]=1;
			}
		}
		if(gender==2) {
			if(switchs[target]==1)  switchs[target]=0; 
			else switchs[target]=1;
			for(int i=1; i<=n; i++) {
				if(target+i>n||target-i<0)break;
				if(switchs[target+i]==switchs[target-i]) {
					if(switchs[target+i]==1)  switchs[target+i]=0; 
					else switchs[target+i]=1;
					if(switchs[target-i]==1)  switchs[target-i]=0; 
					else switchs[target-i]=1;
				}else {
					break;
				}
			}
		}
		
	}

}
