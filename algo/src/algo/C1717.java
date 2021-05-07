package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class C1717 {
static int[] parent;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		parent=new int[n+1];
		for(int i=0; i<n+1; i++) {
			parent[i]=i;
		}
		
		for(int i=0; i<m; i++) {
			int exp=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			if(exp==0) {
				if(a!=b)
				union(a,b);
			}
			if(exp==1) {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}
				else System.out.println("NO");
				
			}
			
		}
		

	}
	
	static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a>b) {
			parent[a]=b;
		}else parent[b]=a;
	}
	static int find(int a) {
		if(parent[a]!=a) {
			return parent[a]=find(parent[a]);
		}
		return a;
	}
}


