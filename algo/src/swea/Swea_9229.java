package swea;

import java.util.Scanner;

public class Swea_9229 {
static int n;
static int m;
static int[]snack;
static boolean[]v;
static int ret;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			n=sc.nextInt();
			m=sc.nextInt();
			snack=new int[n];
			v=new boolean[n];
			for(int i=0; i<n; i++) {
				snack[i]=sc.nextInt();
			}
			ret=-1;
			combi(0,0,0);
			System.out.println("#"+t+" "+ret);
		}
		
	}
	static void combi(int deep, int start,int cost) {
		if(deep==2) {
			if(cost<=m) {
				ret=Math.max(ret, cost);
			}
			return;
		}
		for(int i=start; i<n; i++) {
			if(!v[i]) {
				v[i]=true;
				combi(deep+1,start+1,cost+snack[i]);
				v[i]=false;
			}
		}
	}

}
