package algo;

import java.util.Scanner;

public class C8911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			String s=sc.next();
			solution(s);
		}
	}
	static void solution(String s) {
		int[]dy= {1,0,-1,0};
		int[]dx= {0,1,0,-1};
		int y=0;
		int x=0;
		int maxy=0;
		int maxx=0;
		int miny=0;
		int minx=0;
		int dir=0;
		for(int i=0; i<s.length();i++) {
			char t=s.charAt(i);
			if(t=='F') {
				
				x+=dx[dir];
				y+=dy[dir];
				if(x<minx) {
					minx=x;
				}
				if(x>maxx) {
					maxx=x;
				}
				if(y>maxy) {
					maxy=y;
				}
				 if(y<miny) {
					miny=y;
				}
				 
				
			}
			if(t=='B') {
				x+=-dx[dir];
				y+=-dy[dir];
				if(x<minx) {
					minx=x;
				}
				if(x>maxx) {
					maxx=x;
				}
				if(y>maxy) {
					maxy=y;
				}
				 if(y<miny) {
					miny=y;
				}
				
			}
			 if(t=='L') {
				if(dir==0) {
					
					dir=3;
				}else {
					dir--;
				}
				
			}
			 if(t=='R') {
				if(dir==3) {
					dir=0;
				}else {
					dir++;
				}
				
			}
			 
		}System.out.println((maxx-minx)*(maxy-miny));
		
		
		
	}
}
