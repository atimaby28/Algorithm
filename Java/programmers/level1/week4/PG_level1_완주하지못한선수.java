package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_완주하지못한선수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] participant = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < participant.length; i++) {
            participant[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] completion = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < completion.length; i++) {
            completion[i] = st.nextToken();
        }

        String result = solution(participant, completion);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            hsmap.put(participant[i], hsmap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            hsmap.put(completion[i], hsmap.get(completion[i]) -1);
        }

        for (String mapKey : hsmap.keySet()) {
           if(hsmap.get(mapKey) == 1) {
               answer = mapKey;
           }
        }

        return answer;
    }

}
