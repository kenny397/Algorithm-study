package algo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class C2493 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		
		Stack<topInfo> q=new Stack<>(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			long v=Long.parseLong(st.nextToken());
			while(!q.isEmpty()) {
				if(q.peek().height>=v) {
					bw.write(q.peek().index+1 + " ");
					break;
				}
				q.pop();
			} if(q.isEmpty()){
				 bw.write("0 ");
            }
			q.add(new topInfo(v,i));
		}
		
		
		bw.flush();
        br.close();
        bw.close();
		
			
		
	}

}
class topInfo{
	long height;
	int index;
	topInfo(long height, int index){
		this.height=height;
		this.index=index;
	}
}
