package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2961_combi {
	static int n;
	static int ret=Integer.MAX_VALUE;
	static int[][] material;
	static boolean[]v;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		material=new int[n][2];
		v=new boolean[n];
		for(int i=0; i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());			
			material[i][0]=Integer.parseInt(st.nextToken());
			material[i][1]=Integer.parseInt(st.nextToken());
		}
		
		combi(0,0);
		System.out.println(ret);
	}
	static void combi(int deep,int start) {
		if(deep==n) {
			
			int a=1;
			int b=0;
			for(int i=0; i<n; i++) {
				if(v[i]) {
					a*=material[i][0];
					b+=material[i][1];
				}
			}
			if(a==1&&n==0)return;
			ret=Math.min(ret, Math.abs(a-b));
			return;
		}
		for(int i=start; i<n; i++) {
			if(!v[i]) {
				v[i]=true;
				combi(deep+1,i+1);
				v[i]=false;
				combi(deep+1,i+1);
			}
			
		}
		
	}

}
