package algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class C17298 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Stack<Integer> st=new Stack<>();
		
		int[]result=new int[n];
		for(int i=0; i<n; i++) {
			
			result[i]=sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			while(!st.isEmpty()&&result[st.peek()]<result[i]) {
					result[st.pop()]=result[i];
				}
			st.add(i);
		}
		while(!st.isEmpty()) {
			result[st.pop()]=-1;
		}
	
				
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(result[i]).append(" ");
		}
        System.out.println(sb.toString());
	}

}
