package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class C15685 {
	static ArrayList<Integer> al;
	static int[] dx= {0,-1,0,1};
	static int[] dy= {1,0,-1,0};
static boolean[][]map=new boolean[101][101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			int d=sc.nextInt();
			int g=sc.nextInt();
			al=new ArrayList<>();
			al.add(d);
			makeD(g);
			draw(y,x);
		}
		System.out.println(count());
	}
	static void draw(int y, int x) {
		int size=al.size();
		int nx=x; int ny=y;
		map[x][y]=true;
		for(int i=0; i<size; i++) {
			int d=al.get(i);
			nx+=dx[d]; ny+=dy[d];
			map[nx][ny]=true;
		}
	}
	static void makeD(int g) {
		for(int i=0; i<g; i++) {
			int size=al.size();
			for(int j=1; j<=size; j++) {
				al.add((al.get(size-j)+1)%4);
			}
		}
	}
	static int count() {
		int ret=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
			if(map[i][j]&&map[i][j+1]&&map[i+1][j+1]&&map[i+1][j]) {
				ret++;
			}
			}
		}
		return ret;
	}

}
