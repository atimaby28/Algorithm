package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_개인정보수집유효기간 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String today = br.readLine();

        int p = Integer.parseInt(br.readLine());

        String[] terms = new String[p];
        for (int i = 0; i < terms.length; i++) {
            terms[i] = br.readLine();
        }

        int q = Integer.parseInt(br.readLine());

        String[] privacies = new String[q];

        for (int i = 0; i < privacies.length; i++) {
            privacies[i] = br.readLine();
        }

        int[] result = solution(today, terms, privacies);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        HashMap<Character, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            hsmap.put(temp[0].charAt(0), Integer.parseInt(temp[1]));
        }

        int newToday = Integer.parseInt(today.replaceAll("\\.", ""));


        for (int i = 0; i < privacies.length; i++) {
            String dateStr = privacies[i].substring(0, 10);
            int dateNum = Integer.parseInt(dateStr.replaceAll("\\.", ""));

            System.out.println(dateNum + (hsmap.get(privacies[i].charAt(11)) * 100) - 1 + " " + newToday);
            if(dateNum + (hsmap.get(privacies[i].charAt(11)) * 100) - 1 < newToday) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = i + 1;
            }

        }

        Arrays.sort(answer);

        return answer;
    }

}
