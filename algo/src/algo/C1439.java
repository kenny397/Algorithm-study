package algo;

import java.util.Scanner;

public class C1439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String t=sc.next();
		int[] count=new int[2];
		char c=t.charAt(0);
		count[c-'0']++;
		for(int i=1; i<t.length(); i++) {
			if(t.charAt(i)!=c) {
				c=t.charAt(i);
				count[c-'0']++;
			}
		}
		int min=Integer.MAX_VALUE;
		for(int a : count) {
			min=Math.min(a, min);
		}
		System.out.println(min);
	}

}
