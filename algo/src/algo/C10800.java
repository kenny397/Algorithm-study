package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C10800 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int n=Integer.parseInt(s);
		int[]sumsize=new int[n];
		int[]answer=new int[n];
		Ball[] balls=new Ball[n];
		for(int i=0; i<n; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int idx=changeInt(st.nextToken())-1;
			int size=changeInt(st.nextToken());
			
			
			Ball b=new Ball(i,idx,size);
			balls[i]=b;
		}
		Arrays.sort(balls);
		for(Ball b: balls) {
			System.out.println(b.number+" "+b.color+" "+b.size);
		}
		int sum=0;
		int j=n-1;
		for(int i=0; i<n; i++) {
			Ball a=balls[i];
			Ball b=balls[j];
			while(b.size<a.size) {
				sum+=b.size;
				sumsize[b.color]+=b.size;
				b=balls[--j];
			}
			answer[a.number]=sum-sumsize[a.color];
			
		}
		
		for(int a:answer) {
			System.out.println(a);
		}
		
	}
	static int changeInt(String inputstr){
		return Integer.parseInt(inputstr);
	}
	static class Ball implements Comparable<Ball>{
		int number;
		int color;
		int size;
		public Ball(int number,int color, int size) {
			this.number=number;
			this.color = color;
			this.size = size;
		}
		@Override
		public int compareTo(Ball o) {
			// TODO Auto-generated method stub
				
			return o.size-this.size;
		}
		
	}


}
