package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C1600 {
	static int h;
	static int w;
	static int[][] map;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] hx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ret = -1;
		// bfs
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 0, 0));
		boolean[][][] v = new boolean[h][w][k + 1];
		v[0][0][0] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == h - 1 && node.y == w - 1) {
				ret = node.cnt;

				break;
			}
			// System.out.println(node);
			for (int d = 0; d < 4; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if (map[nx][ny] == 1)
					continue;
				if (!v[nx][ny][node.k]) {
					v[nx][ny][node.k] = true;
					q.add(new Node(nx, ny, node.k, node.cnt + 1));
				}
			}
			if (node.k == k)
				continue;
			for (int d = 0; d < 8; d++) {
				int nx = node.x + hx[d];
				int ny = node.y + hy[d];
				if (nx < 0 || ny < 0 || nx >= h || ny >= w)
					continue;
				if (map[nx][ny] == 1)
					continue;
				if (!v[nx][ny][node.k + 1]) {
					v[nx][ny][node.k + 1] = true;
					q.add(new Node(nx, ny, node.k + 1, node.cnt + 1));
				}
			}

		}

		System.out.println(ret);

	}

	static class Node {
		int x, y, k, cnt;

		public Node(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + "]";
		}

	}

}
