package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;


public class C1655 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> max=new PriorityQueue<>();//작은거 먼저나옴 오른쪽
		PriorityQueue<Integer> min=new PriorityQueue<>(Collections.reverseOrder());// 큰거먼저 나옴 왼쪽
		for(int i=0; i<n; i++) {
			int a=Integer.parseInt(br.readLine());
			if(max.size()==min.size()) min.add(a);
			else max.add(a);
			if(!min.isEmpty()&&!max.isEmpty()) {
				if(min.peek()>max.peek()) {
				int t=min.poll();
				int t2=max.poll();
				min.add(t2);
				max.add(t);
				}
			}
			
			
			bw.write(min.peek()+ "\n");
			
		}
		bw.flush();
		
	}
	

}
