import java.util.*;

class Solution {

    // 후보키들을 저장할 리스트
    // 각 후보키는 "어떤 컬럼들을 사용했는지"를 저장
    static List<List<Integer>> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {

        int columnCount = relation[0].length;  // 컬럼 개수

        // 컬럼을 1개부터 columnCount개까지 선택해보자
        for (int size = 1; size <= columnCount; size++) {
            // 조합을 만들어보자
            combination(relation, new ArrayList<>(), 0, size);
        }

        // 후보키 개수 반환
        return candidateKeys.size();
    }


    // 조합을 만드는 함수
    // current : 현재 선택한 컬럼들
    // start   : 다음에 선택할 컬럼 시작 위치
    // size    : 몇 개를 뽑을지
    public void combination(String[][] relation,
                            List<Integer> current,
                            int start,
                            int size) {

        // 원하는 개수만큼 뽑았으면 검사하자
        if (current.size() == size) {

            // 1. 최소성 검사
            if (!isMinimal(current)) {
                return; // 최소성이 깨지면 그냥 종료
            }

            // 2. 유일성 검사
            if (isUnique(relation, current)) {
                // 둘 다 만족하면 후보키에 추가
                candidateKeys.add(new ArrayList<>(current));
            }

            return;
        }

        // start부터 끝까지 하나씩 선택해보기
        for (int i = start; i < relation[0].length; i++) {
            current.add(i);                 // 컬럼 선택
            combination(relation, current, i + 1, size);
            current.remove(current.size() - 1); // 다시 빼기 (백트래킹)
        }
    }


    // 최소성 검사
    // 이미 후보키로 등록된 것의 "부분집합"이면 안 된다
    public boolean isMinimal(List<Integer> current) {

        for (List<Integer> key : candidateKeys) {

            // key가 current 안에 전부 포함되어 있다면
            if (current.containsAll(key)) {
                return false; // 최소성 위반
            }
        }

        return true;
    }


    // 유일성 검사
    // 선택한 컬럼들로 모든 행이 서로 구분되는지 확인
    public boolean isUnique(String[][] relation, List<Integer> current) {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {

            String result = "";

            // 선택된 컬럼들만 이어붙이기
            for (int column : current) {
                result += relation[i][column] + ",";
            }

            set.add(result);
        }

        // 행 개수와 set 크기가 같으면 모두 다른 것
        return set.size() == relation.length;
    }
}