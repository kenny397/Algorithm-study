package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C1992 {
static int[][] map;
static int n;
static String ret="";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n= sc.nextInt();
		map=new int[n][n];
		for(int i=0; i<n; i++) {
			String t=sc.next();
			for(int j=0; j<n; j++) {
				map[i][j]=t.charAt(j)-'0';
			}
		}
		System.out.println(rec(0,0,n));
	}
	static String rec(int x,int y,int size) {
		if(check(x,y,size)) {
			String t= map[x][y]+"";
			return t;
		}
		
		
		
		
		return "("+rec(x,y,size/2)+rec(x,y+size/2,size/2)+rec(x+size/2,y,size/2)+rec(x+size/2,y+size/2,size/2)+")";
	}
	
	
	
	
	static boolean check(int x, int y, int size) {
		int flag=map[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(flag!=map[i][j])return false;
			}
		}
		return true;
		
	}

}
