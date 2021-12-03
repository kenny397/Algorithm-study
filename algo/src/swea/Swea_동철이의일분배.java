package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_동철이의일분배 {
	static boolean[] v;
	static int n;
	static double result;
	static int[][] map;
	static int[] charge;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result=0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new boolean[n];
			charge = new int[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs2(0,1);
			result*=100;
			System.out.println("#"+t+" "+String.format("%.6f", result));
		}

	}
	
	static void dfs2(int deep,double per) {
		if (deep == n) {
			result=Math.max(per, result);
			return;
		}
		if(per<=result) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				dfs2(deep + 1,per*map[deep][i]*0.01);
				v[i] = false;
			}
		}
	}
	static void dfs(int deep) {
		if (deep == n) {
			double ret = cal();
			result = Math.max(result, ret);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				charge[deep] = i;
				dfs(deep + 1);
				v[i] = false;
			}
		}
	}

	static double cal() {
		double ret = 1;
		for (int i = 0; i < n; i++) {
			ret *= (map[i][charge[i]] * 0.01);
		}
		ret *= 100;
		return ret;
	}

}
