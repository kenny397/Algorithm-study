package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C17471_dfs {
	static int n;

	static boolean[] v;
	static int answer = Integer.MAX_VALUE;
	static ArrayList<Integer> set;
	static int[] loc;
	static ArrayList<ArrayList<Integer>> adj;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		loc = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		adj = new ArrayList<>();
		adj.add(new ArrayList<>());
		for (int i = 1; i <= n; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
			adj.add(new ArrayList<>());
		}
		v = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			for (int j = 0; j < l; j++) {
				int end = Integer.parseInt(st.nextToken());
				adj.get(i).add(end);

			}
		}

		set = new ArrayList<Integer>();
		for (int i = 1; i <= n / 2; i++) {
			makeSet(1, 0, i);
		}

		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	static void makeSet(int start, int deep, int target) {
		if (deep == target) {
			// System.out.println(set);
			ArrayList<Integer> setB = new ArrayList<Integer>();
			ArrayList<Integer> setA = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				if (!set.contains(i)) {
					setB.add(i);
				} else {
					setA.add(i);
				}
			}

			v = new boolean[n + 1];
			boolean flag = true;
			v[setB.get(0)] = true;
			dfs(setB.get(0), 1, setB);
			for (int i = 0; i < setB.size(); i++) {
				if (!v[setB.get(i)]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				return;
			v = new boolean[n + 1];
			flag = true;
			v[setA.get(0)] = true;
			dfs(setA.get(0), 1, setA);
			for (int i = 0; i < setA.size(); i++) {
				if (!v[setA.get(i)]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				int dif = dif(setA, setB);
				answer = Math.min(answer, dif);
			}
			return;
		}
		for (int i = start; i <= n; i++) {

			set.add(deep, i);

			makeSet(i + 1, deep + 1, target);
			set.remove(deep);
		}
	}

	static void dfs(int cur, int deep, ArrayList<Integer> setList) {

		for (int i = 0; i < adj.get(cur).size(); i++) {
			if (setList.contains(adj.get(cur).get(i))) {
				if (v[adj.get(cur).get(i)])
					continue;
				v[adj.get(cur).get(i)] = true;
				dfs(adj.get(cur).get(i), deep + 1, setList);
			}

		}

	}

	static int dif(ArrayList<Integer> setA, ArrayList<Integer> setB) {
		int cntA = 0;
		int cntB = 0;
		for (int i = 0; i < setA.size(); i++) {
			cntA += loc[setA.get(i)];
		}
		for (int i = 0; i < setB.size(); i++) {
			cntB += loc[setB.get(i)];
		}
		return Math.abs(cntA - cntB);

	}

}
