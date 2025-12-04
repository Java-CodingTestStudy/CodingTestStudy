class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = new int[arr1.length][arr2[0].length]; //3*2 2*3 = 3*3
        int n = arr2.length;
        for(int i =0;i < arr1.length;i++){ //첫번째 행열의 행만큼
            
            for(int j=0;j < arr2[0].length;j++){  //두번째 행렬의 열만큼 
                
                int sum = 0;
                for(int k = 0 ; k<n;k++){
                    sum += arr1[i][k] * arr2[k][j];
                    
                }
                answer[i][j] = sum;
                
            }
        }
        
        return answer;
    }
}