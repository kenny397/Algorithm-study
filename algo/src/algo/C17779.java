package algo;

import java.util.Scanner;

public class C17779 {
static int[][] map;
static int n;
static int[][] divmap;

static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				map[i][j]=sc.nextInt();
			}
		}result=Integer.MAX_VALUE;
		
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=n; y++) {
				for(int d1=1; d1<n; d1++) {
					for(int d2=1; d2<n; d2++) {
						if(x+d1+d2>n)continue;
						if(y-d1<1||y+d2>n)continue;
						div(x,y,d1,d2);
					}
				}
			}
		}
		
		System.out.println(result);
		
	}
	static void div(int x, int y,int d1,int d2) {
		divmap=new int[n+1][n+1];
		for(int i=0; i<=d1; i++) {
			divmap[x+i][y-i]=5;
		}
		for(int i=0; i<=d2; i++) {
			divmap[x+i][y+i]=5;
		}
		for(int i=0; i<=d2; i++) {
			divmap[x+d1+i][y-d1+i]=5;
		}
		for(int i=0; i<=d1; i++) {
			divmap[x+d2+i][y+d2-i]=5;
		}
		for(int i=1; i<x+d1; i++) {
			for(int j=1; j<=y; j++) {
				if(divmap[i][j]==5)break;
				divmap[i][j]=1;
			}
		}
		for(int i=1; i<=x+d2; i++) {
			for(int j=n; j>y; j--) {
				if(divmap[i][j]==5)break;
				divmap[i][j]=2;
			}
		}
		for(int i=x+d1; i<=n; i++) {
			for(int j=1; j<y-d1+d2; j++) {
				if(divmap[i][j]==5)break;
				divmap[i][j]=3;
			}
		}
		for(int i=x+d2+1; i<=n; i++) {
			for(int j=n; j>=y-d1+d2; j--) {
				if(divmap[i][j]==5)break;
				divmap[i][j]=4;
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(divmap[i][j]==0)divmap[i][j]=5;
			}
		}
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				System.out.print(divmap[i][j]);
//			}
//			System.out.println();
//		}
		count();
	}
	
	
	
	
	
	static void	count() {
		int one=0;
		int two=0;
		int three=0;
		int four=0;
		int five=0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(divmap[i][j]==1) {
					one+=map[i][j];
				}
				if(divmap[i][j]==2) {
					two+=map[i][j];
				}
				if(divmap[i][j]==3) {
					three+=map[i][j];
				}
				if(divmap[i][j]==4) {
					four+=map[i][j];
				}
				if(divmap[i][j]==5) {
					five+=map[i][j];
				}
			}
		}
		int max=Math.max(one, two);
		int max2=Math.max(four, three);
		max=Math.max(max2, max);
		max=Math.max(max, five);
		int min=Math.min(one, two);
		int min2=Math.min(four, three);
		min=Math.min(min2, min);
		min=Math.min(min, five);
		result=Math.min(result, max-min);
	}

}
