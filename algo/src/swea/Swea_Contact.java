package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_Contact {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			
		StringTokenizer st= new StringTokenizer(br.readLine());
		int l=Integer.parseInt(st.nextToken());
		int start=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>>al=new ArrayList<>();
		boolean[]v=new boolean[101];
		for(int i=0; i<101; i++) {
			al.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<l/2; i++) {
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			al.get(from).add(to);
		}
		int max=-1;
		
		Queue<Node>q=new LinkedList<>();
		q.add(new Node(start,0));
		int maxidx=0;
		v[start]=true;
		while(!q.isEmpty()) {
			Node node=q.poll();
			if(node.cnt==max) {
				maxidx=Math.max(node.to, maxidx);
			}
			if(node.cnt>max) {
				max=node.cnt;
				maxidx=node.to;
			}
			for(int i=0; i<al.get(node.to).size(); i++) {
				if(!v[al.get(node.to).get(i)]) {
					v[al.get(node.to).get(i)]=true;
					q.add(new Node(al.get(node.to).get(i),node.cnt+1));
				}
			}
			
		}
		System.out.println("#"+t+" "+maxidx);
		}
		
	}
	static class Node {
		int to;
		int cnt;
		public Node(int to, int cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
		}
		
	}

}
