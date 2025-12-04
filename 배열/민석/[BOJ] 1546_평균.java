import java.io.*;
import java.util.*;

public class Main {
    static int[]arr;
    public static void main(String[] args) throws IOException  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


        int a=Integer.parseInt(br.readLine());
        String[]array=new String[a];
        int[]arr=new int[a];
        int max;
        array=br.readLine().split(" ");

        for(int i=0;i<a;i++){

            arr[i]=Integer.parseInt(array[i]);

        }
        max=arr[0];
        for(int i=0;i<a-1;i++){
            if(max<arr[i+1]){
                max=arr[i+1];

            }
        }
        float sum=0;
        for(int i=0;i<a;i++){
            sum+=((float)arr[i]/(float)max)*(float)100;

        }
        float avg=sum/(float)a;
        System.out.println(avg);

    }


}
