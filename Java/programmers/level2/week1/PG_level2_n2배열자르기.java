package level2.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_n2배열자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());

        int[] result = solution(n, left, right);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];


        int startLine = (int) (left / n);
        int endLine = (int) (right / n);

        int[] arr = new int[(endLine - startLine + 1) * n];

        for (int i = startLine; i <= endLine; i++) {
            for (int j = 0; j < n; j++) {
                if(j > i) {
                    arr[((i * n) + j) - (startLine * n)] = j + 1;
                } else {
                    arr[((i * n) + j) - (startLine * n)]  = i + 1;
                }
            }
        }

        int startPos = (int) (left % n);
        int endPos = (int) (right % n);

        int k = 0;
        for (int i = startPos; i <= ((endLine - startLine) * n) + endPos; i++) {
            answer[k++] = arr[i];
        }

        return answer;
    }
}

}
