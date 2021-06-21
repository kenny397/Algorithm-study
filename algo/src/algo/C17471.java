package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C17471 {
	static int map[][];
	static ArrayList<Integer> set;
	static int people[];
	static int n;
	static int max;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		people = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			people[i] = sc.nextInt();
		}
		for (int j = 1; j <= n; j++) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int target = sc.nextInt();
				map[j][target] = 1;
				map[target][j] = 1;
			}
		}
		max = Integer.MAX_VALUE;
		for (int i = 1; i < (1 << n); i++) {
			makeSet(i);
		}
		if (max == Integer.MAX_VALUE) {
			max = -1;
		}
		System.out.println(max);
	}

	static void makeSet(int mask) {
		set = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) != 0) {
				set.add(i + 1);
			}
		}
		int a = gal();
		max = Math.min(a, max);

	}

	static int gal() {
		if (!check(set)) {
			return Integer.MAX_VALUE;
		}
		ArrayList<Integer> bset = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (!set.contains(i)) {
				bset.add(i);
			}
		}
		if(bset.size()==0) {
			return Integer.MAX_VALUE;
		}
		if (!check(bset)) {
			return Integer.MAX_VALUE;
		}

		int area1 = 0;
		int area2 = 0;
		for (int i = 1; i <= n; i++) {
			if (set.contains(i)) {
				area1 += people[i];
			}
			if (bset.contains(i)) {
				area2 += people[i];
			}
		}
		return Math.abs(area2 - area1);

	}

	static boolean check(ArrayList<Integer> ad) {
		boolean[] v = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(ad.get(0));
		v[ad.get(0)] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int start = q.poll();
			for (int i = 1; i < ad.size(); i++) {
				if (v[ad.get(i)])
					continue;
				if (map[start][ad.get(i)] == 1) {
					q.add(ad.get(i));
					count++;
					v[ad.get(i)] = true;
				}
			}
		}
		if (count == ad.size()) {
			return true;
		}
		return false;
	}
}
