package algo;

import java.util.Scanner;

public class C16562 {
static int[] money;
static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		long k=sc.nextLong();
		money=new int[n+1];
		parent=new int[n+1];
		for(int i=1; i<=n; i++) {
			money[i]=sc.nextInt();
			parent[i]=i;
		}
		for(int i=0; i<m; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(find(a)!=find(b))
			union(a,b);
		}
		long friendcost=0;
		for(int i=1; i<=n; i++) {
			friendcost+=money[find(parent[i])];
			money[find(parent[i])]=0;
		}
		if(k<friendcost) {
			System.out.println("Oh no");
		}else {
			System.out.println(friendcost);			
		}
	}
	static int find(int a) {
		if(a==parent[a]) {
			return a;
		}else {
			return parent[a]=find(parent[a]);
		}
	}
	static void union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a!=b) {
			if(money[a]>money[b]) {
				parent[a]=b;
			}else if(money[a]==money[b]) {
				if(a<b) {
					parent[b]=a;
				}else {
					parent[a]=b;
				}
			}else {
				parent[b]=a;
			}
		}
	}

}
