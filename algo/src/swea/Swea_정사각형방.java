package swea;

import java.util.Scanner;

public class Swea_정사각형방 {
	static int[][]map;
	static boolean[][]v;
	static int max;
	static int n;
	static int[]dx= {0,0,1,-1};
	static int[]dy= {1,-1,0,0};
	static int ret;
	static int[][] answer;
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner sc=new Scanner(System.in);
	        int T=sc.nextInt();
	        for(int t=1;t<=T; t++) {
	            n=sc.nextInt();
	            max=0;
	            ret=Integer.MAX_VALUE;
	            map=new int[n][n];
	            v=new boolean[n][n];
	            answer=new int[n][n];
	            for(int  i=0; i<n; i++) {
	                for(int j=0; j<n; j++) {
	                    map[i][j]=sc.nextInt();
	                }
	            }
	            for(int i=0; i<n; i++) {
	                for(int j=0; j<n; j++) {
	                    v[i][j]=true;
	                    answer[i][j]=dfs(i,j,1,map[i][j]);
	                    max=Math.max(answer[i][j], max);
	                    v[i][j]=false;
	                }
	            }
	            for(int i=0; i<n; i++) {
	                for(int j=0; j<n; j++) {
	                    if(max==answer[i][j]) {
	                        ret=Math.min(ret, map[i][j]);
	                    }
	                }
	            }
	            System.out.println("#"+t+" "+ret+" "+ (max+1));
	        }
	    }
	    static int dfs(int x,int y,int deep,int start) {
	        int ret2=0;
	         
	        for(int i=0; i<4; i++) {
	            int nx=x+dx[i];
	            int ny=y+dy[i];
	            if(nx<0||ny<0||nx>=n||ny>=n)continue;
	            if(Math.abs(map[x][y]-map[nx][ny])==1&&!v[nx][ny]) {
	                v[nx][ny]=true;
	                ret2=dfs(nx,ny,deep+1,start)+1;
	                v[nx][ny]=false;
	            }
	        }
	        return ret2;
	         
	             
	         
	    }
	 
	}
