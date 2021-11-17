package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class C1244 {
static int[] switches;
	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length=Integer.parseInt(br.readLine());
		switches=new int[length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<length; i++) {
			switches[i]=Integer.parseInt(st.nextToken());
		}
	
		int n=Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int no=Integer.parseInt(st.nextToken());
			operate(gender,no);
		}
		for (int i = 0; i < switches.length; i++) {
			if(i==switches.length-1) System.out.print(switches[i]);
			else System.out.print(switches[i]+" ");
			if(i%20==19) System.out.println();
		}
	}
	static void operate(int gender,int no) {
		if(gender ==1) {
			for(int i=1; i*no<=switches.length; i++) {
				if(switches[i*no-1]==0) {
					switches[i*no-1]=1;
				}else {
					switches[i*no-1]=0;
					
				}
			}
		}
		if(gender==2) {
			if(switches[no-1]==0) {
				switches[no-1]=1;
			}else {
				switches[no-1]=0;
			}
			for(int i=1; i<switches.length; i++) {
				if(no+i>switches.length||no-i<1)break;
				if(switches[no+i-1]==switches[no-i-1]) {
					if(switches[i+no-1]==1) {
						switches[no+i-1]=0;
						switches[no-i-1]=0;
					}else {
						switches[no+i-1]=1;
						switches[no-i-1]=1;
						
					}
				}else {
					break;
				}
			}
		}
	}

	
}
