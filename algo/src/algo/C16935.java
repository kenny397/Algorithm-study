package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C16935 {
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = pI(st.nextToken());
		m = pI(st.nextToken());
		int r = pI(st.nextToken());
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = pI(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			map = select(pI(st.nextToken()), map);
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] select(int i, int[][] map) {
		// TODO Auto-generated method stub
		if (i == 1) {
			return moveOne(map);
		}
		if (i == 2) {
			return moveTwo(map);
		}
		if (i == 3) {
			return moveThree(map);
		}
		if (i == 4) {
			return moveFour(map);
		}
		if (i == 5) {
			return moveFive(map);
		}
		if (i == 6) {
			return moveSix(map);
		}
		return null;
	}

	private static int[][] moveFive(int[][] map) {
		// TODO Auto-generated method stub
		int[][] upleft = new int[n / 2][m / 2];
		int[][] downleft = new int[n / 2][m / 2];
		int[][] upright = new int[n / 2][m / 2];
		int[][] downright = new int[n / 2][m / 2];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				upleft[i][j] = map[i][j];
			}
		}
		int x = 0;
		int y = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				downleft[x][y++] = map[i][j];
			}
			x++;
		}
		x = 0;
		y = 0;

		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				upright[x][y++] = map[i][j];
			}
			x++;
		}

		x = 0;
		y = 0;

		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				downright[x][y++] = map[i][j];
			}
			x++;
		}
		for (int i = 0; i < n; i++) {
			y = 0;
			for (int j = 0; j < m; j++) {
				if (i < n / 2 && j < m / 2) {
					map[i][j] = downleft[i][j];
				}
				if (i >= n / 2 && j < m / 2) {
					map[i][j] = downright[i - n / 2][j];
				}
				if (i < n / 2 && j >= m / 2) {
					map[i][j] = upleft[i][j - m / 2];
				}
				if (i >= n / 2 && j >= m / 2) {
					map[i][j] = upright[i - n / 2][j - m / 2];
				}
			}
		}

		return map;
	}

	private static int[][] moveSix(int[][] map) {
		// TODO Auto-generated method stub
		int[][] upleft = new int[n / 2][m / 2];
		int[][] downleft = new int[n / 2][m / 2];
		int[][] upright = new int[n / 2][m / 2];
		int[][] downright = new int[n / 2][m / 2];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				upleft[i][j] = map[i][j];
			}
		}
		int x = 0;
		int y = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				downleft[x][y++] = map[i][j];
			}
			x++;
		}
		x = 0;
		y = 0;

		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				upright[x][y++] = map[i][j];
			}
			x++;
		}

		x = 0;
		y = 0;

		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				downright[x][y++] = map[i][j];
			}
			x++;
		}
		for (int i = 0; i < n; i++) {
			y = 0;
			for (int j = 0; j < m; j++) {
				if (i < n / 2 && j < m / 2) {
					map[i][j] = upright[i][j];
				}
				if (i >= n / 2 && j < m / 2) {
					map[i][j] = upleft[i - n / 2][j];
				}
				if (i < n / 2 && j >= m / 2) {
					map[i][j] = downright[i][j - m / 2];
				}
				if (i >= n / 2 && j >= m / 2) {
					map[i][j] = downleft[i - n / 2][j - m / 2];
				}
			}
		}

		return map;
	}

	private static int[][] moveFour(int[][] map) {
		// TODO Auto-generated method stub
		int[][] copyMap = new int[m][n];
		/*
		 * for(int i=0; i<n; i++) { for(int j=0; j<m; j++) { copyMap[i][j]=map[i][j]; }
		 * }
		 */

		for (int i = n - 1; i >= 0; i--) {
			int[] rowmap = new int[m];
			for (int j = m - 1; j >= 0; j--) {
				rowmap[j] = map[i][j];
			}
			for (int j = m - 1; j >= 0; j--) {
				copyMap[j][i] = rowmap[m - 1 - j];
			}
		}
		int temp = m;
		m = n;
		n = temp;
		return copyMap;
	}

	private static int[][] moveThree(int[][] map) {
		// TODO Auto-generated method stub
		int[][] copyMap = new int[m][n];
		/*
		 * for(int i=0; i<n; i++) { for(int j=0; j<m; j++) { copyMap[i][j]=map[i][j]; }
		 * }
		 */
		int l = m;
		for (int i = 0; i < n; i++) {
			int[] rowmap = new int[m];
			for (int j = 0; j < m; j++) {
				rowmap[j] = map[i][j];
			}
			for (int j = 0; j < m; j++) {
				copyMap[j][n - 1 - i] = rowmap[j];
			}
		}
		int temp = m;
		m = n;
		n = temp;
		return copyMap;

	}

	private static int[][] moveTwo(int[][] map) {
		// TODO Auto-generated method stub
		int[][] left = new int[n][m / 2];
		int[][] right = new int[n][m / 2];
		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			y = 0;
			for (int j = m / 2 - 1; j >= 0; j--) {
				left[x][y++] = map[i][j];

			}
			x++;
		}
		x = 0;
		y = 0;
		for (int i = 0; i < n; i++) {
			y = 0;
			for (int j = m - 1; j >= m / 2; j--) {
				right[x][y++] = map[i][j];
			}
			x++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j < m / 2) {
					map[i][j] = right[i][j];
				} else {
					map[i][j] = left[i][j - (m / 2)];
				}
			}
		}
		return map;
	}

	private static int[][] moveOne(int[][] map) {
		// TODO Auto-generated method stub
		int[][] up = new int[n / 2][m];
		int[][] down = new int[n / 2][m];
		int x = 0;
		int y = 0;
		for (int i = n / 2 - 1; i >= 0; i--) {
			y = 0;
			for (int j = 0; j < m; j++) {
				up[x][y++] = map[i][j];

			}
			x++;
		}
		x = 0;
		y = 0;
		for (int i = n - 1; i >= n / 2; i--) {
			y = 0;
			for (int j = 0; j < m; j++) {
				down[x][y++] = map[i][j];
			}
			x++;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i < n / 2) {
					map[i][j] = down[i][j];
				} else {
					map[i][j] = up[i - (n / 2)][j];
				}
			}
		}
		return map;
	}

	static int pI(String s) {
		return Integer.parseInt(s);
	}

}
