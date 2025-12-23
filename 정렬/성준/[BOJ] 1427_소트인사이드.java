package studycodingtest.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
array.sort() 사용해서 오름차순 정렬 하고
for 문으로 뒤집으라구?
 */
public class BOJ_SortInside {
    public static void main(String[] args) throws IOException {
        // 밑에꺼를 습관처럼 쓰려고 연습해서 사용을 했는데....Scanner 가 더 쉬운거 아닌가?
        // readLine() 하면 throw IOEception 해서 예위 처리를 해야 하는데....
        // 언제 br 쓰고 언제 Scanner 쓰는게 감이 안오네....
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 읽어버리고
        String N = br.readLine();
        // 잘라버리고
        char[] NSplit = N.toCharArray();

        // 오름차순
        Arrays.sort(NSplit);

        String result ="";
        for(int i=NSplit.length-1;i>=0; i--){
            result += NSplit[i];
        }
        System.out.println(result);
    }

/*    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[] arr = in.nextLine().toCharArray();


        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }

    }*/
}
