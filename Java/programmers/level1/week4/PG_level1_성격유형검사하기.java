package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_성격유형검사하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int s = Integer.parseInt(br.readLine());

        String[] survey = new String[s];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < survey.length; i++) {
            survey[i] = st.nextToken();
        }

        int d = Integer.parseInt(br.readLine());

        int[] choices = new int[d];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < choices.length; i++) {
            choices[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(survey, choices);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<Character, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < choices.length; i++) {
            if(choices[i] < 4) {
                if(choices[i] == 1) {
                    hsmap.put(survey[i].charAt(0), hsmap.getOrDefault(survey[i].charAt(0), 0) + 3);
                } else if (choices[i] == 2) {
                    hsmap.put(survey[i].charAt(0), hsmap.getOrDefault(survey[i].charAt(0), 0) + 2);
                } else if (choices[i] == 3) {
                    hsmap.put(survey[i].charAt(0), hsmap.getOrDefault(survey[i].charAt(0), 0) + 1);
                }
            } else if (choices[i] > 4) {
                if(choices[i] == 5) {
                    hsmap.put(survey[i].charAt(1), hsmap.getOrDefault(survey[i].charAt(1), 0) + 1);
                } else if (choices[i] == 6) {
                    hsmap.put(survey[i].charAt(1), hsmap.getOrDefault(survey[i].charAt(1), 0) + 2);
                } else if (choices[i] == 7) {
                    hsmap.put(survey[i].charAt(1), hsmap.getOrDefault(survey[i].charAt(1), 0) + 3);
                }
            }
        }

        if(hsmap.containsKey('R') && hsmap.containsKey('T') && hsmap.get('R') == hsmap.get('T')) {
            hsmap.remove('T');
        }

        if(hsmap.containsKey('C') && hsmap.containsKey('F') && hsmap.get('C') == hsmap.get('F')) {
            hsmap.remove('F');
        }

        if(hsmap.containsKey('J') && hsmap.containsKey('M') && hsmap.get('J') == hsmap.get('M')) {
            hsmap.remove('M');
        }

        if(hsmap.containsKey('A') && hsmap.containsKey('N') && hsmap.get('A') == hsmap.get('N')) {
            hsmap.remove('N');
        }

        List<Character> score = new ArrayList<>(hsmap.keySet());

        Collections.sort(score, (o1, o2) -> {
            if (hsmap.get(o1) > hsmap.get(o2)) {
                return -1;
            } else if (hsmap.get(o1) > hsmap.get(o2)) {
                return 1;
            } else {
                if(o1 > o2) {
                    return -1;
                } else if(o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });


        System.out.println(score);

        return answer;
    }

}
