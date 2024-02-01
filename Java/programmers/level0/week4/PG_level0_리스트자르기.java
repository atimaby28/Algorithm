package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_리스트자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int p = Integer.parseInt(br.readLine());

        int[] slicer = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < slicer.length; i++) {
            slicer[i] = Integer.parseInt(st.nextToken());
        }

        int q = Integer.parseInt(br.readLine());

        int[] num_list = new int[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num_list.length; i++) {
            num_list[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(n, slicer, num_list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};

        if (n == 1) {

            for (int i = 0; i <= slicer[1]; i++) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = num_list[i];
            }

        } else if (n == 2) {

            for (int i = slicer[0]; i < num_list.length; i++) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = num_list[i];
            }

        } else if (n == 3) {

            for (int i = slicer[0]; i <= slicer[1]; i++) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = num_list[i];
            }

        } else if (n == 4) {

            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = num_list[i];
            }

        }

        return answer;
    }
}
