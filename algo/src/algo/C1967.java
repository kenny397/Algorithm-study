package algo;

import java.util.*;

public class C1967 {
static int maxidx;
static int max;
static ArrayList<ArrayList<Node>>al;
static boolean[]v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		v=new boolean[n+1];
		al=new ArrayList<>();
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0; i<n-1; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int w=sc.nextInt();
			al.get(a).add(new Node(b,w));
			al.get(b).add(new Node(a,w));
		}
		max=0;
		dfs(1,0);
		dfs(maxidx,0);
		
		System.out.println(max);
	}
	static void dfs(int start,int ret) {
		if(max<ret) {
			max=ret;
			maxidx=start;
		}
		for(Node i : al.get(start)) {
			if(!v[i.b]) {
				v[start]=true;
				dfs(i.b,ret+i.w);
				v[start]=false;
			}
		}
	}
	static class Node{
		int b;
		int w;
		Node(int b, int w){
			this.b=b;
			this.w=w;
		}
	}

}
