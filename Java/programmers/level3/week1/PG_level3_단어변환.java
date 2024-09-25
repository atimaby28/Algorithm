package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_단어변환 {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String begin = st.nextToken();
        String target = st.nextToken();

        int k = Integer.parseInt(st.nextToken());

        String[] words = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < words.length; i++) {
            words[i] = st.nextToken();
        }

        int result = solution(begin, target, words);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;



        return answer;
    }

}
