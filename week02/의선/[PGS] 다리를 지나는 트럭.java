package week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
class Week2_3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
           int answer = 0;


            Queue<Integer> bridgeQue = new LinkedList<>();
            Queue<Integer> readyTruckQue = new LinkedList<>();

            
            // 다리 한칸마다 무게를 잴 수 있다 생각 ==> 초기에는 다 0 트럭이 안올라 갔으니까
            
            for(int i = 0 ; i<bridge_length ; i++)
            {
                bridgeQue.offer(0);
            }


            
            //큐에 넣어서 선입선출할 수 있게 대기
            
            for(int i : truck_weights)
            {
                readyTruckQue.offer(i);
            }

            
            int time = 0;
            int totalWeight = 0;
            
            
            while(true)
            {
                
            	
            	//현재무게 트럭이 완주하면 무게가 주니까 빼기 처리
                totalWeight-=bridgeQue.peek();
                bridgeQue.poll();

                
                //마지막 차일때 while문 종료
                if(readyTruckQue.isEmpty())
                {
                    time+=bridge_length;
                    break;
                }
                
                
                else
                {

                    
                    if((totalWeight+readyTruckQue.peek()) <= weight)
                    {
                        bridgeQue.offer(readyTruckQue.peek());
                        totalWeight+=readyTruckQue.peek();
                        readyTruckQue.poll();
                    }
                    
                    else {
                        bridgeQue.offer(0);
                    }
                }
                //while문 한번 반복당 1초 증가 
                time++;

            }

            answer = time;



            return answer;
    }
}
