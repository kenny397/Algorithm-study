package swea;

import java.util.Scanner;
import java.util.Stack;

public class Swea0805 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Stack<Character>st =new Stack<>();
			int n=sc.nextInt();
			String input=sc.next();
			int ret=1;
			for(int i=0; i<n; i++) {
				char check= input.charAt(i);
				if(check=='('||check=='['||check=='{'||check=='<') {
					st.add(check);
				}else {
					if(st.peek()=='('&&check==')') {
						st.pop();
					}
					else if(st.peek()=='['&&check==']') {
						st.pop();
					}
					else if(st.peek()=='{'&&check=='}') {
						st.pop();
					}
					else if(st.peek()=='<'&&check=='>') {
						st.pop();
					}else {
						ret=0;
						break;
					}
				}
				
			}
			if(!st.isEmpty())ret=0;
			System.out.println("#"+t+" "+ret);
		}
	}

}
