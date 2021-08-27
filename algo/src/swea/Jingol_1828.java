package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jingol_1828 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Node[] refri=new Node[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			refri[i]=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(refri);
		int sum=1;
		int mid=refri[0].max;
		for(int i=1; i<n; i++) {
			if(refri[i].min<=mid) {
				if(refri[i].max<=mid) {
					mid=refri[i].max;
				}else {
					continue;
					
				}
			}else {
				sum++;
				mid=refri[i].max;
			}
		}
		System.out.println(sum);
		
	}
	static class Node implements Comparable<Node>{
		int min,max;

		public Node(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(this.min==o.min) {
				return this.max-o.max;
			}
			return this.min-o.min;
			
		}
	}

}
