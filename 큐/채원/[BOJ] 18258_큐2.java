import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
    //SCANNER를 사용했으나, 시간 초과가 나 CHATGPT에게 질문했습니다. 
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 결과를 한 번에 모아서 출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 명령의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 정수를 저장할 큐
        Queue<Integer> q = new LinkedList<>();

        // back 명령을 위해 마지막으로 push된 값을 저장
        int index = 0;

        // 명령 처리
        for (int i = 0; i < n; i++) {

            // 한 줄씩 명령 입력
            String s = br.readLine();
            // 명령어 분리 (push x 또는 단일 명령)
            String[] tmp = s.split(" ");

            // push x : 큐에 x 삽입
            if ("push".equals(tmp[0])) {
                int x = Integer.parseInt(tmp[1]);
                q.offer(x);
                index = x; // 마지막 값 저장 (back용)
            }

            // front : 큐의 맨 앞 출력
            else if ("front".equals(tmp[0])) {
                if (q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.peek()).append('\n');
            }

            // pop : 큐의 맨 앞 제거 후 출력
            else if ("pop".equals(tmp[0])) {
                if (q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(q.poll()).append('\n');
            }

            // back : 큐의 맨 뒤 출력
            else if ("back".equals(tmp[0])) {
                if (q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(index).append('\n');
            }

            // empty : 큐가 비어있으면 1, 아니면 0
            else if ("empty".equals(tmp[0])) {
                sb.append(q.isEmpty() ? "1\n" : "0\n");
            }

            // size : 큐에 들어있는 정수 개수
            else if ("size".equals(tmp[0])) {
                sb.append(q.size()).append('\n');
            }
        }

        // 모든 출력 한 번에 처리 (속도 핵심)
        System.out.print(sb.toString());
    }
}
