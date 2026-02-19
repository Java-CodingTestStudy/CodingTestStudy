import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        visited = new boolean[n];

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, "", arr, n, k, set);

        System.out.println(set.size());
    }

    static void dfs(int cnt, String current, int[] arr, int n, int k, Set<Integer> set) {

        if (cnt == k) {
            set.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(cnt + 1, current + arr[i], arr, n, k, set);

                visited[i] = false;
            }
        }
    }
}
