package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_사람네트워크2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int ret=Integer.MAX_VALUE;
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int[][] map=new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==0)map[i][j]=1001;
					if(i==j)map[i][j]=0;
				}
			}
			
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						map[i][j]=Math.min(map[i][k]+map[k][j], map[i][j]);
					}
				}
			}
			int[] cc=new int[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					cc[i]+=map[i][j];
				}
				ret=Math.min(cc[i], ret);
			}
			
			
			
			
			
			
			System.out.println("#"+t+" "+ret);
		}
	}

}
