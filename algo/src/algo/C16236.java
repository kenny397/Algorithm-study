package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C16236 {
	static int[][] map;
	static int ret;
	static int currentx;
	static int currenty;
	static int size = 2;
	static int point = 0;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					currentx = i;
					currenty = j;
				}
			}
		}
		int max = 0;
		while (true) {
			max = ret;
			bfs(currentx, currenty);
			if (max == ret)
				break;
		}
		System.out.println(ret);
	}

	private static void bfs(int startx, int starty) {
		// TODO Auto-generated method stub
		boolean[][] v = new boolean[map.length][map.length];
		ArrayList<Node> al = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		int max = Integer.MAX_VALUE;
		q.add(new Node(startx, starty, 0));
		v[startx][starty] = true;
		map[startx][starty] = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (max < node.d)
				break;
			if (map[node.x][node.y] != 0 && map[node.x][node.y] < size && node.d <= max) {
				max = node.d;
				al.add(new Node(node.x, node.y, node.d));
			}
			for (int i = 0; i < 4; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				if (x < 0 || y < 0 || x >= map.length || y >= map.length)
					continue;
				if (!v[x][y] && map[x][y] <= size) {
					v[x][y] = true;
					q.add(new Node(x, y, node.d + 1));
				}
			}

		}
		Collections.sort(al, (o1, o2) -> {
			if (o1.x == o2.x) {
				return o1.y - o2.y;
			}
			return o1.x - o2.x;
		});
		if (!al.isEmpty()) {
			ret += al.get(0).d;
			point++;
			currentx = al.get(0).x;
			currenty = al.get(0).y;
			map[currentx][currenty] = 0;
			if (point == size) {
				point = 0;
				size++;
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
