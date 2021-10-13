package algo;

import java.util.Scanner;

public class C2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int ret=1;
		int idx=1;
		if( n==1) {
		}else {
			while(true) {				
				if(n<=idx+6*ret) {
					break;
				}
				idx=idx+6*ret;
				ret++;
			}
			ret++;
		}
		System.out.println(ret);
		
	}

}
