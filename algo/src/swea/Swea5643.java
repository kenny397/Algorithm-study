package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea5643 {
static boolean[] v;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n= Integer.parseInt(br.readLine());
			int m= Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>>winList=new ArrayList<>();
			ArrayList<ArrayList<Integer>>loseList=new ArrayList<>();
			for(int i=0; i<=n; i++) {
				winList.add(new ArrayList<>());
				loseList.add(new ArrayList<>());
			}
			for(int i=0; i<m; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				winList.get(a).add(b);
				loseList.get(b).add(a);
			}
			int cnt=0;
			for(int i=1; i<=n; i++) {
				v=new boolean[n+1];
				v[i]=true;
				dfs(i,winList);
				dfs(i,loseList);
				int temp=0;
				for(int j=1; j<=n; j++) {
					if(v[j])temp++;
				}
				if(temp==n)cnt++;
			}
			System.out.println("#"+t+" "+cnt);
			
			
			
		}
	}
	static void dfs(int start,ArrayList<ArrayList<Integer>> adj) {
		
		for(int i=0; i<adj.get(start).size(); i++) {
			if(!v[adj.get(start).get(i)]) {
				v[adj.get(start).get(i)]=true;
				dfs(adj.get(start).get(i),adj);
			}
		}
		
	}

}
