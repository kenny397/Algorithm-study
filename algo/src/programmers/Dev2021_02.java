package programmers;

import java.util.HashSet;

public class Dev2021_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int leave=4;
		String day="FRI";
		int[]holidays= {6,21,23,27,28};
		System.out.println(solution(leave,day,holidays));
	}
	static  public int solution(int leave, String day, int[] holidays) {
        String[]days= {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        int index=0;
        for(int i=0; i<7; i++) {
        	if(day.equals(days[i])) {
        		index=i;
        		break;
        	}
        }
        HashSet<Integer> hs= new HashSet<>();
        for(int i=1; i<=30; i++) {
        	if(index==5||index==6) {
        		hs.add(i);
        	}
        	index++;
        	if(index==7)index=0;
        	
        }
        for(int i=0; i<holidays.length; i++) {
        	hs.add(holidays[i]);
        }
        
        int start=1;
        int end=1;
        int answer=0;
        int cnt=leave;
        int idx=1;
        int result=0;
        while(idx<=30) {
        	if(hs.contains(end)) {
        		end++;
        		answer++;
        	}else {
        		if(cnt<=0) {
        			while(hs.contains(start)) {
        				start++;
        				answer--;
        			}
        			start++;
        			end++;
        	
        		}else {
        			cnt--;
        			end++;
        			answer++;
        		}
        	}
        	idx++;
        	result=Math.max(answer, result);
        	
        }
        return result;
    }

}
