package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C16197 {
static char [][]map;
static boolean[][]v;
static int n;
static int m;
static int[] dx= {0,0,-1,1};
static int[] dy= {1,-1,0,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new char[n][m];
		for(int i=0; i<n; i++) {
			String t=sc.next();
			map[i]=t.toCharArray();
		}
		int c1x=0;
		int c1y=0;
		int c2x=0;
		int c2y=0;
		boolean flag=false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]=='o') {
					if(flag) {
						c1x=i;
						c1y=j;
					}else {
						c2x=i;
						c2y=j;
						flag=true;
					}
				}
			}
		}
		int ret=Integer.MAX_VALUE;
		boolean flag2=false;
		Queue<Coin>q=new LinkedList<>();
		q.add(new Coin(c1x,c1y,c2x,c2y,0));
		while(!q.isEmpty()) {
			Coin coin=q.poll();
			if(coin.cnt>=ret) break;
			if(coin.cnt==11) {
				
				break;
			}
			for(int i=0; i<4; i++) {
				int x1=coin.c1x+dx[i];
				int y1=coin.c1y+dy[i];
				int x2=coin.c2x+dx[i];
				int y2=coin.c2y+dy[i];
				if(x1<0||x1>=n||y1<0||y1>=m) {
					if(x2<0||x2>=n||y2<0||y2>=m) {
						continue;
					}else {
						ret=coin.cnt+1;
						
						break;
					}
				}
				if(x2<0||x2>=n||y2<0||y2>=m) {
					if(x1<0||x1>=n||y1<0||y1>=m) {
						continue;
					}else {
						ret=coin.cnt+1;
						
						break;
					}
				}
				if(map[x1][y1]=='#') {
					x1=coin.c1x;
					y1=coin.c1y;
				}
				if(map[x2][y2]=='#') {
					x2=coin.c2x;
					y2=coin.c2y;
				}
				q.add(new Coin(x1,y1,x2,y2,coin.cnt+1));
				
			}
			
		}
		if(ret>10)ret=-1;
		System.out.println(ret);
	}
	static class Coin{
		int c1x;
		int c1y;
		int c2x;
		int c2y;
		int cnt;
		Coin(int c1x,int c1y,int c2x,int c2y,int cnt) {
			this.c1x=c1x;
			this.c1y=c1y;
			this.c2x=c2x;
			this.c2y=c2y;
			this.cnt=cnt;
		}
	}

}
