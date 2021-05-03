package algo;

import java.util.Arrays;
import java.util.Scanner;

public class C3190 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] map;
	static int[] time;
	static String[] dir;
	static int timer;
	static int idx;
	static int endx;
	static int endy;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 0; i < k; i++) {
			map[sc.nextInt()-1][sc.nextInt()-1] = 5;

		}
		endx = 0;
		endy = 0;
		idx = 0;

		timer = 0;
		int ro = sc.nextInt();
		time = new int[ro];
		dir = new String[ro];
		for (int i = 0; i < ro; i++) {
			time[i] = sc.nextInt();
			dir[i] = sc.next();
		}

		map[endx][endy] = 0;
		move(0, 0, 0);
		System.out.println(timer + 1);

	}

	static void move(int x, int y, int dirinfo) {

		int nextx = x + dx[dirinfo];
		int nexty = y + dy[dirinfo];
		if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map.length)
			return;
		if (map[nextx][nexty] > -1 && map[nextx][nexty] < 5) {
			return;
		}
		timer++;
		
		if (map[nextx][nexty] != 5) {
			int t = map[endx][endy];
			map[endx][endy] = -1;
			endx = endx + dx[t];
			endy = endy + dy[t];
		}
		if (idx < time.length) {
			if (timer == time[idx]) {
				if (dir[idx].equals("D")) {
					if (dirinfo == 3)
						dirinfo = 0;
					else
						dirinfo += 1;
				}
				if (dir[idx].equals("L")) {
					if (dirinfo == 0)
						dirinfo = 3;
					else
						dirinfo -= 1;
				}
				idx++;
			}
		}
		map[nextx][nexty] = dirinfo;
		move(nextx, nexty, dirinfo);

	}

}
