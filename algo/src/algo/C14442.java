package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C14442 {
static int[] dx= {1,0,0,-1};
static int[] dy= {0,1,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		
		int [][] map=new int[n][m];
		for(int i=0; i<n; i++) {
			String t=sc.next();
			for(int j=0; j<m; j++) {
				
				map[i][j]=(int)t.charAt(j)-'0';
			}
		}
		
		boolean[][][] v=new boolean[n][m][k+1];
		Queue<Node>q=new LinkedList<>();
		q.add(new Node(0,0,0,1));
		v[0][0][0]=true;
		int ret=-1;
		while(!q.isEmpty()) {
			Node node=q.poll();
			if(node.x==n-1&&node.y==m-1) {
				ret=node.cnt;
				break;
			}
			for(int i=0; i<4; i++) {
				int cx=node.x+dx[i];
				int cy=node.y+dy[i];
				if(cx<0||cy<0||cx>=n||cy>=m)continue;
				if(!v[cx][cy][node.broke]) {
					v[cx][cy][node.broke]=true;
					if(map[cx][cy]==0) {
						q.add(new Node(cx,cy,node.broke,node.cnt+1));
					}else {
						if(node.broke<k) {
							q.add(new Node(cx,cy,node.broke+1,node.cnt+1));							
						}
						
					}
				}
			}
			
		}
		System.out.println(ret);
	}
	
	static class Node{
		int x;
		int y;
		int broke;
		int cnt;
		public Node(int x, int y, int broke,int cnt) {
			this.x = x;
			this.y = y;
			this.broke = broke;
			this.cnt = cnt;
		}
	}
}
