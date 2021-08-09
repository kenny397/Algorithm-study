package swea;

import java.util.Scanner;

public class Swea2072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int testcase=0; testcase<t; testcase++) {
			int sum=0;
			for(int i=0; i<10; i++) {
				int x=sc.nextInt();
				if(x%2==1) {
					sum+=x;
				}
			}
			System.out.println("#"+testcase+" "+sum);
		}
	}

}
