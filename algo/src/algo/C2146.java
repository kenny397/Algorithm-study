package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C2146 {
static int n;
static int min;
static int[]dx= {1,0,0,-1};
static int[]dy= {0,1,-1,0};
static int[][]map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		min=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int number=2;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					map[i][j]=number;
					dfs(i,j,number);
					number++;
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]>=2) {
					bfs(i,j);
				}
			}
		}
		System.out.println(min);
		
		
		
	}
	static void bfs(int x,int y) {
		boolean[][]v=new boolean[n][n];
		Queue<Node>q=new LinkedList<>();
		int current=map[x][y];
		q.offer(new Node(x,y,0));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Node node=q.poll();
			
			for(int i=0; i<4; i++) {
				int nx=node.x+dx[i];
				int ny=node.y+dy[i];
				if(nx>=n||ny>=n||nx<0||ny<0) {
					continue;
				}
				if(!v[nx][ny]&&map[nx][ny]!=current) {
					v[nx][ny]=true;
					if(map[nx][ny]==0) {
						
						q.add(new Node(nx,ny,node.cnt+1));						
					}else {
						
						min=Math.min(min,node.cnt);
						return;
						
						
					}
				}
			}
		}
	}
	static void dfs(int x,int y,int number) {
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=n||ny>=n||nx<0||ny<0) {
				continue;
			}
			if(map[nx][ny]==1) {
				map[nx][ny]=number;
				dfs(nx,ny,number);
			}
		}
	}
	static class Node{
		int x;
		int y;
		int cnt;
		Node(int x, int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}

}
