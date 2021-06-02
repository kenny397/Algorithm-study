package algo;

import java.util.Scanner;

public class C20040 {
static int[] parent;
static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int m=sc.nextInt();
		parent=new int[n];
		for(int i=0; i<n; i++) {
			parent[i]=i;
		}
		int answer=0;
		for(int i=0; i<m; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
				if(!union(a,b)) {
					answer=i+1;
					break;
				
				
			}
		}
		
		System.out.println(answer);
	}
	
	static int find(int a) {
		if(a==parent[a]) {
			return a;
		}else {
			return parent[a]=find(parent[a]);
		}
	}
	static boolean union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a==b)return false; 
		else{
			if(a<b) {
				parent[b]=a;
			}else {
				parent[a]=b;
			}
		}
		return true;
	}

}
