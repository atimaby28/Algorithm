package level1.week3;

import java.io.*;
import java.util.*;

public class PG_level1_모의고사 {

    public final static int[] patternOne = {1, 2, 3, 4, 5};
    public final static int[] patternTwo = {2, 1, 2, 3, 2, 4, 2, 5};
    public final static int[] patternThree = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        int[] answers = new int[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < answers.length; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(answers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] ==  patternOne[i % patternOne.length]) {
                score[0]++;
            }

        }
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] ==  patternTwo[i % patternTwo.length]) {
                score[1]++;
            }
        }
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] ==  patternThree[i % patternThree.length]) {
                score[2]++;
            }
        }


        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        for (int i = 0; i < score.length; i++) {
            if(score[i] != 0 && score[i] == maxScore) {
                answer = Arrays.copyOf(answer, answer.length + 1);
                answer[answer.length - 1] = i + 1;
            }
        }

        return answer;
    }

}
