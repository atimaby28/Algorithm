package level0.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_5명씩 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] names = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < names.length; i++) {
            names[i] = st.nextToken();
        }

        String[] result = solution(names);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] names) {
        String[] answer = {};

        for (int i = 0; i < names.length; i += 5) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length - 1] = names[i];
        }
        return answer;
    }

//    public String[] solution(String[] names) {
//        String[] answer = new String[(names.length-1)/5+1];
//        for(int i=0; i<answer.length; i++) {
//            answer[i] = names[5*i];
//        }
//        return answer;
//    }

}
