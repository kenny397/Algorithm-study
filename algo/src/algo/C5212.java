package algo;

import java.util.Scanner;

public class C5212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		String[][]map=new String[r][c];
		for(int i=0; i<r; i++) {
			String s=sc.next();
			map[i]=s.split("");
		}
		int[]dx= {1,0,0,-1};
		int[]dy= {0,1,-1,0};
		String[][] answer=new String[r][c];
		for(int i=0; i<r; i++) {
			
			for(int j=0; j<c; j++) {
				int sum=0;
				if(map[i][j].equals("X")) {
					
				
				for(int dir=0; dir<4; dir++) {
					if(i+dx[dir]<0||i+dx[dir]>=r||j+dy[dir]<0||j+dy[dir]>=c) {
						continue;
					}
					if(map[i+dx[dir]][j+dy[dir]].equals("X")) {
						sum++;
					}
				}}
				if(sum>=2) {
					answer[i][j]="X";
				}else {
					answer[i][j]=".";
				}
			}
		} int maxr=10;
		  int minr=0;
		  int maxc=10;
		  int minc=0;
		for(int i=0; i<r; i++) {
			boolean flag=false;
			for(int j=0; j<c; j++) {
				if(answer[i][j].equals("X")) {
					minr=i;
					flag=true;
					break;
				}
			}
			if(flag)break;
		}
		for(int i=r-1; i>=0; i--) {
			boolean flag=false;
			for(int j=0; j<c; j++) {
				if(answer[i][j].equals("X")) {
					maxr=i;flag=true;
					break;
				}
			}if(flag)break;
		}
		for(int i=0; i<c; i++) {
			boolean flag=false;
			for(int j=0; j<r; j++) {
				if(answer[j][i].equals("X")) {
					minc=i;flag=true;
					break;
				}
			}if(flag)break;
		}
		for(int i=c-1; i>=0; i--) {
			boolean flag=false;
			for(int j=0; j<r; j++) {
				if(answer[j][i].equals("X")) {
					maxc=i;flag=true;
					break;
				}
			}if(flag)break;
		}
	
		for(int i=minr; i<=maxr; i++) {
			
			for(int j=minc; j<=maxc; j++) {
				System.out.print(answer[i][j]);
			}System.out.println();
		}
		
		
		
	}

}
