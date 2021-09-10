package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C16926 {
	static int[][] map;
	static int n;
	static int m;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int rotate = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < rotate; r++) {
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!v[i][j]) {
						
						v[i][j] = true;
						if(v[i+1][j])break;
						int temp = map[i][j + 1];
						rotate(i, j, 3, temp);
						map[i][j] = temp;
					}

				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == n - 1 && j == m - 1)
					System.out.print(map[i][j]);
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void rotate(int x, int y, int dir, int temp) {

		if (dir == -1) {
			return;
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx < 0 || ny < 0 || nx >= n || ny >= m || v[nx][ny]) {
			rotate(x, y, (dir - 1), temp);
		} else {

			v[nx][ny] = true;
			rotate(nx, ny, dir, temp);
			map[nx][ny] = map[x][y];
		}
	}

}
