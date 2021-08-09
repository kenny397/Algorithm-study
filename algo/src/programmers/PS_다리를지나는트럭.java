package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PS_다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q=new LinkedList<>();
        Queue<Truck> bridge=new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            q.add(truck_weights[i]);
        } 
        int capcity=weight;
        int timer=0;
        
        while(true){
            timer++;
            if(!bridge.isEmpty()&&bridge.peek().start==timer){
                Truck truck=bridge.poll();
                capcity+=truck.weight;
              
            }
            if(!q.isEmpty()){
               if(capcity>=q.peek()){
                int w=q.poll();
                bridge.add(new Truck(timer+bridge_length,w));
                capcity-=w;
                System.out.println(timer);
                } 
            }
            
            
            if(bridge.isEmpty()&&q.isEmpty()){
                break;
            }
           
            
            
        }
     
        
        
        
        return timer;
    }
    static class Truck{
        int start;
        int weight;
        Truck(int start,int weight){
            this.start=start;
            this.weight=weight;
        }
    }


}
