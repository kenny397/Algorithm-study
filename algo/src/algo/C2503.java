package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class C2503 {
    static int[] v;
    static int b;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        v=new int[1000];
        for(int i=0; i<n; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            String number=st.nextToken();
            int strike=Integer.parseInt(st.nextToken());
            int ball=Integer.parseInt(st.nextToken());
            for(int j=123; j<1000; j++){
                HashSet<Character> hs =new HashSet<>();
                String target=Integer.toString(j);
                for(int z=0; z<3; z++){
                    if(target.charAt(z)=='0')break;
                    hs.add(target.charAt(z));
                }
                if(hs.size()!=3)continue;
                game(Integer.toString(j),number);
                if(b==ball&&s==strike){
                    v[j]++;
                }
            }

        }
        int ret=0;
        for(int i=100; i<1000; i++){
            if(v[i]==n){
            //    System.out.println(i);
                ret++;
            }
        }
        System.out.println(ret);

    }
    static void game(String number,String target){
        b=0;
        s=0;
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(number.charAt(i)==target.charAt(j)){
                    if(i==j){
                        s++;
                        break;
                    }
                    else{
                        b++;
                        break;
                    }
                }

            }
        }

    }
}
