package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C18870 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long[] map=new long[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		TreeSet<Long>hs=new TreeSet<Long>();
		for(int i=0; i<n; i++) {
			map[i]=Integer.parseInt(st.nextToken());
			hs.add(map[i]);
		}
		HashMap<Long,Integer> hm=new HashMap<>();
		int idx=0;
		for(long t: hs) {
			hm.put(t,idx++);
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<n; i++) {
			sb.append(hm.get(map[i])+" ");
		}
		System.out.println(sb.toString());
	}

}
