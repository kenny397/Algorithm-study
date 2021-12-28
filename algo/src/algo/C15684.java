package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class C15684 {
	static ArrayList<Line> lines;
	static ArrayList<Line> lines2;
	static int[] answer;
	static int N;
	static int M;
	static int H;
	static int ret;
	static boolean flag;
	static boolean[][] isPossible;
	static boolean[][] isVisit;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		isPossible = new boolean[H + 1][N + 1];
		isVisit = new boolean[H + 1][N + 1];
		lines = new ArrayList<>();
		lines2 = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			lines.add(new Line(startX, startY));
			isPossible[startX][startY] = true;
			isVisit[startX][startY] = true;
			isPossible[startX][startY - 1] = true;
			isPossible[startX][startY + 1] = true;
		}
		ret = Integer.MAX_VALUE;
		answer = new int[N + 1];

		flag = false;

		for (int i = 0; i <= 3; i++) {
			combi(1, 1, i);
			if (flag) {
				break;
			}
		}
		if (ret == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ret);
		}

	}

	static void combi(int x, int y, int deep) {
		if (deep == 0) {
			for (int i = 1; i <= N; i++) {
				answer[i] = i;
			}
			ArrayList<Line> lines3 = new ArrayList<>();
			lines3.addAll(lines2);
			lines3.addAll(lines);
			Collections.sort(lines3);
			for (int i = 0; i < lines3.size(); i++) {
				swap(lines3.get(i).y);
			}
			if (check()) {
				ret = lines2.size();
				flag = true;
			}
			return;
		}

		for (int i = x; i <= H; i++) {
			for (int j = y; j < N; j++) {
				if (!isVisit[i][j] && !isPossible[i][j]) {
					isVisit[i][j] = true;
					isVisit[i][j - 1] = true;
					isVisit[i][j + 1] = true;
					lines2.add(new Line(i, j));
					if (j == N - 1) {
						combi(x + 1, 1, deep - 1);
					} else {
						combi(x, y + 1, deep - 1);
					}
					lines2.remove(lines2.size() - 1);
					isVisit[i][j] = false;
					isVisit[i][j - 1] = false;
					isVisit[i][j + 1] = false;
				}
			}
		}
	}

	static void swap(int x) {
		int temp = answer[x];
		answer[x] = answer[x + 1];
		answer[x + 1] = temp;
	}

	static boolean check() {
		for (int i = 1; i < answer.length; i++) {
			if (i != answer[i])
				return false;
		}
		return true;
	}

	static class Line implements Comparable<Line> {
		int x;
		int y;

		public Line(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Line [x=" + x + ", y=" + y + "]";
		}

		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}

	}
}
