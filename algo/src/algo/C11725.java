package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C11725 {
	static ArrayList<ArrayList<Integer>> map;
	static int N;
	static boolean isV[];
	static int answer[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new ArrayList<>();
		answer = new int[N + 1];
		isV = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.get(start).add(end);
			map.get(end).add(start);
		}
		dfs(1);
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}

	static void dfs(int root) {
		for (int i = 0; i < map.get(root).size(); i++) {
			if (answer[map.get(root).get(i)] == 0) {
				answer[map.get(root).get(i)] = root;
				dfs(map.get(root).get(i));
			}
		}
	}

}
