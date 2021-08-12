package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2961 {
static int n;
static int ret=Integer.MAX_VALUE;
static int[][] material;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		material=new int[n][2];
		for(int i=0; i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());			
			material[i][0]=Integer.parseInt(st.nextToken());
			material[i][1]=Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<(1<<n);i++) {
			make(i);
		}
		System.out.println(ret);
	}
	static void make(int combi) {
		int a=1;
		int b=0;
		for(int i=0; i<n; i++) {
			if((combi&1<<i)!=0) {
				a*=material[i][0];
				b+=material[i][1];
			}
		}
		ret=Math.min(ret, Math.abs(a-b));
		
	}

}
