package programmers;

import java.util.Stack;

public class PS_큰수만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("1000",1));
	}
	 static public String solution(String number, int k) {
	        String answer = "";
	        Stack<Integer> st=new Stack<>();
	        if(number.length()==k) {
	        	return "";
	        }
	        int c=number.charAt(0)-'0';
	        st.add(c);
	        for(int i=1; i<number.length(); i++){
	            while(!st.isEmpty()&&st.peek()<number.charAt(i)-'0'&&k!=0) {
	            	st.pop();
	            	k--;
	            }
	        
	            st.add(number.charAt(i)-'0');
	            
	            
	        }
	        while(k!=0) {
	        	st.pop();
	        	k--;
	        }
	        StringBuilder sb=new StringBuilder();
	        while(!st.isEmpty()) {
	        	sb.append(st.pop());
	        }
	        return sb.reverse().toString();
	    }
}	
