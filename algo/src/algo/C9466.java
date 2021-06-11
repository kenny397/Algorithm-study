package algo;

import java.util.Scanner;

public class C9466 {
	static boolean v[];
	static int friend[];
	static boolean pair[];
	static int ret;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int c = 0; c < t; c++) {
			int n = sc.nextInt();
			friend = new int[n];
			pair=new boolean[n];
			v = new boolean[n];
			for (int i = 0; i < n; i++) {
				friend[i] = sc.nextInt() - 1;
			}
			ret=0;
			for (int i = 0; i < n; i++) {
				if(!pair[i]) {
					dfs(i);
				}
				
			}
			System.out.println(n - ret);
		}

	}

	static void dfs(int target) {
		if (v[target]) {
			return;	
		}
		v[target]=true;
		
		if(!v[friend[target]]) {
			dfs(friend[target]);
		}else {
			if(!pair[friend[target]]) {
				ret++;
				for(int i=friend[target];i!=target; i=friend[i]) {
					ret++;
				}
			}
		}
		
		pair[target]=true;
	}

}