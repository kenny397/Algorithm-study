package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1759 {
static boolean[]v;
static int l;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		l=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		v= new boolean[26];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			v[st.nextToken().charAt(0)-'a']=true;
		}
		dfs(-1,0,"",0,0);
	}
	static void dfs(int current,int deep,String result,int cnt1,int cnt2) {
		if(deep==l) {
			if(cnt1>=1&&cnt2>=2) {
				System.out.println(result);
				
			}
			return;
		}
		for(int i=current+1; i<26; i++) {
			if(v[i]) {
				if(i==0||i==4||i==8||i==14||i==20) {
					dfs(i,deep+1,result+(char)(i+'a'),cnt1+1,cnt2);					
				}else {
					dfs(i,deep+1,result+(char)(i+'a'),cnt1,cnt2+1);					
					
				}
			}
		}
	}

}
