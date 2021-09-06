package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7465 {
static int[] parent;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			parent= new int[n+1];
			for(int i=1; i<=n; i++) {
				parent[i]=i;
			}
			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				union(a,b);
			}
			boolean[]v=new boolean[n+1];
			for(int i=1; i<=n; i++) {
				v[find(i)]=true;
			}
			int ret=0;
			for(int i=1; i<=n; i++) {
				if(v[i])ret++;
			}
			System.out.println("#"+t+" "+ret);
			
			
			
		}
	}
	static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)return;
		if(x<y) {
			parent[y]=x;
		}else {
			parent[x]=y;
		}
	}

}
