package swea;

import java.util.Scanner;

public class Swea_햄버거다이어트 {
static int n;
static int l;
static int[][] info;
static boolean[] visit;
static int ret;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			 n=sc.nextInt();
			 l=sc.nextInt();
			info=new int[n][2];
			ret=0;
			visit=new boolean[n];
			for(int i=0; i<n; i++) {
				info[i][0]=sc.nextInt();
				info[i][1]=sc.nextInt();
			}
			for(int i=1; i<=n; i++) {
				rec(0,0,i);
			}
			System.out.println("#"+t+" "+ret);
		}
	}
	static void rec(int deep,int start, int target) {
		if(deep==target) {
			int sum=0;
			int sum2=0;
			for(int i=0; i<n; i++) {
				if(visit[i]) {
					sum+=info[i][0];
					sum2+=info[i][1];
				}
			}
			if(sum2<=l) {
				ret=Math.max(ret, sum);
			}
			return;
		}
		for(int i=start; i<n;i++) {
			if(!visit[i]) {
				visit[i]=true;
				rec(deep+1,start+1,target);
				visit[i]=false;
			}
		}
	}

}
