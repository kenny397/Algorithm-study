package algo;

import java.util.Scanner;

public class C12904 {
static int deep;
static int answer=0;
static int cntA=0;
static int cntB=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String t=sc.next();
		while(true) {
			if(s.length()==t.length()) {
				if(s.equals(t)) {
					answer=1;
				}
				break;
			}
			if(t.charAt(t.length()-1)=='A') {
				t=t.substring(0,t.length()-1);
			}else {
				
				StringBuilder sb=new StringBuilder(t);
				sb.deleteCharAt(t.length()-1);
				sb.reverse();
				t=sb.toString();
			}
		}
//		deep=t.length()-s.length();
//		for(int i=0; i<t.length(); i++) {
//			if(t.charAt(i)=='A') {
//				cntA++;
//			}else {
//				cntB++;
//			}
//		}
//		for(int i=0; i<s.length(); i++){
//			if(s.charAt(i)=='A') {
//				cntA--;
//			}else {
//				cntB--;
//			}
//		}
//		isComvert(s,t,0,0,0);
		System.out.println(answer);
	}
//	static void isComvert(String input, String target,int c,int a,int b) {
//		if(c==deep) {
//			if(input.equals(target)) {
//				answer=1;
//				return;
//			}else {
//				answer=Math.max(answer, 0);
//				return;
//			}
//		}
//		if(a<cntA) {
//			isComvert(plusA(input),target,c+1,a+1,b);			
//		}
//		if(cntB>b) {
//			isComvert(plusB(input),target,c+1,a,b+1);			
//		}
//		
//		return;
//	}
//	static String plusA(String input) {
//		return input+"A";
//	}
//	static String plusB(String input) {
//		StringBuilder sb=new StringBuilder(input);
//		sb.reverse();
//		sb.append("B");
//		return sb.toString();
//		
//	}

}
