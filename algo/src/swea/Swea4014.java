package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea4014 {
	static int n, x, ret;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	
			x = Integer.parseInt(st.nextToken()); 	
			ret = 0;
			
		
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				checkAvailable(map[i]);
				
			
				int[] tmp = new int[n];
				for (int j = 0; j < n; j++) {
					tmp[j] = map[j][i];
				}
				checkAvailable(tmp);
			}
			
			
			System.out.println("#" + t + " " + ret);
		}
	}
	
	private static void checkAvailable(int[] line) {
		int now = line[0]; 
		int cnt = 1;		
		boolean flag = false; 
		
		for(int i = 1; i < n; i++) {
			if(Math.abs(line[i - 1] - line[i]) > 1) return;
			if(now == line[i]) {
				cnt += 1;
				if(flag && cnt == x) {
					cnt = 0;
					flag = false;
				}
				continue;
			} else if (now < line[i]) {
				if(cnt < x) return;
				flag = false;
			} else {
				if(flag && cnt < x) return;
				flag = true;
			}
			cnt = 1;
			now = line[i];
		}
		if(flag && cnt < x) return;
		ret += 1;
	}

}
