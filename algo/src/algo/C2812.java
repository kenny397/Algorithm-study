package algo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class C2812 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		String t=sc.next();
		char[]arr=t.toCharArray();
		Deque<Character>st=new ArrayDeque<>();
		
		
		for(int i=0; i<n;i++) {
			
			while(k>0&&!st.isEmpty()&&st.getLast()<arr[i]) {
				
				st.removeLast();
				k--;
				
				
			} 
			
			st.addLast(arr[i]);
			
		}StringBuilder ans = new StringBuilder();
		
		while(st.size()>k) {
			ans.append(st.removeFirst());
		}
		
		System.out.println(ans.toString());
	}

}