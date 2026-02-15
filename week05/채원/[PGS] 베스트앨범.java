

  import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
       
        //장르별 합계
        Map<String,List<int[]>> gen= new HashMap<>();
         //일단 여기서 한번 고속한 노래가 많이 재생된 장르 고르기
        Map<String,Integer> songs= new HashMap<>();
        for(int i=0; i<plays.length; i++){
            //초기화 
            gen.putIfAbsent(genres[i],new ArrayList<>());
            //값 넣어주기 
            gen.get(genres[i]).add(new int[]{ i,plays[i]});
            songs.put(genres[i],songs.getOrDefault(genres[i],0)+plays[i]);
        }
        //장르마다 2개씩 가져올수 있음
         List<Integer> answer = new ArrayList<>();
        int tmp=0;
       List<String> sortSong= new ArrayList<>(songs.keySet());
        Collections.sort(sortSong, (a,b)->{
            //살려주세요 무슨 말인지 모르겠어요~~
           return songs.get(b)-songs.get(a); 
        });
        
        for(String genr:sortSong){
            //값 꺼내오기
            List<int[]> t = gen.get(genr);
            Collections.sort(t,(a,b)->{
                if(a[1]==b[1])
                    return a[0]-b[0]; //인덱스 비교 
                else return b[1]- a[1];
                });
            
            // 2개이상인 경우에는 
            if(t.size()>=2){
                for(int i=0; i<2; i++){

                    answer.add(t.get(i)[0]);
                    tmp+=1;
                }
            }
            else{
                //1개인경우에는
                answer.add(t.get(0)[0]);
                tmp+=1;
            }
            
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}