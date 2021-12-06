package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Swea_보물상자비밀번호 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			char[]dice=br.readLine().toCharArray();
			HashSet<Integer>hs=new HashSet<>();
			int window=n/4;
			for(int i=0; i<n; i++) {
				String oct="";
				for(int j=i; j<i+window; j++) {
					if(j>=n) {
						oct+=dice[j-n];
					}else {
						oct+=dice[j];
						
					}
				}
				hs.add(Integer.parseInt(oct, 16));
			}
			ArrayList<Integer>al=new ArrayList<>(hs);
			Collections.sort(al,Comparator.reverseOrder());
			System.out.println("#"+t+" "+al.get(k-1));
		}
	}

}
