package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C3197 {
static char[][]map;
static int[]dx= {1,0,0,-1};
static int[]dy= {0,1,-1,0};
static int n;
static int m;
static int startx=0;
static int starty=0;
static int endx=0;
static int endy=0;
static boolean[][] V;
static Queue<Node> swanQ=new LinkedList<>();
static Queue<Node> waterQ=new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 n=sc.nextInt();
		 m=sc.nextInt();
		map=new char[n][m];
		V=new boolean[n][m];
		boolean flag=true;
		for(int i=0; i<n; i++) {
			String t=sc.next();
			for(int j=0;j<m; j++) {
				map[i][j]=t.charAt(j);
				if(map[i][j]=='L') {
					if(flag) {
						startx=i;
						starty=j;
						flag=false;
						map[i][j]='.';
					}else {
						endx=i;
						endy=j;
						map[i][j]='.';
					}
				}
				if(map[i][j]=='.') {
					waterQ.add(new Node(i,j));
				}
			}
		}
		swanQ.add(new Node(startx,starty));
		V[startx][starty]=true;
		int answer=0;
		while(true) {
			if(bfs()) {
				break;
			}
			melt();
			answer++;
		}
		System.out.println(answer);
		
		
	}
	static void melt() {
		int size=waterQ.size();
		for(int i=0; i<size; i++) {
			Node node=waterQ.poll();
			for(int j=0; j<4; j++) {
				int x=node.x+dx[j];
				int y=node.y+dy[j];
				if(x<0||y<0||x>=n||y>=m) continue;
				if(map[x][y]=='X') {
					map[x][y]='.';
					waterQ.add(new Node(x,y));
				}
			}
		}
		
		
	}
	static boolean bfs() {
		Queue<Node> q=new LinkedList<>();
		while(!swanQ.isEmpty()) {
			Node node= swanQ.poll();
			if(node.x==endx&&node.y==endy)return true;
			for(int i=0; i<4; i++) {
				int x=node.x+dx[i];
				int y=node.y+dy[i];
				if(x<0||y<0||x>=n||y>=m) continue;		
				if(V[x][y])continue;
				V[x][y]=true;
				if(map[x][y]=='.') {
					swanQ.offer(new Node(x,y));
				}
				if(map[x][y]=='X') {
					q.add(new Node(x,y));
				}
			}
		
		}
		swanQ=q;
		return false;
	}
	static class Node{
		int x;
		int y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

}
