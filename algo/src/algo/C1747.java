package algo;

import java.util.Scanner;

public class C1747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=n; i<=1003001; i++) {
			
			if(checkA(i)) {
				if(checkB(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	static boolean checkA(int n) {
		String a=String.valueOf(n);
		StringBuilder sb=new StringBuilder(a);
		sb.reverse();
		if(a.equals(sb.toString())) {
			return true;
		}
		return false;
	}
	static boolean checkB(int n) {
		if(n==1)return false;
		for(int i=2; i<n; i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
}
