import java.util.*;

class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        /*
         * 맵을 순회하면서 모든 P에 대해 dfs
         * 상하좌우 탐색하며 P인 경우 거리 계산
         * dfs는 boolean을 반환
         * 탐색을 상하좌우 거리 2까지, 각 대각선까지만 수행?
         * X인 경우 바로 continue로 다음 탐색
         * 
         */

        for (int i = 0; i < places.length; i++) {

            System.out.println("============");
            if (isValid(places[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }

        return answer;
    }

    private boolean isValid(String[] map) {
        System.out.println(Arrays.toString(map));
        // map 순회
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length(); j++) {
                char cur = map[i].charAt(j);

                System.out.println(cur);
                // 사람이면 상하좌우 탐색
                if (cur == 'P') {
                    if (!dfs(map, i, j, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // originx, originy 기준 상하좌우 거리 2이하 탐색하여 위반 유무 검사
    private boolean dfs(String[] map, int x, int y, int originx, int originy) {
        System.out.println("x,y = " + x + "," + y);

        // 오른쪽 검사
        if (y + 1 < map[0].length() && map[x].charAt(y + 1) == 'P')
            return false;
        if (y + 2 < map[0].length() && (map[x].charAt(y + 1) != 'X' && map[x].charAt(y + 2) == 'P'))
            return false;

        // 왼쪽 검사
        if (y - 1 >= 0 && map[x].charAt(y - 1) == 'P')
            return false;
        if (y - 2 >= 0 && (map[x].charAt(y - 1) != 'X' && map[x].charAt(y - 2) == 'P'))
            return false;

        // 위쪽 검사
        if (x - 1 >= 0 && map[x - 1].charAt(y) == 'P')
            return false;
        if (x - 2 >= 0 && (map[x - 1].charAt(y) != 'X' && map[x - 2].charAt(y) == 'P'))
            return false;

        // 아래 검사
        if (x + 1 < map.length && map[x + 1].charAt(y) == 'P')
            return false;
        if (x + 2 < map.length && (map[x + 1].charAt(y) != 'X' && map[x + 2].charAt(y) == 'P'))
            return false;

        // 대각선 검사
        if (x - 1 >= 0 && y + 1 < 5 && map[x - 1].charAt(y + 1) == 'P') {
            if (map[x].charAt(y + 1) != 'X' || map[x - 1].charAt(y) != 'X')
                return false;
        }
        if (x + 1 < 5 && y + 1 < 5 && map[x + 1].charAt(y + 1) == 'P') {
            if (map[x].charAt(y + 1) != 'X' || map[x + 1].charAt(y) != 'X')
                return false;
        }
        if (x - 1 >= 0 && y - 1 >= 0 && map[x - 1].charAt(y - 1) == 'P') {
            if (map[x].charAt(y - 1) != 'X' || map[x - 1].charAt(y) != 'X')
                return false;
        }
        if (x + 1 < 5 && y - 1 >= 0 && map[x + 1].charAt(y - 1) == 'P') {
            if (map[x].charAt(y - 1) != 'X' || map[x + 1].charAt(y) != 'X')
                return false;
        }

        return true;
    }
}