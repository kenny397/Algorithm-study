package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C3055 {
static int r;
static int[] dx= {1,0,0,-1};
static int[] dy= {0,1,-1,0};
static int c;
static char[][]map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		int sx=0;
		int sy=0;
		ArrayList<Node>al=new ArrayList<>();
		map=new char[r][c];
		boolean[][]v=new boolean[r][c];
		for(int i=0; i<r; i++) {
			String t=sc.next();
			for(int j=0; j<c; j++) {
				map[i][j]=t.charAt(j);
				if(map[i][j]=='*') {
					al.add(new Node(i,j,0));
					
				}
				if(map[i][j]=='S') {
					sx=i;
					sy=j;
				}
			}
		}
//		for(char[]a:map) {
//			for(char z: a) {
//				System.out.print(z);
//			}
//			System.out.println();
//		}
		Queue<Node>q=new LinkedList<>();
		for(Node t: al) {
			q.offer(new Node(t.x,t.y,Integer.MAX_VALUE));
			v[t.x][t.y]=true;
		}
		q.offer(new Node(sx,sy,0));
		v[sx][sy]=true;
		int ret=0;
		boolean flag=false;
		while(!q.isEmpty()) {
			Node node=q.poll();
			for(int i=0; i<4; i++) {
				int x=node.x+dx[i];
				int y=node.y+dy[i];
				if(x>=r||y>=c||x<0||y<0) {
					continue;
				}
				if(map[x][y]=='D') {
					if(node.cnt==Integer.MAX_VALUE) {
						continue;
					}
					ret=node.cnt+1;
					flag=true;
					break;
				}
				if(map[x][y]=='.') {
					if(v[x][y])continue;
					v[x][y]=true;
					if(node.cnt==Integer.MAX_VALUE) {
						q.offer(new Node(x,y,Integer.MAX_VALUE));
					}else {
						q.offer(new Node(x,y,node.cnt+1));
					}
					
				}
			}
			if(flag)break;
		}
		if(!flag) {
			System.out.println("KAKTUS");
			
		}else {
			
			System.out.println(ret);
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
