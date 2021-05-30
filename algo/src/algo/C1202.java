package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C1202 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		jam[] jams=new jam[n];
		int[] bags=new int[k];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			jams[i]=new jam(w,p);
		}
		for(int i=0; i<k; i++) {
			bags[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(jams);
		Arrays.sort(bags);
		int idx=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		
		long answer=0;
		for(int i=0; i<k; i++) {
			while(idx<n&&jams[idx].weight<=bags[i]) {
				pq.add(jams[idx].price);
				idx++;
			}
			if(!pq.isEmpty())answer+=pq.poll();
		}
		System.out.println(answer);
	}
	
	
	

	static class jam implements Comparable<jam>{
		int weight,price;
		jam(int weight, int price){
			this.weight=weight;
			this.price=price;
		}
		@Override
		public int compareTo(jam o) {
			// TODO Auto-generated method stub
				return this.weight-o.weight;
		}
		
	}
}

