package algo;

import java.util.Scanner;

public class C17609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			String s=sc.next();
			System.out.println(checkPalin(s));
		}
	}
	
	static int checkPalin(String inputstr) {
		int ret=0;
		
		int left=0; int right=inputstr.length()-1;
		while(left<=right) {
			
			if(inputstr.charAt(left)==inputstr.charAt(right)) {
				left++;
				right--;
			}else {
				int l=left;
				int r=right;
				l++;
				while(l<=r) {
					if(inputstr.charAt(l) == inputstr.charAt(r)) {
						l++;
						r--;
					}
					else {
						ret++;
						break;
					}
				}
				
				l = left;
				r = right;
				
				r--;
				while(l<=r){
					if(inputstr.charAt(l) == inputstr.charAt(r)) {
						l++;
						r--;
					}
					else {
						ret++;
						break;
					}
				}
				
				return ret;
			}
		}
		return ret;
		
	}
}
