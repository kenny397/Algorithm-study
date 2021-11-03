package algo;


import java.util.Scanner;
import java.util.Stack;

public class C1918 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> st1 = new Stack<>();
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < s.length(); i++) {
			char temp=s.charAt(i);
			if(temp>='1'&&temp<='9') {
				sb.append(temp);
			}
			else if(temp=='*'||temp=='/') {
				while(!st1.empty()&&(st1.peek()=='*'||st1.peek()=='/')) {
					sb.append(st1.pop());
				}
				st1.push(temp);
			}else if(temp=='+'||temp=='-') {
				while(!st1.empty()&&(st1.peek()=='*'||st1.peek()=='/'||st1.peek()=='+'||st1.peek()=='-')) {
					sb.append(st1.pop());
				}
				st1.push(temp);
			}
			else if(temp=='(') {
				st1.push(temp);
			}else if(temp==')') {
				while(st1.peek()!='(') {
					sb.append(st1.pop());
				}
				st1.pop();
			}
			

		}
		while(!st1.empty()) {
			sb.append(st1.pop());
		}
		System.out.println(sb.toString());
	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Stack<Character> st1 = new Stack<>();
//		
//		StringBuffer sb = new StringBuffer();
//		
//		for (int i = 0; i < s.length(); i++) {
//			char temp=s.charAt(i);
//			if(temp>='A'&&temp<='Z') {
//				sb.append(temp);
//			}
//			else if(temp=='*'||temp=='/') {
//				while(!st1.empty()&&(st1.peek()=='*'||st1.peek()=='/')) {
//					sb.append(st1.pop());
//				}
//				st1.push(temp);
//			}else if(temp=='+'||temp=='-') {
//				while(!st1.empty()&&(st1.peek()=='*'||st1.peek()=='/'||st1.peek()=='+'||st1.peek()=='-')) {
//					sb.append(st1.pop());
//				}
//				st1.push(temp);
//			}
//			else if(temp=='(') {
//				st1.push(temp);
//			}else if(temp==')') {
//				while(st1.peek()!='(') {
//					sb.append(st1.pop());
//				}
//				st1.pop();
//			}
//			
//
//		}
//		while(!st1.empty()) {
//			sb.append(st1.pop());
//		}
//		System.out.println(sb.toString());
