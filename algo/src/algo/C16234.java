package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class C16234 {
	static int[][]adj;
	static int[][]map;
	static int n;
	static int idx;
	static int c;
	static int sum;
	static boolean fin;
	static boolean v[][];
	static boolean v2[][];
	static int l;
	static ArrayList<int[]>al;
	static int r;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
		public static void main(String[] args)throws NumberFormatException, IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine(); 
	        String[] strArr = str.split(" ");
	        n = Integer.parseInt(strArr[0]);
	        l = Integer.parseInt(strArr[1]);
	        r = Integer.parseInt(strArr[2]);
		
			map=new int[n][n];
			 for(int i=0; i<map.length; i++){
	             String str1 = br.readLine(); 
	             String[] strArr1 = str1.split(" ");
	             for(int j=0; j<map[0].length; j++){
	                 map[i][j] = Integer.parseInt(strArr1[j]);
	             }
	         }
	     int answer=0;
			while(true) {
				 v=new boolean[n][n];				
				
				c=1;
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(!v[i][j]) {
							al=new ArrayList<>();
							v[i][j]=true;
							sum=map[i][j];
							idx=1;
							al.add(new int[] {i,j});
							dfs(i,j);
							c++;
							if(idx>1)changemap();
							
							
						}
					}
				}
				int[] cnt=new int[--c];
				if(cnt.length==n*n) {
					break;
				}
				answer++;
			}
			
			
			System.out.println(answer);
		}
		static boolean check(int x,int y) {
			if(x<0||y<0||x>=n||y>=n) {
				return false;
			}
			return true;
		}
		
		static void dfs (int x, int y) {
			
			for(int i=0; i<4; i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				if(check(cx,cy)) {
					int k=Math.abs(map[x][y]-map[cx][cy]);
					
					if(k>=l &&k<=r) {
						if(!v[cx][cy]) {
							v[cx][cy]=true;
							idx++;
							sum+=map[cx][cy];
							dfs(cx,cy);
							al.add(new int[] {cx,cy});
						}
					}
				}
			}
			
		}
		static void changemap() {
			for(int i=0; i<al.size(); i++) {
				map[al.get(i)[0]][al.get(i)[1]]=sum/idx;
			}
			}
	}
