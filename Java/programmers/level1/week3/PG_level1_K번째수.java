package level1.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level1_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        int[] array = new int[x];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] commands = new int[p][q];

        for (int i = 0; i < commands.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < commands[i].length; j++) {
                commands[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(array, commands);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] copyArr = Arrays.copyOf(array, array.length);

            Arrays.sort(copyArr, commands[i][0] - 1, commands[i][1]);

            answer[i] = copyArr[(commands[i][0] - 1) + (commands[i][2] - 1)];
        }

        return answer;
    }

}
