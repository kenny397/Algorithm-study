package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C15686 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] cache;
	static boolean[] v;
	static int ret = Integer.MAX_VALUE;
	static ArrayList<Node> chi;
	static ArrayList<Node> home;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		chi = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					chi.add(new Node(i, j));
				if (map[i][j] == 1)
					home.add(new Node(i, j));
			}
		}
		v = new boolean[chi.size()];
		combi(0, 0);
		System.out.println(ret);
	}

	static void combi(int deep, int start) {
		if (deep == m) {

			int sum = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < chi.size(); j++) {
					if (v[j]) {
						min = Math.min(Math.abs(home.get(i).x - chi.get(j).x) + Math.abs(home.get(i).y - chi.get(j).y),
								min);
					}
				}
				sum += min;
			}
			ret = Math.min(sum, ret);

			return;
		}
		for (int i = start; i < v.length; i++) {
			if (!v[i]) {
				v[i] = true;
				combi(deep + 1, i + 1);
				v[i] = false;
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
