package algo;

import java.util.Scanner;

public class C2477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc= new Scanner(System.in);
		 int k=sc.nextInt();
		 int[] ar=new int[6];
		 int ret=0;
		 for(int i=0; i<6; i++) {
			 int dir=sc.nextInt();
			 int l=sc.nextInt();
			 ar[i]=l;
		 }
		 ret+=ar[0]*ar[5];
		 ret+=ar[2]*ar[3];
		 ret*=k;
		 System.out.println(ret);
	}
	
}
