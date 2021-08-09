package swea;

import java.util.Scanner;

public class Swea1493 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int[][]map=new int[301][301];
		int idx=1;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=i; j++) {
				map[i][j]=idx++;
			}
		}
		for(int i=1; i<=5; i++) {
			System.out.println();
			for(int j=1; j<=5; j++) {
				System.out.print(map[i][j]);
			}
		}
		
		
	}

}
