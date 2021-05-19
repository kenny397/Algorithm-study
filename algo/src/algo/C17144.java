package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C17144 {
static int r;
static int []dx= {1,0,0,-1};
static int[] dy= {0,-1,1,0};
static int c;
static Queue<dust>q=new LinkedList<>();
static int[][]map;
static int zx;
static int zy;
static int zxx;
static int zyy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		map=new int[r][c];
		int t=sc.nextInt();
		boolean flag=false;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==-1) {
					if(flag) {
						zxx=i;
					
					}else {
						zx=i;						
						
						flag=true;
					}
				}
			}
		}
		for(int i=0; i<t; i++) {
			addq();
			divide();
			clean();			
		}
		int ret=countDust();
		System.out.print(ret);
			
		
		
	}
	static void divide() {
		while(!q.isEmpty()) {
			dust d=q.poll();
			int cnt=d.cnt;
			int div=cnt/5;
			int x=d.x;
			int y=d.y;
			for(int i=0; i<4; i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				if(cx<0||cy<0||cx>=r||cy>=c||map[cx][cy]==-1)continue;
				map[cx][cy]+=div;
				cnt-=div;
			}
			map[x][y]+=cnt;
		}
	}
	
	static void addq() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]>=5) {q.add(new dust(map[i][j],i,j));
				map[i][j]=0;
				}
			}
		}
	}
	static void clean() {
		
		
		for(int i=zx-1; i>0; i--) {
			map[i][0]=map[i-1][0];
		}
		for(int i=0; i<c-1; i++) {
			map[0][i]=map[0][i+1];
		}
		for(int i=0; i<zx;i++) {
			map[i][c-1]=map[i+1][c-1];
		}
		for(int i=c-1;i>1; i--) {
			map[zx][i]=map[zx][i-1];
		}
		
		map[zx][1]=0;
		for(int i=zxx+1; i<r-1; i++) {
			map[i][0]=map[i+1][0];
		}
		for(int i=0; i<c-1; i++) {
			map[r-1][i]=map[r-1][i+1];
		}
		for(int i=r-1; i>zxx;i--) {
			map[i][c-1]=map[i-1][c-1];
		}
		for(int i=c-1;i>1; i--) {
			map[zxx][i]=map[zxx][i-1];
		}map[zxx][1]=0;
		
	}
	static int countDust() {
		int ret=0;
		for(int i=0;i<r; i++) {
			for(int j=0; j<c; j++) {
				ret+=map[i][j];
			}
		}
		return ret+2;
	}
}
class dust{
	int cnt;
	int x;
	int y;
	dust(int cnt,int x, int y){
		this.cnt=cnt;
		this.x=x;
		this.y=y;
	}
}
