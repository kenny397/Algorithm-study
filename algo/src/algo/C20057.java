package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C20057 {
static int[][]map;
static int ret;
static int N;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int x=N/2;
		int y=N/2;
		while(true) {
			if(x==0&&y==0)break;
			
		}
		
		
	}
	private static void operate(int x, int y) {
		// TODO Auto-generated method stub
		
		
	}
	static void spread(int x,int y) {
		int a=map[x][y];
		if(isMap(x+1,y)) {
			int remain=map[x][y]*7/100;
		}else {
			int remain=map[x][y]*7/100;
			ret+=remain;
		}
		if(isMap(x-1,y)) {
			
		}
		if(isMap(x+1,y)) {
			
		}
		if(isMap(x+1,y)) {
			
		}
		if(isMap(x+1,y)) {
			
		}
		if(isMap(x+1,y)) {
			
		}
		if(isMap(x+1,y)) {
			
		}
	}
	static boolean isMap(int x,int y) {
		if(x<0||y<0||x>=N||y>=N)return false;
		return true;
	}
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println();
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
		}
		
	}

}
