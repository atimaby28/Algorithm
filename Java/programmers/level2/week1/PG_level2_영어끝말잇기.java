package level2.week1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PG_level2_영어끝말잇기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int k = Integer.parseInt(br.readLine());
        String[] words = new String[k];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < words.length; i++) {
            words[i] = st.nextToken();
        }

        int[] result = solution(n, words);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        set.add(words[0]);

        int loseNum = 0;
        for (int i = 1; i < words.length; i++) {

            if(set.contains(words[i])) {
                loseNum = i;
                break;
            }

            set.add(words[i]);

            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                loseNum = i;
                break;
            }

        }

        if(loseNum != 0) {
            answer[0] = (loseNum % n) + 1;
            answer[1] = (loseNum / n) + 1;
        } else {
            answer[0] = 0;
            answer[0] = 0;
        }

        return answer;
    }

}
