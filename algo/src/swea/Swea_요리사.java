package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea_요리사 {
static boolean[]v;
static int[][]foods;
static int ret;
static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int T=1; T<=t; T++) {
			 ret=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			foods=new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					foods[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			v=new boolean[N];
			combi(0,0);
			System.out.println("#"+T+" "+ret );
			
			
		}
	}
	//n=4 rec(0,0); 0 combi(1,1);01 02 03 12 13 
	static void combi(int deep,int start) {
		if(deep==N/2) {
		
			make();
			return;
		}
		for(int i=start; i<N; i++) {
			if(!v[i]) {
				v[i]=true;
				combi(deep+1,i+1);
				v[i]=false;
			}
		}
		
	}
	
	//n=4 rec(0); 01 02 03 10 12 13 
	static void rec(int deep) { 
		if(deep==N/2) {
		
			make();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				v[i]=true;
				rec(deep+1);
				v[i]=false;
			}
		}
		
	}
	static void make() {
		ArrayList<Integer>A=new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(v[i])A.add(i);
		}
		ArrayList<Integer>B=new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(!v[i])B.add(i);
		}
		
		int sumA=0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				sumA+=foods[A.get(i)][A.get(j)];
			}
		}
		int sumB=0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				sumB+=foods[B.get(i)][B.get(j)];
			}
		}
		ret=Math.min(ret, Math.abs(sumA-sumB));
		
	}
	

}
