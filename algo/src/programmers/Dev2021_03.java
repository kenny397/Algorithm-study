package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dev2021_03 {
	static boolean v[][];
	static int map[][];
	static int ret;
	static boolean flag;
	static int[]dx= {0,0,1,-1};
	static int[]dy= {1,-1,0,0};
	static ArrayList<Node>bomb=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][]mac= {{1,1},{1,2},{1,4},{2,1},{2,2},{2,3},{3,4},{3,1},{3,2},
				{3,3},{3,4},{4,4},{4,3},{5,4},{6,1}};
		String[]answer=solution(mac);
		for(String a:answer) {
			System.out.println(a);
		}
	}
	
	static  public String[] solution(int[][] macaron) {
        String[] answer = new String[6];
        map=new int[6][6];
        flag=false;
        for(int i=0; i<macaron.length; i++) {
        	push(macaron[i][0]-1,macaron[i][1]);
        
        	
        	
        	while(flag) {
        		flag=false;
        		remap();
        		isBomb();
        		
        	}
        	print();
        	System.out.println();
        }
        
        for(int i=0; i<6; i++) {
        	String s="";
        	for(int j=0; j<6; j++) {
        		s+=map[i][j];
        	}
        	answer[i]=s;
        	
        }
        
       
        return answer;
    }
	
	
	
	static void isBomb() {
		
		v=new boolean[6][6];
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(map[i][j]!=0&&!v[i][j]) {
					v[i][j]=true;
					ret=1;
					dfs(i,j);
					if(ret>2) {
						flag=true;
						count();
		        	
					}else {
						v=new boolean[6][6];
					}
				
				}
			}
		}
		
	}
	
	static void dfs(int x,int y) {
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=6||ny>=6)continue;
			if(!v[nx][ny]) {
				if(map[nx][ny]==map[x][y])
				{
					v[nx][ny]=true;
					ret++;
					dfs(nx,ny);
				}
			}
			
		}
	}
	
	
	
	
	static void push(int col,int color) {
		
		for(int i=0; i<6; i++) {
			if(map[i][col]!=0) {
				map[i-1][col]=color;
				
				break;
			}
			if(i==5) {
				map[i][col]=color;
				
			}
		}
	
		isBomb();
	}
	static void print() {
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	static void count() {
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				if(v[i][j])
					map[i][j]=0;
			}
		}
	}
	
	static void remap() {
		for(int j=0; j<6; j++) {
			String s="";
			for(int i=0; i<6; i++) {
				s+=map[i][j];
			}
			s=s.replace("0", "");
			while(s.length()<6) {
				s=0+s;
			}
			for(int i=0; i<6; i++) {
				map[i][j]=s.charAt(i)-'0';
			}
			
			
		}
	}
	static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	

}
