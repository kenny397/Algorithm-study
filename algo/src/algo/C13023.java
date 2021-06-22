package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class C13023 {
static int n;
static boolean flag;
static ArrayList<ArrayList<Integer>>al;
static int[][]friend;
static boolean[]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		int m=sc.nextInt();
		al=new ArrayList<>();
		for(int i=0; i<n; i++) {
			al.add(new ArrayList<Integer>());
		}
		v=new boolean[n];
		friend=new int[n][n];
		flag=false;
		for(int i=0; i<m; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			al.get(a).add(b);
			al.get(b).add(a);
		}
		for(int i=0; i<n; i++) {
			check(i,0);
			if(flag)break;
		}
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	static void check(int a,int deep) {
		if(deep==4) {
			flag=true;
			return; 
		}
	
		for(int i : al.get(a)) {
			if(!v[i]) {
				v[a]=true;
				check(i,deep+1);
				v[a]=false;
			}
		}
	}

}
