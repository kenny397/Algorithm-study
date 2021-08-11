package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C17406 {
	static Node[] node;
	static int[][] copyMap;
	static int[][] map;
	static int n;
	static int m;
	static boolean[] v;
	static int k;
	static int answer = Integer.MAX_VALUE;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = pI(st.nextToken());
		m = pI(st.nextToken());
		k = pI(st.nextToken());
		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = pI(st.nextToken());
			}
		}
		node = new Node[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			node[i] = new Node(pI(st.nextToken()), pI(st.nextToken()), pI(st.nextToken()));
		}

		v = new boolean[k];
		sequence(0, new ArrayList<Integer>());
		System.out.println(answer);
	}

	static int pI(String s) {
		return Integer.parseInt(s);
	}

	static int checkMin() {
		int ret = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				sum += copyMap[i][j];
			}
			ret = Math.min(ret, sum);
		}
		return ret;
	}

	static void rotate(int r, int c, int size) {

		for (int i = 0; i < size; i++) {
			int x = r - size + i;
			int y = c - size + i;
			int temp = copyMap[x][y];
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx < r - size + i || ny < c - size + i || nx > r + size - i || ny > c + size - i)
						break;
					copyMap[x][y] = copyMap[nx][ny];
					x = nx;
					y = ny;
				}
			}
			copyMap[r - size + i][c - size + i + 1] = temp;
		}

	}

	static void sequence(int deep, ArrayList<Integer> al) {
		if (deep == k) {
			// System.out.println(al);
			copy();

			for (int i = 0; i < k; i++) {
				rotate(node[al.get(i)].r, node[al.get(i)].c, node[al.get(i)].s);
			}
			answer = Math.min(checkMin(), answer);
			// print();

			return;
		}
		for (int i = 0; i < k; i++) {
			if (!v[i]) {
				v[i] = true;

				ArrayList<Integer> al2 = new ArrayList<>(al);
				al2.add(i);
				sequence(deep + 1, al2);
				v[i] = false;
			}
		}

	}

	static void copy() {
		copyMap = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	static class Node {
		int r;
		int c;
		int s;

		public Node(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

	}

	static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
	}

}
