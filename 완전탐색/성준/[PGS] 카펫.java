package studycodingtest.Brute_ForceSerch;
/*
    예?
    가로 세로가 몇인지 나오게 담으라는거죠?
    일단 세로는 3 이상이라는거고 => 테두리 만들어야하니까...

    이거 진짜 몰라서 https://www.youtube.com/watch?v=weC1vkQRX_E&t=23s 문제 사고 설명을 봤습니다.

    카펫의 격자수는 12 개 이다. => 넓이는 12이다. (이게 여러쌍이 나올 수 있다.)
    큰 사각형의 넓이
    = 갈색 격자의 개수 + 노란 격자의 개수
    = 카펫의 가로 * 카펫의 세로

    작은 사각형의 넓이
    = 노란색 격자의 개수
    = (카펫의 가로 - -2) * (카펫의 세로 -2)
 */
public class PGS_Carpet {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int total = brown + yellow;

            // 세로 정해놓고 가로를 전부 대입
            for(int height = 3; height<=total; height++) {
                for (int width = height; width <= total; width++) {

                    // 전체 넓이를 구하고
                    if(width * height != total) {
                        continue;}
                    if((width - 2) * (height -2)==yellow) {
                        return new int[]{width, height};
                    }
                }
            }
            // 나는 메서드 받았으니까 당연하게 return int[]; 하면 되는 줄 알았는데 아무것도 못찾았을때를 대비한 보험으로 빈 배열을 반환 해야한다고 함.
            return new int[0];
        }
    }
}
