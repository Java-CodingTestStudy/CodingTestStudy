package studycodingtest.Sorting;

import java.util.Arrays;

/*
    이거 큐 처럼 생각했다가 최댓값이 안나오는거 확인
    [34, 3, 30], [3, 30, 34] 이게 다른게 나옴

    숫자를 일단 전부 문자열로 바꿔
    정렬 할때 a+b랑 b+a 를 비교 해서 넣어주고
    예외로 0 이면 그냥 0 넣어줘야겠지
 */
public class PGS_BigNumber {
    public String solution(int[] numbers) {
        // 숫자 -> 문자열
        String[] arr = new String[numbers.length];
        for(int i=0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        // 정렬
        // 정렬 방법은 생각은 했는데 코드적으로 짜는 방법을 몰라서 찾아봄(구글링)
        // 하다가 코드가 살짝 틀려서 교정은 gpt (a,b) -> 인데 정신 나갔는지 (a+b)로 진행
        // compareTo() : 두 값을 배교해서 알려주는 함수
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // 이어 붙이고
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < arr.length; i++){
            sb.append(arr[i]);
        }

        // 이건 0값이 0 이면 0을 뽑으라고 혹시 0 , 0 이렇게 나오는 것도 생각을 해야 하니까
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}
