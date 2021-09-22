package swea;

import java.util.Scanner;
import java.util.Stack;

public class Swea_1223 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		String test="3+4+5*6+7";
		System.out.println(toPostfix(test));
		System.out.println(postfixCalculator(toPostfix(test)));
		Scanner sc=new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int length=sc.nextInt();
			String input=sc.next();
			int answer=postfixCalculator(toPostfix(input));
			System.out.println("#"+t+" "+answer);
		}
	}
	
	
	static String toPostfix(String input) {
		StringBuffer sb=new StringBuffer();
		
		Stack<Character> st=new Stack<>();
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)<='9'&&input.charAt(i)>='0') 
				sb.append(input.charAt(i));
			else {
				if(input.charAt(i)=='*') {
					while(!st.isEmpty()&&st.peek()=='*') {
						sb.append(st.pop());
					}
					st.add(input.charAt(i));
				}else if(input.charAt(i)=='+') {
					while(!st.isEmpty()&&(st.peek()=='*'||st.peek()=='+')) {
						sb.append(st.pop());
					}
					st.add(input.charAt(i));
					
				}
			}
			
		}
		while(!st.isEmpty()){
			sb.append(st.pop());
		}
		return sb.toString();
	}
	static int postfixCalculator(String postfix) {
		Stack<Integer> st= new Stack<>();
		for(int i=0; i<postfix.length(); i++) {
			if(postfix.charAt(i)<='9'&&postfix.charAt(i)>='0') {
				st.add(postfix.charAt(i)-'0');
			}else {
				if(postfix.charAt(i)=='+') {
					st.add(st.pop()+st.pop());
				}
				if(postfix.charAt(i)=='*') {
					st.add(st.pop()*st.pop());
				}
			}
		}
		return st.pop();
	}

}
