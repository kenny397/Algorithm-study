package programmers;

import java.util.*;
public class DevMatching3 {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String,String>parent=new HashMap<>();
        HashMap<String,Integer>hm=new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i],referral[i]);
        }
        for(int i=0; i<seller.length; i++){
            String sell=seller[i];
            double money=amount[i]*100;
            while(true){
                String t=parent.get(sell);
                int m=(int)(money*0.1);
                money=money-m;
                if(t.equals("-")){
                    hm.put(sell,hm.getOrDefault(sell,0)+(int)(money));
                    break;
                }
                    hm.put(sell,hm.getOrDefault(sell,0)+(int)(money));
                    money=m;


                sell=t;
            }
        }
        for(int i=0; i<enroll.length; i++){
            if(hm.containsKey(enroll[i])){
                answer[i]=hm.get(enroll[i]);
            }else{
                answer[i]=0;
            }
        }
        System.out.println(hm.values());
        return answer;
    }
}
