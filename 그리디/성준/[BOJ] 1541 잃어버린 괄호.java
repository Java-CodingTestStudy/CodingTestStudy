package studycodingtest.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    + -
    아니 문제 설명이 너무 불친절한데
    최소를 만들라며 => 다 - 사용하라는거 아닌가?
    이해했다
    55 - (50+40) 이렇게 하라는거네
    그니까 뒤에 뺄셈을 했을때 큰수 나오게 하라는건데 괄호 위치를 내가 정해주는 방법은 배운적이 없는데
    아니 근데 밑에 for 문을 써도 가장 앞숫자가 커도 - 일때 그 뒤가 +일때까지 묶어야 하는거 아닌가?
    설명을 봐도 모르겠는데....이거 진짜 gpt 안돌리면 모를거 같은데.....일단 내 로직 생각을 제출을 한 다음 아이디어를 들어보고 수정을 해서 올리겠음
    그리고 무엇보다....시간이 없어서 죄송합니다.

    for(나눠진 데이터 개수)
        if
           가장 앞 숫자가 클때
        else if
            가장 작은 숫자가 끌때

 */
public class BOJ_LostParenthesis {
    public static void main(String[] args) throws IOException {
        // 이거까지는 값을 받으려고 만들고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String calculation = br.readLine();

        // 일단 - 에서 쪼개는게 맞는거 같아서 넣어주고
        String[] minus = calculation.split("-");

        for (
                //TODO 여기 - 이후 부분을 더해주는거 하면 될거 같은데
        )
    }
}
