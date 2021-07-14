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
			sumsize[idx]+=size;
			
			Ball b=new Ball(i,idx,size);
			balls[i]=b;
		}
		Arrays.sort(balls);
		for(int j=0; j<n; j++) {
			for(int i=0; i<n; i++) {
			if(i==balls[j].color) {
				sumsize[i]-=balls[j].size;
			}else {
				answer[balls[j].number]+=sumsize[i];
			}
			}
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
