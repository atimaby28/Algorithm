package level1.week4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level1_대충만든자판 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] keymap = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < keymap.length; i++) {
            keymap[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] targets = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targets.length; i++) {
            targets[i] = st.nextToken();
        }

        int[] result = solution(keymap, targets);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];


        return answer;
    }
}
