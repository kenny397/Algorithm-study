package algo;

import java.util.Scanner;

public class C2234 {
 
static boolean[][] v;
static int[]dx= {0,-1,0,1};
static int[]dy= {-1,0,1,0};
static int m;
static int n;
static int max;
static int map[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		v=new boolean[m][n];
		map=new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				int k=sc.nextInt();
			//	String door=Integer.toBinaryString(k);
			//	int doors=Integer.parseInt(door);
				map[i][j]=k;
			}
		}
		int sum=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!v[i][j]) {
					sum++;
					v[i][j]=true;
					
					max=Math.max(max, dfs(i,j));
				}
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				reset();
				for(int k=0; k<4; k++) {
					if((map[i][j]&(1<<k))==1<<k) {
						v[i][j]=true;
						map[i][j]=map[i][j]-(1<<k);
						max=Math.max(max, dfs(i,j));
						map[i][j]=map[i][j]+(1<<k);
					}
				}
			}
		}System.out.println(max);
		
		
		
	}
	static int dfs(int x,int y) {
		int ret=1;
		for(int i=0; i<4; i++) {
			if((1<<i&map[x][y])!=1<<i) {
				
				int cx=x+dx[i];
				int cy=y+dy[i];
				if(cx<0||cy<0||cx>=m||cy>=n)continue;
				if(!v[cx][cy]) {
					v[cx][cy]=true;
					ret+=dfs(cx,cy);
					
				}
			}
		}
		return ret;
		
		
	}
	static void reset() {
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				v[i][j] = false;
			}
		}
	}

}
