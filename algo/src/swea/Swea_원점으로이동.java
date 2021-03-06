package swea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_원점으로이동{
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] len = new int[N];
			int sum=0;
			int cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			len[0]= Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
			int max=len[0];
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				len[i]= Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max=Math.max(max, len[i]);
				if(len[i]%2 != len[i-1]%2) {
					cnt=-1;
				}
			}
			
			if(cnt==0) {
				while(true) {
					boolean isE=true;
					if(sum<max || (max-sum)%2!=0) {
						isE=false;
					}
					if(isE)break;
					sum+=++cnt;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
			
		}System.out.println(sb);
	}
	
	
}
