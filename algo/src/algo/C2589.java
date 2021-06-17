package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C2589 {
static int row;
static int col;
static int result=0;
static char[][]map;
static int[]dx= {1,0,0,-1};
static int[]dy= {0,1,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		row=sc.nextInt();
		col=sc.nextInt();
		map=new char[row][col];
		for(int i=0; i<row; i++) {
			String t=sc.next();
			map[i]=t.toCharArray();
		}
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		System.out.println(result);
		
		
	}
	static void bfs(int x,int y) {
		boolean[][]v=new boolean[row][col];
		Queue<Node>q=new LinkedList<>();
		q.offer(new Node(x,y,0));
		v[x][y]=true;
		while(!q.isEmpty()) {
			Node current=q.poll();
			for(int i=0; i<4; i++) {
				int nx=current.x+dx[i];
				int ny=current.y+dy[i];
				if(nx<0||ny<0||nx>=row||ny>=col)continue;
				if(!v[nx][ny]&&map[nx][ny]=='L') {
					v[nx][ny]=true;
					q.offer(new Node(nx,ny,current.count+1));
					result=Math.max(result,current.count+1);
				}
			}
		}
		
	}
	static class Node{
		int x;
		int y;
		int count;
		Node(int x, int y,int count){
			this.x=x;
			this.y=y;
			this.count=count;
		}
	}
}
