package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C19542 {
static ArrayList<ArrayList<Integer>>adj;
static boolean v[];
static boolean v2[];
static int[] deeps;
static int maxdeep;
static int ret;
static int s;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     StringTokenizer st = new StringTokenizer(br.readLine(), " ");


		int n=Integer.parseInt(st.nextToken());

		s=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		deeps=new int[n+1];
		v=new boolean[n+1];
		v2=new boolean[n+1];
		adj=new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0; i<n-1; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());


			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		v[s]=true;
		dfs(s,0);
		
		for(int i=1; i<=n; i++) {
			if(i!=s&&deeps[i]>=d) {
				ret+=1;
			}
		}
		
		System.out.println(ret*2);
	}
	static int dfs(int current,int pnt) {
		if(adj.get(current).size()==1&&current!=s) {
			return deeps[current]=0;
		}
		for(int a:adj.get(current)) {
				if(a==pnt)continue;
				deeps[current]=Math.max(deeps[current],dfs(a,current)+1);
		}
		
		return deeps[current];
	}
	
}
