package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_LIS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			int[]set=new int[n];
			ArrayList<Integer>cache=new ArrayList<>();
			cache.add(0);
			for(int i=0; i<n; i++) {
				set[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<n; i++) {
				if(set[i]>cache.get(cache.size()-1)) {
					cache.add(set[i]);
				}else {
					int left=0; 
					int right=cache.size()-1;
					while(left<right) {
						int mid=(left+right)/2;
						if(cache.get(mid)<set[i]) {
							left=mid+1;
						}else {
							right=mid;
						}
					}
					cache.set(right,set[i]);
				}
				
			}
			System.out.println(cache.size()-1);
			
		}
	}

}
