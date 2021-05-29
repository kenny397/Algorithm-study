package algo;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C1766 {
	static ArrayList<ArrayList<Integer>>al=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int m=sc.nextInt();
		int []indegree=new int[n+1];
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<Integer>());
		}
		for(int i=0; i<m; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			al.get(a).add(b);
			indegree[b]++;
		}
		PriorityQueue<Integer> q=new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int t=q.poll();
			
			for(int i : al.get(t)) {
				indegree[i]--;
				if(indegree[i]==0) {
					q.add(i);
				}
			}
			System.out.print(t+ " ");
		}
		
	}
}
