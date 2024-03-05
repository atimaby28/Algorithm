package level2.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_카펫 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int brown = Integer.parseInt(st.nextToken());
        int yellow = Integer.parseInt(st.nextToken());

        int[] result = solution(brown, yellow);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i * i <= yellow; i++) {
            if(yellow % i == 0) {
                System.out.println(i);
                int comp = (i * 2) + (((yellow / i) + 2) * 2);
                if(brown == comp) {
                    answer[0] = (yellow / i)  + 2;
                    answer[1] = i + 2;
                }
            }
        }

        return answer;
    }

}
