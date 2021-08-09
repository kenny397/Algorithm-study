package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Swea9660 {
static int n;
static int[]cache;
static int[]unlike;
static boolean[]v;
static long ret;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1; i<=t; i++) {
			n=sc.nextInt();
			unlike=new int[n+1];
			v=new boolean[n+1];
			cache=new int[n+1];
			for(int j=1; j<=n; j++) {
				unlike[j]=sc.nextInt();
			}
			ret=0;
			
			
			System.out.println("#"+i+" "+dfs(1,n+1));
		}
	}
	
	static long dfs(int start,int deep) {
		if(start==deep) {
			return 1;
		}
		
		int re=0;
	
		for(int i=1; i<=n; i++) {
			if(!v[i]&&unlike[start]!=i) {
				v[i]=true;
				re+=dfs(start+1,deep);
				v[i]=false;
			}
		}
		return re;
	}

}