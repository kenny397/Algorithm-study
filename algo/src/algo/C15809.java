package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C15809 {
static int[] parent;
static int[] strength;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		parent=new int[n+1];
		strength=new int[n+1];
		for(int i=1; i<=n; i++) {
			parent[i]=i;
			strength[i]=sc.nextInt();
		}
		for(int i=0; i<m; i++) {
			int c=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			option(a,b,c);
		}
		ArrayList<Integer>al=new ArrayList<>();
		boolean[]v=new boolean[n+1]; 
		for(int i=1; i<=n; i++) {
			int t=find(parent[i]);
			if(t==0)continue;
			if(!v[t]) {
				v[t]=true;
				al.add(strength[t]);		
			}
		}Collections.sort(al);
		System.out.println(al.size());
		for(int i=0; i<al.size(); i++) {
			System.out.print(al.get(i));
			if(i!=al.size()-1) {
				System.out.print(" ");
			}
		}
		
	}
	static void option(int a,int b,int c) {
		if(c==1) {
			union(a,b);
		}
		if(c==2) {
			a=find(a);
			b=find(b);
			if(strength[a]==strength[b]) {
				parent[a]=0;
				parent[b]=0;
			}else if(strength[a]>strength[b]){
				strength[a]-=strength[b];
				strength[b]=0;
				union(a,b);
			}else {
				strength[b]-=strength[a];
				strength[a]=0;
				union(a,b);
			}
		}
	}
	static int find(int x) {
		if(parent[x]==x) {
			return x;
		}
		return parent[x]=find(parent[x]);
	}
	static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(parent[a]==0||parent[b]==0)return;
		if(a==b)return;
		if(a<b) {
			parent[b]=a;
			strength[a]+=strength[b];
		}else {
			parent[a]=b;
			strength[b]+=strength[a];
		}
	}

}
