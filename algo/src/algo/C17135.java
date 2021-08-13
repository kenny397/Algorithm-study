package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C17135 {
	static int n;
	static int m;
	static int d;
	static boolean[][] attack;
	static int[][] copyMap;
	static int[][] map;
	static int[] v;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };
	static int ret;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		attack = new boolean[n][m];
		copyMap = new int[n][m];
		v = new int[3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
		combi(0, 0);
		System.out.println(ret);

	}

	// 궁수 배치
	static void combi(int deep, int start) {
		if (deep == 3) {
			for (int i = 0; i < n; i++) {
				map[i] = copyMap[i].clone();
			}
			int sum = select();
			ret = Math.max(ret, sum);
			return;
		}
		for (int i = start; i < m; i++) {
			v[deep] = i;
			combi(deep + 1, i + 1);

		}

	}

	// 공격할 적 선택?
	static int select() {
		int sum = 0;
		for (int j = n - 1; j >= 0; j--) {
			for (int i = 0; i < 3; i++) {
			
				bfs(v[i], j);
			}

			for (int i = 0; i < n; i++) {
				for (int z = 0; z < m; z++) {
					if (attack[i][z]) {
						sum++;
						attack[i][z] = false;
						map[i][z] = 0;

					}
				}
			}

		}
		return sum;

	}

	static void bfs(int s, int j) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		q.offer(new Node(j, s, 1));
		visit[j][s] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.d > d)
				break;
			if (map[node.x][node.y] == 1) {
				attack[node.x][node.y] = true;
				break;
			}

			for (int i = 0; i < 3; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if (x < 0 || y < 0 || x >= n || y >= m)
					continue;
				if (!visit[x][y]) {
					visit[x][y] = true;
					q.add(new Node(x, y, node.d + 1));

				}
			}

		}
	}

	static class Node {
		int x, y, d;

		public Node(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

}
