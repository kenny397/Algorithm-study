package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Swea_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for(int t=1; t<=10; t++) {
				int n=Integer.parseInt(br.readLine());
			
			int ret=1;
			for(int i=0; i<n; i++) {
				String[] sp=br.readLine().split(" ");
				if(sp.length==4) {
					if(sp[1].equals("-")||sp[1].equals("+")||sp[1].equals("*")||sp[1].equals("/")) {
					
					}else {
						ret=0;
						
					}
				}else {
					if(sp[1].equals("-")||sp[1].equals("+")||sp[1].equals("*")||sp[1].equals("/")) {
						ret=0;
						
					}else {
						
					}
				}
			}
			System.out.println("#"+t+" "+ret);
			}
			
		
		
	}

}
