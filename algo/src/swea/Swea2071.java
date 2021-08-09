package swea;

import java.util.Scanner;

public class Swea2071 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int testcase=1; testcase<=t; testcase++) {
			double sum=0;
			for(int i=0; i<10; i++) {
				sum+=sc.nextInt();
			}
			double d=sum/10;
			System.out.println("#"+testcase+" "+Math.round(d));
		}
	}

}
