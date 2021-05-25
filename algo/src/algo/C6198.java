package algo;

import java.util.Scanner;
import java.util.Stack;

public class C6198 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ret=0;
		Stack<Long>st=new Stack<>();
		
		for(int i=0;i<n; i++) {
			long t=sc.nextLong();
			while(!st.isEmpty()&&st.peek()<=t) {
				st.pop();
				
				
			}
			ret+=st.size();
			st.add(t);
		}
		
		System.out.println(ret);
	}
	
}
class build{
	int num;
	long h;
	build(int num, long h){
		this.num=num;
		this.h=h;
	}
}

