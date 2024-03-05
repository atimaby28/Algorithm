package level2.week1;

import java.io.*;
import java.util.HashMap;
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

        String[][] wordMap = new String[n][words.length / n];

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) + 1);
        }

        boolean flag = false;

        int k = 0;
        for (int i = 0; i < words.length / n; i++) {
            for (int j = 0; j < n; j++) {
                wordMap[j][i] = words[k++];
                System.out.println(wordMap[j][i]);
                System.out.println(wordCount.get(wordMap[j][i]));
                if (wordCount.get(wordMap[j][i]) != 1) {
                    answer[0] = j;
                    answer[1] = i;

                }

                if(j != 0 && wordMap[j - 1][i].charAt(wordMap[j - 1][i].length() - 1) != wordMap[j - 1][i].charAt(0)) {
                    answer[0] = j;
                    answer[1] = i;

                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return answer;
    }

}
