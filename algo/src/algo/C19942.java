package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C19942 {
static int mp;
static int mf;
static int ms;
static int mv;
static int n;
static ArrayList<Integer>al;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
		mp=sc.nextInt();
		mf=sc.nextInt();
		ms=sc.nextInt();
		mv=sc.nextInt();
		int[][]info=new int[n][5];
		for(int i=0; i<n; i++) {
			for(int j=0; j<5; j++) {
				info[i][j]=sc.nextInt();
			}
		}
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0; i<(1<<n);i++) {
			int p=0,f=0,s=0,v=0;int cost=0;
			for(int j=0; j<n; j++ ) {
				if((i&(1<<j))==(1<<j)) {
					p+=info[j][0];
					f+=info[j][1];
					s+=info[j][2];
					v+=info[j][3];
					cost+=info[j][4];
				}
			}
			if(check(p,f,s,v)) {
				if(min>cost) {
					al=new ArrayList<>();
					al.add(i);
					min=cost;
				}else if(cost==min) {
					al.add(i);
				}
			}
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
			String ret=make();
			System.out.print(ret);
//			for(int i=0; i<ret.length(); i++) {
//				if(i==ret.length()-1) {
//					System.out.print(Integer.parseInt(ret2[i]));
//					
//				}else {
//					System.out.print(Integer.parseInt(ret2[i])+" ");
//				}
//			}
			
		}
		
	}
	static boolean check(int p,int f,int s ,int v){
		if(mp<=p&&mf<=f&&ms<=s&&mv<=v) {
			return true;
		}
		return false;
	}
	static String make() {
		ArrayList<String>answer=new ArrayList<>();
		
		for(int i=0; i<al.size(); i++) {
			String ret="";
			for(int j=0; j<n; j++ ) {
				if((al.get(i)&1<<j)==1<<j) {
					ret=ret+(j+1)+" ";
				}
			}
			answer.add(ret);
		}
		Collections.sort(answer);
		
		return answer.get(0);
	}

}
