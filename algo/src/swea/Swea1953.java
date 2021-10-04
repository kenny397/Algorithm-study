package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1953 {
	static int[] dx = { 0, 0, 1, -1 };
	static int ret;
	static int n;
	static boolean[][] v;
	static int m;
	static int[][] map;
	static int l;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] tunnel = { 0, 15, 12, 3, 9, 5, 6, 10 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			v = new boolean[n][m];
			ret = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			v[r][c] = true;
			Queue<Node> q = new LinkedList<>();
			q.offer(new Node(r, c, 0));
			while (!q.isEmpty()) {
				Node node = q.poll();
				if (node.weight == l) {
					break;
				}
				ret++;
				for (int d = 0; d < 4; d++) {
					if ((tunnel[map[node.x][node.y]] & (1 << d)) != 0) {
						int nx = node.x + dx[d];
						int ny = node.y + dy[d];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue;
						if (map[nx][ny] == 0)
							continue;
						int dir = 0;
						if (d == 0 || d == 2)
							dir = d + 1;
						if (d == 1 || d == 3)
							dir = d - 1;
						if ((tunnel[map[nx][ny]] & (1 << dir)) == 0)
							continue;
						if (!v[nx][ny]) {
							v[nx][ny] = true;
							q.offer(new Node(nx, ny, node.weight + 1));
						}

					}
				}
			}
			System.out.println("#" + t + " " + ret);

		}

	}

	static class Node {
		int x, y, weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

	}

}
