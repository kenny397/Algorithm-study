package algo;

import java.util.Scanner;

public class C14890 {
//경사로
	static int n;
	static boolean[] v;
	static int l;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (check(i, 0)) {
				ret++;
				
			}
		}for (int i = 0; i < n; i++) {
			if (check(i, 1)) {
				ret++;
				
			}
		}
		System.out.println(ret);

	}

	static boolean check(int index, int dir) {
		v = new boolean[n];
		if (dir == 0) {

			for (int i = 0; i < n - 1; i++) {
				if (Math.abs(map[index][i] - map[index][i + 1]) > 1) {
					return false;
				}
				if (Math.abs(map[index][i] - map[index][i + 1]) == 1) {

					if (map[index][i] < map[index][i + 1]) {
						if (v[i])
							return false;
						if (!block(index, i, dir, 1)) {
							return false;
						} else {
							v[i] = true;
						}

					}
					if (map[index][i] > map[index][i + 1]) {
						if (v[i + 1])
							return false;
						if (!block(index, i + 1, dir, 0)) {
							return false;
						} else {
							v[i + 1] = true;
						}

					}
				}
				if (map[index][i] == map[index][i + 1]) {
					continue;
				}

			}

		}
		if (dir == 1) {

			for (int i = 0; i < n - 1; i++) {
				if (Math.abs(map[i][index] - map[i+1][index]) > 1) {
					return false;
				}
				if (Math.abs(map[i][index] - map[i+1][index]) == 1) {

					if (map[i][index] < map[i+1][index]) {
						if (v[i])
							return false;
						if (!block(i, index, dir, 1)) {
							return false;
						} else {
							v[i] = true;
						}

					}
					if (map[i][index] > map[i+1][index]) {
						if (v[i + 1])
							return false;
						if (!block(i+1, index, dir, 0)) {
							return false;
						} else {
							v[i + 1] = true;
						}

					}
				}
				if (map[i][index] == map[i+1][index]) {
					continue;
				}

			}

		}
		return true;
	}

	static boolean block(int x, int y, int dir, int diry) {
		if (dir == 0) {
			if (diry == 0) {

				for (int i = 1; i < l; i++) {
					if (y + i >= n)
						return false;
					if (v[y + i])
						return false;
					if (map[x][y + i] == map[x][y]) {
						v[y + i] = true;

						continue;
					} else {
						return false;
					}
				}
			}
			if (diry == 1) {
				for (int i = 1; i < l; i++) {
					if (y - i < 0)
						return false;
					if (v[y - i])
						return false;
					if (map[x][y - i] == map[x][y]) {
						v[y - i] = true;

						continue;
					} else {
						return false;
					}
				}
			}
		}
		if (dir == 1) {
			if (diry == 0) {
				for (int i = 1; i < l; i++) {
					if (x + i >= n)
						return false;
					if (v[x + i])
						return false;
					if (map[x + i][y] == map[x][y]) {
						v[x + i] = true;
						v[x] = true;
						continue;
					} else {
						return false;
					}
				}
			}
			if (diry == 1) {
				for (int i = 1; i < l; i++) {
					if (x - i < 0)
						return false;
					if (v[x - i])
						return false;
					if (map[x - i][y] == map[x][y]) {
						v[x - i] = true;
						v[x] = true;
						continue;
					} else {
						return false;
					}
				}
			}

		}

		return true;

	}
}
