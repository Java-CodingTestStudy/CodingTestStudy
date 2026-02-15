package week5;

class Solution4 {
    public int solution(int[][] sizes) {
        int answer = 0;

        int maxW=0,maxH=0;

        int len = sizes.length;

        for(int i=0;i<len;i++){





            int x = Math.max(sizes[i][0],sizes[i][1]);
            int y = Math.min(sizes[i][0],sizes[i][1]);


            if(x>maxW){
                maxW = x;
            }
            if(y>maxH){
                maxH = y;
            }


        }




        return maxW*maxH;
    }
}