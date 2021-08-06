package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class C4889 {
	
	
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=0;
		while(true) {
			t++;
			String input=br.readLine();
			if(input.contains("-")) {
				break;
			}
			Stack<Character> st=new Stack<>();
			int idx=0;
			int ret=0;
			while(idx!=input.length()) {
				char temp=input.charAt(idx);
				if(st.isEmpty()) {
					if(temp=='}') {
						st.add('{');
						ret++;
					}else {
						st.add('{');
					}
				}else {
					if(temp=='{') {
						st.add(temp);
					}else {
						st.pop();
					}
				}
				idx++;
			}
			ret+=st.size()/2;
			System.out.println(t+". "+ret);
		}
	}
}
