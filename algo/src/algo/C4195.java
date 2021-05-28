package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class C4195 {
static int[] parent;
static int[] level;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		
		
		
		for(int i=0; i<t; i++) {
			int n=sc.nextInt();
			parent=new int[2*n];
			level=new int[2*n];
			HashMap<String,Integer>hm=new HashMap<>();
			for(int k=0; k<2*n; k++) {
				parent[k]=k;
				level[k]=1;
			}int index=0;
			for(int j=0; j<n; j++) {
				String fr=sc.next();
				String fr2=sc.next();
				if(!hm.containsKey(fr)) {
					hm.put(fr,index);
					index++;
				}
				if(!hm.containsKey(fr2)) {
					hm.put(fr2,index);
					index++;
				}
				union(hm.get(fr),hm.get(fr2));
				
			}
		}
	}
	
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}else {
			return parent[x]=find(parent[x]);
		}
	}
	static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x!=y) {
			if(x<y) {
				parent[y]=x;
				level[x]+=level[y];
				level[y]=1;
				System.out.println(level[x]);
			}
			else {
				parent[x]=y;
				level[y]+=level[x];
				level[x]=1;
				System.out.println(level[y]);
			}
		}
		if(x==y)System.out.println(level[x]);
		
		
	}
}
