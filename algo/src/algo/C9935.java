package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class C9935 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		String boom=br.readLine();
		Stack<Character>st=new Stack<>();
		br.close();
		int l=boom.length();
		for(int i=0; i<str.length(); i++) {
			st.add(str.charAt(i));
			if(st.size()>=l) {
				boolean flag=true;
				for(int j=0; j<l; j++) {
					if(st.get(st.size()-l+j)!=boom.charAt(j)) {
						flag=false;
						break;
					}
				}
				if(flag) {
					for(int j=0; j<l; j++) {
						st.pop();
					}
				}
			}
		}StringBuilder sb = new StringBuilder();
		for (char character : st) 
		{ sb.append(character); }
		String answer=sb.toString();

		
		if(answer.equals(""))bw.write("FRULA");
		else bw.write(answer);
		
		bw.flush();
		bw.close();
	}

}
