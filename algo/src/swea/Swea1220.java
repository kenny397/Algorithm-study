package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1220 {
static int map[][];
static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int c = 0; c <= n; c++) {
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						
						if (map[i][j] == 1) {
							if (i + 1 == n) {
								map[i][j] = 0;

							} else if (map[i + 1][j] == 0) {
								map[i + 1][j] = 1;
								
								map[i][j] = 0;
							}
						} else if (map[i][j] == 2) {
							if (i == 0) {
								map[i][j] = 0;
							} else if (map[i - 1][j] == 0) {
								map[i - 1][j] = 2;
								
								map[i][j] = 0;
							}
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+check());
		}
		
		

	}static int check() {
		int ret=0;
		for(int j=0; j<n; j++ ) {
			boolean lastN=false;
			for(int i=0; i<n; i++) {
				if(map[i][j]==1)lastN=true;
				else if(map[i][j]==2&&lastN) {
					ret++;
					lastN=false;
				}
				
				
			}
		}
		
		return ret;
	}

}
