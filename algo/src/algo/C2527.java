package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C2527 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ret="";
		for(int t=0; t<4; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int nx1=Integer.parseInt(st.nextToken());
			int ny1=Integer.parseInt(st.nextToken());
			int nx2=Integer.parseInt(st.nextToken());
			int ny2=Integer.parseInt(st.nextToken());
		
			if((x1==nx2&&y2==ny1)||(x1==nx2&&y1==ny2)||(x2==nx1&&y1==ny2)||(x2==nx1&&y2==ny1)) {
				ret="c";
			}else if ((x2 == nx1 && y2 != ny1) || (x1 == nx2 && y2 != ny1) || (x2 != nx1 && y1 == ny2) || (x1 != nx2 && y1 == ny2)) {
	            ret= "b";
	        } else if (x2 < nx1 || nx2 < x1 || y2 < ny1 || ny2 < y1) {
	        	ret="d";
	        }else {
	        	ret="a";
	        }System.out.println(ret);
		}
		
	}
	

}
