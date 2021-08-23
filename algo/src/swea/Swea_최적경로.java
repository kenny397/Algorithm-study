package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_최적경로 {
static boolean[]v;
static int N;
static int ret;
static int[][]infos;
static int endx;
static int endy;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st= new StringTokenizer(br.readLine());
			int startx=Integer.parseInt(st.nextToken());
			int starty=Integer.parseInt(st.nextToken());
			endx=Integer.parseInt(st.nextToken());
			endy=Integer.parseInt(st.nextToken());
			infos=new int[N+2][2];
			for(int i=1; i<=N; i++) {
				infos[i][0]=Integer.parseInt(st.nextToken());
				infos[i][1]=Integer.parseInt(st.nextToken());
			}
			infos[0][0]=startx;
			infos[0][1]=starty;
			infos[N+1][0]=endx;
			infos[N+1][1]=endy;
			v=new boolean[N+1];
			ret=Integer.MAX_VALUE;
			np(0,0,0);
			System.out.println("#"+t+" "+ret);
		}
	}
	static void np(int deep,int current,int distance) {
		
		if(ret<distance+Math.abs(infos[current][0]-infos[N+1][0])+Math.abs(infos[current][1]-infos[N+1][1])) {
			return;
		}
		if(deep==N) {
			ret=Math.min(ret, distance+Math.abs(infos[current][0]-infos[N+1][0])+Math.abs(infos[current][1]-infos[N+1][1]));
			
			return;
		}
		for(int i=1; i<=N; i++) {
			if(!v[i]) {
				v[i]=true;
				np(deep+1,i,distance+Math.abs(infos[current][0]-infos[i][0])+Math.abs(infos[current][1]-infos[i][1]));
				v[i]=false;
			}
		}
	}

}
