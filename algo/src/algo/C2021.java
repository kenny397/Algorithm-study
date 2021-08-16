package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C2021 {
static ArrayList<ArrayList<Integer>>al;
static ArrayList<ArrayList<Integer>>nal;
static int n;
static int l;
static int max;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		al= new ArrayList<>();
		nal=new ArrayList<>();
		for(int i=0; i<l; i++) {
			al.add(new ArrayList<Integer>());
		}
		for(int i=0; i<n; i++) {
			nal.add(new ArrayList<Integer>());
		}
		for(int i=0; i<l; i++) {
			st=new StringTokenizer(br.readLine());			
			while(true) {

				int checkend=Integer.parseInt(st.nextToken());
				if(checkend==-1)break;
				al.get(i).add(checkend-1);
				nal.get(checkend-1).add(i);
			}
		}
		st=new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
//		for(ArrayList<Integer> i : nal) {
//			for(int t : i) {
//				System.out.print(t);
//			}
//			System.out.println();
//		}
		max=Integer.MAX_VALUE;
		bfs(start-1, end-1);
		if(max==Integer.MAX_VALUE)max=-1;
		System.out.println(max);
		//1호선list
		//숫자 하나당연결되어있는 호선? list
		
		
	}
	
	
	static void bfs(int start, int end) {
		Queue<Node> q=new LinkedList<>();
		boolean[]v=new boolean[l];
		for(int i=0; i<nal.get(start).size(); i++) {
			q.add(new Node(start,0,nal.get(start).get(i)));
		}
		while(!q.isEmpty()) {
			Node node =q.poll();
		//	System.out.println(node.des+" "+node.no);
			
			for(int i=0; i<nal.get(node.des).size(); i++) {
				int line=nal.get(node.des).get(i);
	//			System.out.println(line);
				if(!v[line]) {
					v[line]=true;
					if(al.get(line).contains(end)) {
						max=Math.min(max,node.no);
						return;
					}for(int j=0; j<al.get(line).size(); j++) {				
							q.add(new Node(al.get(line).get(j),node.no+1,line));
					}
				}
					
					
			}
			
		}
		
		return;
	}
	
	static class Node{
		int des,no,line;

		public Node(int des, int no,int line) {
			super();
			this.des = des;
			this.no = no;
			this.line= line;
		}
		
	}
}
