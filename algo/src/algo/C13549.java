package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C13549 {
static int max;
static int k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		k=sc.nextInt();
		boolean []v=new boolean[100001];
		Queue <Node> q=new LinkedList<>();
		q.offer(new Node(n,0));
		v[n]=true;
		max=Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node t=q.poll();
			v[t.current]=true;
			if(t.current==k) {
				max=Math.min(t.count,max);
			}
			
			int plust=t.current+1;
			int minust=t.current-1;
			int doublet=t.current*2;
			
			if(doublet<=100000&&!v[doublet]) {
			
			q.offer(new Node(doublet,t.count));
			}
			if(plust<=100000&&!v[plust]) {
				q.offer(new Node(plust,t.count+1));
			}
			if(minust>=0&&!v[minust]) {
				q.offer(new Node(minust,t.count+1));
			}
		}
		System.out.println(max);
	}
	
	static class Node{
		int current;
		int count;
		Node(int current, int count){
			this.current=current;
			this.count=count;
		}
	}
}
