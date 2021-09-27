package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C3109 {
	static int R;
	static int C;
	static int ret;
	static char[][] map;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static boolean[][] v;
	static boolean[] vr;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		v = new boolean[R][C];
		vr = new boolean[R];
		for (int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);

		}
		System.out.println(ret);

	}

	static void dfs(int x, int y) {
		if (y == C - 1) {
			ret++;
			flag = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			if (!v[nx][ny] && map[nx][ny] == '.') {
				v[nx][ny] = true;
				dfs(nx, ny);
				if (flag)
					return;
			}
		}
	}

}
