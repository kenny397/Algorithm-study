package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C2515 {
	static long n;
	static long s;
	static long max;
	static long[]cache;
	static Drawing[]drawings;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = pL(st.nextToken()); s = pL(st.nextToken());
		cache=new long[(int)n+1];
		drawings=new Drawing[(int)n];
		Arrays.fill(cache, -1);
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
            int a = pI(st.nextToken()), b = pI(st.nextToken());
		
			drawings[i]=new Drawing(a,b);
		}
		Arrays.sort(drawings);
		
		for(int i=0; i<n; i++) {
			max=Math.max(max,dp(i,drawings[i].height)+drawings[i].cost );
		}
		System.out.println(max);
	}
	static long dp(int start,int lastheight) {

		
		if(cache[(int)start]!=-1) {
			return cache[(int)start];
		}
		for(int i=start+1; i<n; i++) {
			if(lastheight<=drawings[i].height-s) {
				cache[start]=Math.max(dp(i,drawings[i].height)+drawings[i].cost,cache[start]);				
			}
		}
		return cache[start];
	}
	 static long pL(String s) {
	        return Long.parseLong(s);
	    }

	static int pI(String s) {
	        return Integer.parseInt(s);
	    }
	static class Drawing implements Comparable<Drawing>{
		int height;
		int cost;
		Drawing(int height,int cost){
			this.height=height;
			this.cost=cost;
		}
		@Override
		public int compareTo(Drawing o) {
			// TODO Auto-generated method stub
			if(this.height==o.height) {
				return o.cost-this.cost;
			}
			return this.height-o.height;
		}
	}

}
