package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C10216 {
static int []p;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int z=0; z<t; z++) {
			int n=Integer.parseInt(br.readLine());
			p=new int[n];
			int[][] info=new int[n][3];
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(br.readLine());
				info[i][0]=Integer.parseInt(st.nextToken());
				info[i][1]=Integer.parseInt(st.nextToken());
				info[i][2]=Integer.parseInt(st.nextToken());
				p[i]=i;
			}
			int answer=n;
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					int difx=info[i][0]-info[j][0];
					int dify=info[i][1]=info[j][1];
					int distance=info[i][2]+info[j][2];
					
					if((difx*difx)+(dify*dify)<=distance*distance) {
						if(find(i)!=find(j)) {
							union(i,j);
							answer--;
						}
					}
				}
			}
			sb.append(answer+ "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static int find(int a) {
		if(p[a]==a) {
			return a;
		}else {
			return p[a]=find(p[a]);
		}
	}
	static void union(int a, int b) {
		a=find(a);
		b=find(b);
		
		if(a!=b) {
			if(a<b) {
				p[b]=a;
			}else {
				p[a]=b;
			}
		}
	}

}
