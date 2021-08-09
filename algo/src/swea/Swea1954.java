package swea;

import java.util.Scanner;

public class Swea1954 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int cnt;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			map = new int[n][n];
			cnt=1;
			map[0][0] = cnt++;
			rec(0, 0, 0);
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(j==n-1) System.out.print(map[i][j]);
					else System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

	static void rec(int x, int y, int dir) {
		if(cnt==map.length*map.length+1)return;
		if (x + dx[dir] < 0 || y + dy[dir] < 0 || x + dx[dir] > map.length - 1 || y + dy[dir] > map.length - 1||map[x+dx[dir]][y+dy[dir]]!=0) {
			dir = (dir + 1) % 4;
		}

		map[x + dx[dir]][y + dy[dir]] = cnt++;
		rec(x + dx[dir], y + dy[dir], dir);
	}

}
