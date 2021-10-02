package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_전기회로 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<int[]> al;
	static int ret;
	static int n;
	static int[][] map;
	static int count;
	static int core;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ret = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			core = 0;
			al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && !(i == 0 || i == n - 1 || j == 0 || j == n - 1)) {
						al.add(new int[] { i, j });
					}
				}
			}
			if (al.size() == 0) {
				ret = 0;
			} else {
				for (int i = 0; i < 4; i++) {
					dfs(0, i, 0, 0);
				}

			}
			System.out.println("#" + t + " " + ret);
		}
	}

	static int operate(int x, int y, int dir, int set) {
		int cnt = 0;
		if (dir == 0) {
			for (int i = y - 1; i >= 0; i--) {
				cnt++;
				map[x][i] = set;
			}
		}
		if (dir == 1) {
			for (int i = y + 1; i < n; i++) {
				cnt++;
				map[x][i] = set;
			}
		}
		if (dir == 2) {
			for (int i = x + 1; i < n; i++) {
				cnt++;
				map[i][y] = set;
			}
		}
		if (dir == 3) {
			for (int i = x - 1; i >= 0; i--) {
				map[i][y] = set;
				cnt++;
			}
		}
		return cnt;
	}

	static void dfs(int deep, int dir, int count, int sucess) {

		if (deep == al.size()) {
			if (sucess < core)
				return;
			if (sucess > core) {
				ret = Integer.MAX_VALUE;
				core = sucess;
			}
			

			ret = Math.min(ret, count);
			return;
		}

		int x = al.get(deep)[0];
		int y = al.get(deep)[1];
		if (checkLine(x, y, dir)) {
			int cnt = operate(x, y, dir, 1);
			for (int i = 0; i < 4; i++) {
				dfs(deep + 1, i, count + cnt, sucess + 1);
			}
			operate(x, y, dir, 0);
		} else {

			for (int i = 0; i < 4; i++) {
				dfs(deep + 1, i, count, sucess);
			}

		}

	}

	static boolean checkLine(int x, int y, int dir) {
		for (int i = 0; i < n; i++) {
			x = x + dx[dir];
			y = y + dy[dir];
			if (map[x][y] == 1) {
				return false;
			}
			if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
				return true;
			}

		}
		return false;

	}
}
