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
//		for(int i=0; i<n; i++) {
//			long v=Long.parseLong(st.nextToken());
//			while(!q.isEmpty()) {
//				if(q.peek().height>=v) {
//					bw.write(q.peek().index+1 + " ");
//					break;
//				}
//				q.pop();
//			} if(q.isEmpty()){
//				 bw.write("0 ");
//            }
//			q.add(new topInfo(v,i));
//		}
		long[]map=new long[n];
		for(int i=0; i<n; i++) {
			map[i]=Long.parseLong(st.nextToken());
		}
		int[]answer=new int[n];
		for(int i=n-1;i>=0; i--) {
			if(q.isEmpty())q.add(new topInfo(map[i],i));
			else {
				while(!q.isEmpty()&&q.peek().height<=map[i]) {
					answer[q.pop().index]=i+1;
				}
				q.add(new topInfo(map[i],i));
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<n; i++) {
			if(i==n-1) sb.append(answer[i]);

			else sb.append(answer[i]+" ");
		}
		System.out.println(sb.toString());
		
		
			
		
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
