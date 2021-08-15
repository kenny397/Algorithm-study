package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_햄버거다이어트_bitmask {
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int t=1; t<=T; t++) {
			int n=Integer.parseInt(st.nextToken());
			int l=Integer.parseInt(st.nextToken());
			int[][]info=new int[n][2];
			
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				info[i][0]=Integer.parseInt(st.nextToken());
				info[i][1]=Integer.parseInt(st.nextToken());
			}
			int ret=0;
			for(int i=1; i<(1<<n); i++) {
				int taste=0;
				int sum=0;
				for(int j=0; j<n; j++) {
					if((i&(1<<j))!=0) {
						sum+=info[j][1];
						taste+=info[j][0];
					}
				}
				if(sum<=l) {
					ret=Math.max(ret,taste);
				}
			}
			System.out.println("#"+t+" "+ret);
		}
	}
	

}
