package programmers;

import java.util.HashSet;

public class Dev2021_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]reg= {"bird99", "bird98", "bird101", "gotoxy"};
		String new_id="bird98";
		System.out.print(solution(reg,new_id));
		}
	 public static String solution(String[] registered_list, String new_id) {
	        String answer = "";
	        HashSet<String> hs=new HashSet<>();
	        for(int i=0; i<registered_list.length; i++) {
	        	hs.add(registered_list[i]);
	        }
	        
	        String result=new_id;
	        
	        while(true) {
	        	if(!hs.contains(result)) {
	        		break;
	        	}else {
	        		int nindex=0;
	        		for(int i=0; i<result.length(); i++) {
	        			if(result.charAt(i)<='9'&&result.charAt(i)>=1) {
	        				nindex=i;
	        				break;
	        			}
	        		}
	        		if(nindex==0) {
	        			result+="1";
	        		}else {
	        			String S=result.substring(0,nindex);
	        			String N=result.substring(nindex);
	        			int newN=Integer.parseInt(N)+1;
	        			result=S+Integer.toString(newN);
	        		}
	        	}
	        }
	        return result;
	    }

}
