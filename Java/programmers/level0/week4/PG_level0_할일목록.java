package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_할일목록 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] todo_list = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < todo_list.length; i++) {
            todo_list[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        boolean[] finished = new boolean[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < finished.length; i++) {
            finished[i] = Boolean.parseBoolean(st.nextToken());
        }

        String[] result = solution(todo_list, finished);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = {};

        for (int i = 0; i < todo_list.length; i++) {
            if(finished[i] == false) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = todo_list[i];
            }
        }

        return answer;
    }

}
