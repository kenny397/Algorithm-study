package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C1939 {
static int end2;
static int start;
static int n;
static int max;
	static ArrayList<ArrayList<Node>>al=new ArrayList<>(); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int m=sc.nextInt();
		for(int i=0; i<n; i++) {
			al.add(new ArrayList<Node>());
		}
		for(int i=0; i<m; i++) {
			int s=sc.nextInt()-1;
			int e=sc.nextInt()-1;
			int w=sc.nextInt();
			al.get(s).add(new Node(e,w));
			al.get(e).add(new Node(s,w));
		}
		max=0;
		start=sc.nextInt()-1;
		end2=sc.nextInt()-1;
		int left=1;
		int right=1000000000;
		while(left<=right) {
			int mid=(left+right)/2;
			if(bfs(mid)) {
				max=Math.max(mid, max);
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		
		System.out.println(max);
		
	}
	static class Node{
		int end;
		int weight;
		Node(int end, int weight){
			this.end=end;
			this.weight=weight;
		}
	}
	static boolean bfs(int we) {
		Queue<Node>q=new LinkedList<>();
		boolean[]V=new boolean[n];
		q.offer(new Node(start,0));
		V[start]=true;
		while(!q.isEmpty()) {
			Node node=q.poll();
			if(node.end==end2)return true;
			for(int i=0; i<al.get(node.end).size(); i++) {
				int z=al.get(node.end).get(i).end;
				
				if(!V[z]&&al.get(node.end).get(i).weight>=we) {
					V[z]=true;
					q.add(al.get(node.end).get(i));
				}
			}
		}
		return false;
		
	}
}
