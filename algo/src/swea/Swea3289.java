package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea3289 {
static int[] parent;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			parent=new int[n+1];
			for(int i=1; i<n; i++) {
				parent[i]=i;
			}
			StringBuffer sb=new StringBuffer();
			for(int i=0; i<m; i++) {
				st= new StringTokenizer(br.readLine());
				int operate=Integer.parseInt(st.nextToken());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				if(operate==0) {
					union(a,b);
				}
				if(operate==1) {
					if(find(a)==find(b))sb.append(1);
					else sb.append(0);
				}
				
			}
			System.out.println("#"+t+" "+sb.toString());
		}
	}
	static int find(int x) {
		if(x==parent[x])return x;
		return parent[x]=find(parent[x]);
	}
	static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x==y)return;
		if(x<y) {
			parent[y]=x;
		}
		if(x>y) {
			parent[x]=y;
		}
	}

}
