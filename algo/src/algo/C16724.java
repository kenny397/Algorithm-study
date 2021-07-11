package algo;

import java.util.HashSet;
import java.util.Scanner;

public class C16724 {
	static boolean[][] v;
	static char[][] map;
	static int parent[];
	static int col;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		col = sc.nextInt();
		int ret=0;
		parent=new int[row*col];
		for(int i=0; i<parent.length; i++) {
			parent[i]=i;
		}
		map = new char[row][col];
		for(int i=0; i<row; i++) {
			String t=sc.next();
			for(int j=0; j<col; j++) {
				map[i][j]=t.charAt(j);
			}
		}
		v = new boolean[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				int idx=i*col+j;
				int nextidx=dfs(i,j);
				if(find(idx)!=find(nextidx)) {
					union(idx,nextidx);
				}
			}
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=0; i<parent.length; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
	}
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		else
			return parent[x]=find(parent[x]);
	}
	static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x>y) {
			parent[x]=y;
		}else {
			parent[y]=x;
		}
		
	}
	static int dfs(int x, int y) {
		int nx=x;
		int ny=y;
		if (map[x][y] == 'D') {
			nx++;
		}
		else if (map[x][y] == 'L') {
			ny--;
		}
		else if (map[x][y] == 'R') {
			ny++;
		}
		else if (map[x][y] == 'U') {
			nx--;
		}
		return nx*col+ny;
	}

}
