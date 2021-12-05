package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 1.stack오버플로
 * 2.BufferedReader
 * @author 서형준
 *
 */
public class C17299 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[]A=new int[n];
		int[]answer=new int[n];
		int[]F=new int[1000001];
		StringTokenizer token=new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			A[i]=Integer.parseInt(token.nextToken());
			F[A[i]]++;
		}
		
		Stack<Node>st=new Stack<>();
		st.add(new Node(0,A[0]));
		
		for(int i=1; i<n; i++) {
			while(!st.isEmpty()&&F[st.peek().val]<F[A[i]]) {
				answer[st.pop().idx]=A[i];				
			}
			st.add(new Node(i,A[i]));				
		}
		while(!st.isEmpty()) {
			answer[st.pop().idx]=-1;
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<n; i++) {
			if(i==n-1) sb.append(answer[i]);
			else sb.append(answer[i]+" ");
		}
		
		
		System.out.println(sb.toString());
		
	}
	static class Node{
		int idx;
		int val;
		public Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
	}

}
