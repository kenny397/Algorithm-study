package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C17142 {
static int[][] map;
static int[]dx= {1,0,0,-1};
static int[]dy= {0,1,-1,0};
static Virus[]virusV;
static int emptyspace;
static int min;
static int m;
static ArrayList<Virus> viruses=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n][n];
		virusV=new Virus[m];
		min=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0) {
					emptyspace++;
				}
				if(map[i][j]==2) {
					viruses.add(new Virus(i,j,0));
				}
			}
		}
		if(emptyspace==0) {
			System.out.println(0);
		}else {
			select(0,0);
			if(min==Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(min);
			}
		}
		
		
		
		
	}
	static void bfs(int empty) {
		Queue<Virus> q=new LinkedList<>();
		boolean[][] mapV=new boolean[map.length][map.length];
		for(int i=0; i<virusV.length; i++) {
				q.offer(virusV[i]);
		}
		while(!q.isEmpty()) {
			Virus v=q.poll();
			for(int i=0; i<4; i++) {
				int x=v.x+dx[i];
				int y=v.y+dy[i];
				if(x<0||y<0||x>=map.length||y>=map.length)continue;
				if(map[x][y]==1) continue;
				if(mapV[x][y])continue;
				if(map[x][y]==0) {
					empty--;
					
				}
				if(empty==0) {
				min=Math.min(min, v.time+1);
				return;
				}mapV[x][y]=true;
				q.offer(new Virus(x,y,v.time+1));
			}
			
			
		}
	}
	static class Virus{
		int x;int y;int time;
		Virus(int x,int y, int time){
			this.x=x;
			this.y=y;
			this.time=time;
		}
	}static void select(int start,int selectC) {
		if(selectC==m) {
			bfs(emptyspace);
			return;
		}
		for(int i=start; i<viruses.size(); i++) {
			virusV[selectC]=viruses.get(i);
			select(i+1,selectC+1);
		}
	}
}
