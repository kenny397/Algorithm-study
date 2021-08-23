package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Swea_암호문1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
		int n=Integer.parseInt(br.readLine());
		LinkedList<String> list=new LinkedList<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list.addLast(st.nextToken());
		}
		int cnum=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<cnum; i++) {
			String command=st.nextToken();
			int start=Integer.parseInt(st.nextToken());
			int cnt=Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				list.add(start+j, st.nextToken());
			}
		}
		System.out.print("#"+t+" ");
		for(int i=0; i<10; i++) {
			if(i==9) System.out.println(list.get(i));
			else System.out.print(list.get(i)+" ");
		}
	}
	}

}
