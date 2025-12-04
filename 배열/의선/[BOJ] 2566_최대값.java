package 배열;

import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int x=0,y=0,max=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j] = sc.nextInt();
                if(max<arr[i][j]){
                	max = arr[i][j];
                    x= i;
                    y= j;
                }
            }
        }
        
        System.out.println(arr[x][y]);
        x++;
        y++;
        System.out.println(x+" "+y);
        
    }
}
