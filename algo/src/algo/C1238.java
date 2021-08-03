package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C1238 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken())-1;
		int[][]adj=new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(adj[i],1000000);
		}
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			adj[from-1][to-1]=cost;
		}
		for(int i=0; i<n; i++) {
			adj[i][i]=0;
		}
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++ ) {
					adj[i][j]=Math.min(adj[i][j], adj[i][k]+adj[k][j]);
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(adj[i][j]+" ");
//			}
//			System.out.println();
//		}
		int ret=0;
		for(int i=0; i<n; i++) {
			int temp=adj[i][x]+adj[x][i];
			ret=Math.max(ret, temp);
		}
			System.out.println(ret);
	}
	

}
