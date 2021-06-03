package algo;

import java.util.Scanner;
import java.util.Stack;

public class C15926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String a=sc.next();
		int ans=0;
		
		boolean[] check=new boolean[n];
		Stack<Integer>st=new Stack<>();
		for(int i=n-1; i>=0; i--) {
			if(a.charAt(i)==')') {
				st.add(i);
				
			}else {
				if(!st.isEmpty()) {
					int num=st.pop();
					check[num]=true;
					check[i]=true;
				}
				
			}
		}
		int sum=0;
		for(int i=0; i<n; i++) {
			if(check[i]) {
				sum++;
			}else {
				ans = Math.max(ans, sum);
				sum=0;
			}
		}
		if(sum>0)
			ans = Math.max(ans, sum);
	
		System.out.println(ans);
	}

}
