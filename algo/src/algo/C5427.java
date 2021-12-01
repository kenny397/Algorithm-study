package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C5427 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int w;
	static int h;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
			}
			int ret = bfs();
			if (ret == -1) {
				System.out.println("IMPOSSIBLE");

			} else {
				System.out.println(ret);

			}

		}
	}

	static int bfs() {
		int ret = -1;
		Queue<Node> q = new LinkedList<>();

		int sx = 0;
		int sy = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == '*') {
					q.add(new Node(i, j, -1));

				}
				if (map[i][j] == '@') {
					map[i][j] = '.';
					sx = i;
					sy = j;
				}
			}
		}
		q.add(new Node(sx, sy, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if (node.cnt == -1) {
					if (x < 0 || y < 0 || x >= h || y >= w)
						continue;
					if (map[x][y] == '.') {
						map[x][y] = '@';
						q.add(new Node(x, y, -1));
					}
				} else {
					if (x < 0 || y < 0 || x >= h || y >= w) {
						ret = node.cnt + 1;
						return ret;
					} else {
						if (map[x][y] == '.') {
							map[x][y] = '@';
							q.add(new Node(x, y, node.cnt + 1));
						}
					}

				}
			}

		}

		return ret;
	}

	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}
}
