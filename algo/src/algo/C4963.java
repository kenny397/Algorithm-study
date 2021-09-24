package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C4963 {
static int[][]map;
static int[]dx= {0,0,1,1,1,-1,-1,-1};
static int[]dy= {1,-1,0,1,-1,0,-1,1};
static boolean[][]v;
static int h;
static int w;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			map=new int[h][w];
			for(int i=0; i<h; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			v=new boolean[h][w];
			int ret=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1&&!v[i][j]) {
						v[i][j]=true;
						dfs(i,j,v);
						ret++;
					}
				}
			}
			System.out.println(ret);
			
			
		}
	}
	static void dfs(int x,int y,boolean [][]v) {
		for(int i=0; i<8; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||ny<0||nx>=h||ny>=w)continue;
			if(map[nx][ny]==1&&!v[nx][ny]) {
				v[nx][ny]=true;
				dfs(nx,ny,v);
			}
			
		}
	}

}
