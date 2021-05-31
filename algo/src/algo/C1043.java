package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C1043 {
static int[] parent;
static ArrayList<ArrayList<Integer>>al=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		parent=new int[n+1];
		boolean[] known=new boolean[n+1];
		for(int i=1; i<=n; i++) {
			parent[i]=i;
		}
		for(int i=0; i<k; i++) {
			int t=sc.nextInt();
			known[t]=true;
			
		}
		for(int i=0; i<m; i++) {
			al.add(new ArrayList<>());
			int s=sc.nextInt();
			for(int j=0; j<s; j++) {
				al.get(i).add(sc.nextInt());
			}
		}
		unions();
		int answer=0;
		for(int i=1; i<=n; i++) {
			if(known[i]) {
				known[find(i)]=true;
			}
		}
		for(int i=0; i<al.size(); i++) {
			if(!known[find(al.get(i).get(0))]) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}else {
			return parent[x]=find(parent[x]);
		}
	}
	static void union(int x, int y) {
		int a=find(x);
		int b=find(y);
		if(a!=b) {
			if(a>b) {
				parent[a]=b;
			}else {
				parent[b]=a;
			}
		}
	}
	static void unions() {
		for(int i=0; i<al.size(); i++) {
			for(int j=1; j<al.get(i).size(); j++) {
				union(al.get(i).get(0),al.get(i).get(j));
			}
		}
	}

}
