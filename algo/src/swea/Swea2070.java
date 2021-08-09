package swea;

import java.util.Scanner;

public class Swea2070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		char ret;
		for(int testcase=1; testcase<=t; testcase++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a<b) {
				ret='<';
			}else if(a>b) {
				ret='>';
			}
			else {
				ret='=';
			}
			System.out.println("#"+testcase+" "+ret);
		}
		
	}

}
