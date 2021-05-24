package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C13460 {
static int n;
static int m;
static int[]dx= {0,-1,0,1};
static int[]dy= {-1,0,1,0};
static Character map[][];
static int bx;
static int by;
static int rx;
static int ry;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new Character[n][m];
		for(int i=0; i<n; i++) {
			String s=sc.next();
			for(int j=0; j<m; j++) {
				map[i][j]=s.charAt(j);
				if(s.charAt(j)=='B') {
					bx=i;
					by=j;
					map[i][j]='.';
				}
				if(s.charAt(j)=='R') {
					rx=i;
					ry=j;
					map[i][j]='.';
				}
			}
		}
		bfs();
		
		
	}
	static void bfs() {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {bx,by,rx,ry,0,0});
		while(true) {
			int[] t=q.poll();
			if(t[4]>=10) {
				System.out.println(-1);
				return;
			}
			if(t[5]!=1) {
				bx=t[0];by=t[1];rx=t[2];ry=t[3];
				while(true) {
					if(map[bx-1][by]=='O') {
						bx--;
						break;
					}else if(map[bx-1][by]=='#') {
						break;
					}
					bx--;
				}
				while(true) {
					if(map[rx-1][ry]=='O') {
						rx--;
						break;
					}else if(map[rx-1][ry]=='#') {
						break;
					}
					rx--;
				}
				if(map[bx][by]!='O') {
					if(map[rx][ry]=='O') {
						System.out.println(t[4]+1);
						return;
					}else {
						if(rx==bx&&ry==by) {
							if(t[2]>t[0])rx++;
							else bx++;
						}
						q.add(new int[] {bx,by,rx,ry,t[4]+1,1});
					}
				}
			}
			if(t[5]!=2) {
				bx=t[0];by=t[1];rx=t[2];ry=t[3];
				while(true) {
					if(map[bx+1][by]=='O') {
						bx++;
						break;
					}else if(map[bx+1][by]=='#') {
						break;
					}
					bx++;
				}
				while(true) {
					if(map[rx+1][ry]=='O') {
						rx++;
						break;
					}else if(map[rx+1][ry]=='#') {
						break;
					}
					rx++;
				}
				if(map[bx][by]!='O') {
					if(map[rx][ry]=='O') {
						System.out.println(t[4]+1);
						return;
					}else {
						if(rx==bx&&ry==by) {
							if(t[2]<t[0])rx--;
							else bx--;
						}
						q.add(new int[] {bx,by,rx,ry,t[4]+1,2});
					}
				}
			}if(t[5]!=3) {
				bx=t[0];by=t[1];rx=t[2];ry=t[3];
				while(true) {
					if(map[bx][by-1]=='O') {
						by--;
						break;
					}else if(map[bx][by-1]=='#') {
						break;
					}
					by--;
				}
				while(true) {
					if(map[rx][ry-1]=='O') {
						ry--;
						break;
					}else if(map[rx][ry-1]=='#') {
						break;
					}
					ry--;
				}
				if(map[bx][by]!='O') {
					if(map[rx][ry]=='O') {
						System.out.println(t[4]+1);
						return;
					}else {
						if(rx==bx&&ry==by) {
							if(t[3]>t[1])ry++;
							else by++;
						}
						q.add(new int[] {bx,by,rx,ry,t[4]+1,3});
					}
				}
			}if(t[5]!=4) {
				bx=t[0];by=t[1];rx=t[2];ry=t[3];
				while(true) {
					if(map[bx][by+1]=='O') {
						by++;
						break;
					}else if(map[bx][by+1]=='#') {
						break;
					}
					by++;
				}
				while(true) {
					if(map[rx][ry+1]=='O') {
						ry++;
						break;
					}else if(map[rx][ry+1]=='#') {
						break;
					}
					ry++;
				}
				if(map[bx][by]!='O') {
					if(map[rx][ry]=='O') {
						System.out.println(t[4]+1);
						return;
					}else {
						if(rx==bx&&ry==by) {
							if(t[3]<t[1])ry--;
							else by--;
						}
						q.add(new int[] {bx,by,rx,ry,t[4]+1,4});
					}
				}
			}
			
		}
		
	}

}
