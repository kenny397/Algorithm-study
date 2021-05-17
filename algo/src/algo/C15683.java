package algo;

import java.util.Scanner;

public class C15683 {
	static int n;
	static int m;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	static int min;
	static int[][]copyMap;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		min = Integer.MAX_VALUE;
		copyMap = new int[n][m];
		 map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyMap[i][j] = sc.nextInt();
			}
		}
		
		
		dfs(0,-1);
		System.out.println(min);

	}

	static void dfs(int idx,int cnt) {
		if (idx == n * m) {
			
			min = Math.min(min, countroom());
			
			return ;
		}
		int i = idx / m;
		int j = idx % m;
		if (copyMap[i][j] == 1) {
			for (int d = 0; d < 4; d++) {
				watching(d, 1, i, j,0,cnt);
				dfs(idx+1,cnt-1);
				watching(0, 5, i, j,cnt,0);
				
			}
		}
		else if (copyMap[i][j] == 2) {
			for (int d = 0; d < 2; d++) {
				watching(d, 2, i, j,0,cnt);
				dfs(idx+1,cnt-1);
				watching(0, 5, i, j,cnt,0);
			}
		}
		else if (copyMap[i][j] == 3) {
			for (int d = 0; d < 4; d++) {
				watching(d, 3, i, j,0,cnt);
				dfs(idx+1,cnt-1);
				watching(0, 5, i, j,cnt,0);
			}
		}
		else if (copyMap[i][j] == 4) {
			for (int d = 0; d < 4; d++) {
				watching(d, 4, i, j,0,cnt);
				dfs(idx+1,cnt-1);
				watching(0, 5, i, j,cnt,0);
			}
		}
		else if (copyMap[i][j] == 5) {
			watching(0, 5, i, j,0,cnt);
			dfs(idx+1,cnt-1);
			watching(0, 5, i, j,cnt,0);
		}
		else {
			dfs(idx+1,cnt-1);
		}
		return;

	}

	static int countroom() {
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0)
					ret++;
			}
		}
		return ret;
	}

	static void watching(int dir, int cctv, int x, int y,int o, int c) {
		if (cctv == 1) {
			if (dir == 0) {
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}

				}
			}
			if (dir == 1) {
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
			if (dir == 2) {
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
			}
			if (dir == 3) {
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
		}
		if (cctv == 2) {
			if (dir == 0) {
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
			}
			if (dir == 1) {
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
		}
		if (cctv == 3) {
			if (dir == 0) {
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
			if (dir == 1) {
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
			}
			if (dir == 2) {
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
			if (dir == 3) {
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
			}
		}
		if (cctv == 4) {
			if (dir == 0) {
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
			}
			if (dir == 1) {
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
			}
			if (dir == 2) {
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
			}
			if (dir == 3) {
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] ==o)
						copyMap[x][i] = c;
				}
			}
		}
		if (cctv == 5) {
			if (dir == 0) {
				for (int i = y; i >= 0; i--) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i < n; i++) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o) {
						copyMap[i][y] = c;
					}
				}
				for (int i = y; i < m; i++) {
					if (copyMap[x][i] == 6)
						break;
					if (copyMap[x][i] == o)
						copyMap[x][i] = c;
				}
				for (int i = x; i >= 0; i--) {
					if (copyMap[i][y] == 6)
						break;
					if (copyMap[i][y] == o)
						copyMap[i][y] = c;
				}
			}
		}
		return;
	}
	static int[][] copy() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				copyMap[i][j]=map[i][j];
			}
		}
		return copyMap;
	}

}
