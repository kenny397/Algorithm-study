package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C17143 {
	static Shark[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int row;
	static int col;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new Shark[row][col];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(s, d, z);
		}
		int ret = 0;
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (map[j][i] != null) {
					ret += map[j][i].size;
					map[j][i] = null;
					break;
				}
			}
			move();
		}

		System.out.println(ret);

	}

	static void move() {
		Shark[][] mapCopy = new Shark[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] != null) {
					Shark shark = map[i][j];
					int dir = shark.dir;

					int x = i + (dx[shark.dir] * shark.speed);
					int y = j + (dy[shark.dir] * shark.speed);
					while (true) {
						if (x >= 0 && x < row && y >= 0 && y < col)
							break;
						if (x >= row) {
							int minus = x - (row - 1);
							x = (row - 1) - minus;
							dir = 0;
						}
						if (x < 0) {
							int minus = 0 - (x);
							x = minus;
							dir = 1;
						}
						if (y >= col) {
							int minus = y - (col - 1);
							y = (col - 1) - minus;
							dir = 3;
						}
						if (y < 0) {
							int minus = 0 - (y);
							y = minus;
							dir = 2;
						}
					}

					if (mapCopy[x][y] != null) {
						if (mapCopy[x][y].size < shark.size) {
							mapCopy[x][y] = new Shark(shark.speed, dir, shark.size);

						}
					} else {

						mapCopy[x][y] = new Shark(shark.speed, dir, shark.size);
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				if (mapCopy[i][j] != null) {
					map[i][j] = mapCopy[i][j];
				} else {
					map[i][j] = null;
				}
			}
		}

	}

	static class Shark {
		int speed, dir, size;

		public Shark(int speed, int dir, int size) {
			super();
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

	}

}
