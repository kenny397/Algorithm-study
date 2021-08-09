package swea;

import java.util.Scanner;

public class Swea1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			String target=sc.next();
			char flag='0';
			int ret=0;
			for(int i=0; i<target.length(); i++) {
				if(target.charAt(i)!=flag) {
					ret++;
					flag=target.charAt(i);
				}
			}
			System.out.println("#"+t+" "+ret);
		}
	}

}
