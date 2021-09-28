package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C3040 {
static boolean[]v;
static int[]peoples;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		peoples=new int[9];
		v=new boolean[9];
		for(int i=0; i<9; i++) {
			peoples[i]=Integer.parseInt(br.readLine());
		}
		combi(0,0);
			
		
		
	}
	static void combi(int deep,int start) {
		if(deep==7) {
			int sum=0;
			for(int i=0; i<9; i++) {
				if(v[i]) {
					sum+=peoples[i];
				}
			}
			if(sum==100) {
				
				for(int i=0; i<9; i++) {
					if(v[i]) {
						System.out.println(peoples[i]);
					}
				}
			}
			return;
		}
		for(int i=start; i<9; i++) {
			if(!v[i]) {
				v[i]=true;
				combi(deep+1,i+1);
				v[i]=false;
			}
			
		}
	}

}
