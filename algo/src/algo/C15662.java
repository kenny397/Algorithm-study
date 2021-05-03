package algo;

import java.util.Scanner;

public class C15662 {
static int[][]wheels;
static boolean[]v;
static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		wheels=new int[n][8];
		for(int i=0; i<n; i++) {String s=sc.next();
			for(int j=0; j<8; j++) {
				
					wheels[i][j]=Integer.parseInt(s.substring(j,j+1));
			}
		}int k=sc.nextInt();
		for(int i=0; i<k; i++) {
			int target=sc.nextInt()-1;
			int dir=sc.nextInt();
			v=new boolean[n];
			v[target]=true;
			check(target,dir);
			
		}
		for(int i=0; i<n; i++) {
		for(int j=0; j<8; j++) {
			System.out.print(wheels[i][j]);
				}System.out.println();
		}
		int answer=0;
		for(int i=0; i<n; i++) {
			if(wheels[i][0]==1)answer++;
		}
		System.out.println(answer);

	}
	static void rotate(int target, int dir) {
		if(dir==1) {
			int temp=wheels[target][7];
			for(int i=7; i>0; i--) {
				wheels[target][i]=wheels[target][i-1];
			}
			wheels[target][0]=temp;
		}else {
			int temp=wheels[target][0];
			for(int i=0; i<7; i++) {
				wheels[target][i]=wheels[target][i+1];
			}
			wheels[target][7]=temp;
		}
		
	}
	static void check(int target,int dir) {
		if(target==0) {
			if(!v[target+1]) {
				v[target+1]=true;
				if(wheels[target][2]!=wheels[target+1][6]) {
					check(target+1,dir*-1);
				}
			}
		}else if(target==n-1) {
			if(!v[target-1]) {
				v[target-1]=true;
				if(wheels[target][6]!=wheels[target-1][2]) {
					check(target-1,dir*-1);
				}
			}
		}else {
			if(!v[target+1]) {
				v[target+1]=true;
				if(wheels[target][2]!=wheels[target+1][6]) {
					check(target+1,dir*-1);
				}
			}
			if(!v[target-1]) {
				v[target-1]=true;
				if(wheels[target][6]!=wheels[target-1][2]) {
					check(target-1,dir*-1);
				}
			}
		}
		rotate(target,dir);
	}
}
