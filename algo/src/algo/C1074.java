package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1074 {
	static int N;
	static int r;
	static int c;
	static int answer = -1;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		recur(0, 0, (int) Math.pow(2, N),0);
		System.out.println(answer);

	}

	static void recur(int e, int f, int d,int count) {
		if (d == 1) {

			answer = count;

			return;
		}

		

		if (r < e + d / 2 && c < f + d / 2) {

			recur(e, f, d / 2,count);

		} else if (r < e + d / 2 && c >= f + d / 2) {
		
			recur(e, f + d / 2, d / 2,count+=(d/2)*(d/2));

		} else if (r >= e + d / 2 && c < f + d / 2) {
			recur(e + d / 2, f, d / 2,count+=2*(d/2)*(d/2));

		} else if (r >= e + d / 2 && c >= f + d / 2) {
			recur(e + d / 2, f + d / 2, d / 2,count+=3*(d/2)*(d/2));
		}

	}

}
