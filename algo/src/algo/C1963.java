package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class C1963 {
static boolean[] prime;
static ArrayList<Integer>al;
static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int i=0; i<test; i++) {
			
			int input=sc.nextInt();
			int target=sc.nextInt();
			al=new ArrayList<>();
			result=0;
			makePrime();
			bfs(input,target);
			if(result==-1) {
				System.out.println("Impossible");
			}else {
				System.out.println(result);
				
			}
		}
		
	}
	static void makePrime() {
		prime=new boolean[10001];
		
		for(int i=2; i<=Math.sqrt(10000); i++) {
			if(prime[i])continue;
			for(int j=i*i; j<10000; j+=i) {
				prime[j]=true;
			}
		}
		for(int i=1000; i<10000; i++) {
			if(!prime[i])al.add(i);
		}
	}
	static void bfs(int current,int target ) {
		if(current==target) {
			return;
		}
		boolean[]v=new boolean[al.size()];
		int idx=al.indexOf(current);
		Queue<Node>q=new LinkedList<>();
		v[idx]=true;
		q.offer(new Node(current,0));
		while(!q.isEmpty()) {
			Node node=q.poll();
			if(node.current==target) {
				result=node.cnt;
				return;
			}
			for(int i=0; i<al.size(); i++) {
				int t=al.get(i);
				if(v[al.indexOf(t)]) {
					continue;
				}if(check(node.current,t)) {
					
					v[al.indexOf(t)]=true;
					q.offer(new Node(t,node.cnt+1));
				}
				
			}
		}
		result=-1;
		return;
	}
	static boolean check(int current, int change) {
		String cur=String.valueOf(current);
		String cha=String.valueOf(change);
		int cnt=0;
		for(int i=0; i<4; i++) {
			if(cur.charAt(i)==cha.charAt(i)) {
				cnt++;
			}
		}
		if(cnt==3) {
			return true;
		}
		return false;
	}
	static class Node{
		int current;
		int cnt;
		Node(int current, int cnt){
			this.current=current;
			this.cnt=cnt;
		}
	}

}
