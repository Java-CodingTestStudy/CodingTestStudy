class Solution {
    public int solution(int[][] sizes) {
        /*
        지갑의 크기 -> 다양한 모양과 크기의 명함을 모두 수납할 수 있으면서 작아서 들고다니기 편한 지갑 만들기
        2가지 경우 고려 -> 세로로돌렸을때 /가로로 돌렸을 때
        */
        int wid=0; 
        int he=0;
        int minValue=Integer.MAX_VALUE;
        for(int i=0; i<sizes.length; i++){
            //세로가 제일 큰 사이즈이고 , 만약 갱신된 세로의 길이가 가로보다 작은 경우에는 세로로 돌리는 경우도 생각하기
            //반대로 가로가 제일 큰사이즈이고, 만약 갱신된 가로의 길이가 세로보다 작은 경우에는 세로로 돌리는 경우도 생각하기
            //예시인 경우 = > 80*50
            // 60/50 => 60/50 | 70 /30 => 70/50 | 60,30=>70,50 | 80,40 => 80,50
            int w= Math.max(sizes[i][0],sizes[i][1]);
            int h=Math.min (sizes[i][0],sizes[i][1]);
           
            wid= Math.max(w,wid);
            he=Math.max(h,he);
        }
        int answer = wid*he;
        return answer;
    }
}