package algo;

import java.util.Scanner;

public class C5002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		String a=sc.next();
		char[]line=a.toCharArray();
		int m=0;
		int w=0;
		for(int i=0; i<line.length; i++) {
			if(w==m) {
				if(line[i]=='M') {
				m++;
				}else {
				w++;
				}
			}
			else if(w>m) {
				if(line[i]=='M') {
					m++;
				}else {
					if(i+1==line.length) {
						m++;
					}
					else if(line[i+1]=='M') {
						line[i+1]='W';
						m++;
					}else {
						w++;
					}
				}
			}else {
				if(line[i]=='W') {
					w++;
				}else {
					if(i+1==line.length) {
						w++;
					}
					else if(line[i+1]=='W') {
						line[i+1]='M';
						w++;
					}else {
						m++;
					}
				}
			}
			if(Math.abs(w-m)>x) {
				w--;
				break;
			}
			
			
		}
		System.out.println(w+m);
	}

}
