package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Jungol2577 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int[]belt=new int[n];
		for(int i=0; i<n; i++) {
			belt[i]=Integer.parseInt(br.readLine());			
		}
		int[]eat=new int[d+1];
		eat[c]++;
		int count=1;
		for(int i=0; i<k; i++) {
			if(eat[belt[i]]==0)count++;
			eat[belt[i]]++;
		}
		int ret=count;
		for(int i=1; i<n; i++) {
			eat[belt[i-1]]--;
			if(eat[belt[i-1]]==0)count--;
			int plus=i+k-1;
			if(plus>=n) {
				plus-=n;
			}		
			if(eat[belt[plus]]==0)count++;
			eat[belt[plus]]++;
			ret=Math.max(ret, count);
		}
		System.out.println(ret);
		
		
		
	}

}
