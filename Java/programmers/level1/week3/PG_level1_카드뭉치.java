package level1.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level1_카드뭉치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] cards1 = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards1.length; i++) {
            cards1[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] cards2 = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards2.length; i++) {
            cards2[i] = st.nextToken();
        }

        String[] goal = new String[p + q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < goal.length; i++) {
            goal[i] = st.nextToken();
        }

        String result = solution(cards1, cards2, goal);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        Queue<String> card1Que = new LinkedList<>();
        Queue<String> card2Que = new LinkedList<>();

        for (int i = 0; i < cards1.length; i++) {
            card1Que.offer(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            card2Que.offer(cards2[i]);
        }

        String check = "";
        String gol = "";
        for (int i = 0; i < goal.length; i++) {
            if(!card1Que.isEmpty() && card1Que.peek().equals(goal[i])) {
                check +=  card1Que.peek();
                card1Que.poll();
            } else if(!card2Que.isEmpty() && card2Que.peek().equals(goal[i])) {
                check +=  card2Que.peek();
                card2Que.poll();
            }
            gol += goal[i];
        }

        if(check.equals(gol)){
            answer = "Yes";
        } else {
            answer = "No";
        }

        return answer;
    }

}
