package swea;

import java.util.Scanner;
import java.util.Stack;

public class Swea5432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			String input=sc.next();
			System.out.println(cut(input));
		}
		
	}
	static int cut(String input) {
		int ret=0;
		
		Stack<Character>st=new Stack<>();
		for(int i=0;i<input.length(); i++) {
			char check=input.charAt(i);
			if(check=='(') {
				st.add(check);
			}else if(check==')'){
				st.pop();
				
			}
		}
		
		
		
		
		return ret;
	}

}
