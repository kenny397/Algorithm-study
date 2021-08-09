package swea;

import java.util.Scanner;

public class Swea2805 {
static int n;
static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			n=sc.nextInt();
			map=new int[n][n];
			for(int i=0; i<n; i++) {
				String temp=sc.next();
				for(int j=0; j<n; j++) {
					map[i][j]=temp.charAt(j)-'0';
				}
			}
			
			int height=0;
			int ret=0;
			for(int i=0; i<n; i++) {
				if(i>=n/2) {
					ret+=count(i,height);
					height--;
				}else {
					ret+=count(i,height);
					height++;
				}
				
			}
			System.out.print("#"+t+" ");
			System.out.println(ret);
			
			
		}
	}
	static int count(int col, int height) {
		int sum=map[n/2][col];
		for(int i=1; i<=height; i++) {
			sum+=map[n/2+i][col]+map[n/2-i][col];
		}
		return sum;
	}

}
