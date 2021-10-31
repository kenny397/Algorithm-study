package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C15683 {
	static int[][] map;
	static boolean[][] v;
	static int N;
	static int M;
	static int c;
	static ArrayList<Node> al;
	static int ret = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];
		al = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					al.add(new Node(i, j));
				}
			}
		}
//		for(Node n : al) {
//			System.out.println(n.x+" "+n.y);
//		}
		search(0);
		System.out.println(ret);

	}

	private static int count() {
		int sum = 0;
		c++;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					sum++;

				}
				System.out.print(v[i][j] + "" + map[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println();
		return sum;
	}

	static void search(int deep) {
		if (al.size() == deep) {

			ret = Math.min(ret, count());
			return;
		}
		if (map[al.get(deep).x][al.get(deep).y] == 1) {
			for (int i = 0; i < 4; i++) {
				cctv1(i, deep, 0,-1);
				search(deep + 1);
				cctv1(i, deep, -1,0);
			}

		} else if (map[al.get(deep).x][al.get(deep).y] == 2) {
			for (int i = 0; i < 2; i++) {

				cctv2(i, deep, 0,-2);
				search(deep + 1);
				cctv2(i, deep, -2,0);
			}
		} else if (map[al.get(deep).x][al.get(deep).y] == 3) {
			for (int i = 0; i < 4; i++) {
				cctv3(i, deep, 0,-3);
				search(deep + 1);
				cctv3(i, deep, -3,0);
			}
		} else if (map[al.get(deep).x][al.get(deep).y] == 4) {
			for (int i = 0; i < 4; i++) {
				cctv4(i, deep, 0,-4);
				search(deep + 1);
				cctv4(i, deep, -4,0);
			}
		} else if (map[al.get(deep).x][al.get(deep).y] == 5) {
			cctv5(0, deep, 0,-5);
			search(deep + 1);
			cctv5(0, deep, -5,0);
		}
	}

	static void cctv2(int dir, int deep, int to,int from) {
		int x = al.get(deep).x;
		int y = al.get(deep).y;
		if (dir == 0) {
			for (int i = x; i >= 0; i--) {

				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
		}
		if (dir == 1) {
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
	}

	static void cctv1(int dir, int deep, int to ,int from) {
		int x = al.get(deep).x;
		int y = al.get(deep).y;
		if (dir == 0) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
		}
		if (dir == 1) {
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
		}
		if (dir == 2) {
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 3) {
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}

		}
	}

	static void cctv3(int dir, int deep,  int to , int from) {
		int x = al.get(deep).x;
		int y = al.get(deep).y;
		if (dir == 0) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 1) {
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 2) {
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
		}
		if (dir == 3) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}

		}
	}

	static void cctv4(int dir, int deep,  int to , int from) {
		int x = al.get(deep).x;
		int y = al.get(deep).y;
		if (dir == 0) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 1) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 2) {
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
		}
		if (dir == 3) {
			for (int i = x; i < N; i++) {
				if (map[i][y] == to) {
					map[i][y] = from;
				}
				if (map[i][y] == 6) {
					break;
				}
			}
			for (int i = y; i < M; i++) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == to) {
					map[x][i] = from;
				}
				if (map[x][i] == 6) {
					break;
				}
			}

		}
	}

	static void cctv5(int dir, int deep, int to , int from) {
		int x = al.get(deep).x;
		int y = al.get(deep).y;

		for (int i = x; i >= 0; i--) {
			if (map[i][y] == to) {
				map[i][y] = from;
			}
			if (map[i][y] == 6) {
				break;
			}
		}
		for (int i = x; i < N; i++) {
			if (map[i][y] == to) {
				map[i][y] = from;
			}
			if (map[i][y] == 6) {
				break;
			}
		}

		for (int i = y; i < M; i++) {
			if (map[x][i] == to) {
				map[x][i] = from;
			}
			if (map[x][i] == 6) {
				break;
			}
		}
		for (int i = y; i >= 0; i--) {
			if (map[x][i] == to) {
				map[x][i] = from;
			}
			if (map[x][i] == 6) {
				break;
			}

		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
