package level1.week4;

import java.io.*;
import java.util.*;

public class PG_level1_달리기경주 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        String[] players = new String[p];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < players.length; i++) {
            players[i] = st.nextToken();
        }

        int q = Integer.parseInt(br.readLine());

        String[] callings = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < callings.length; i++) {
            callings[i] = st.nextToken();
        }

        String[] result = solution(players, callings);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = {};

//        for (int i = 0; i < callings.length; i++) {
//            for (int j = 0; j < players.length; j++) {
//                if(callings[i].equals(players[j])) {
//                    String temp = players[j - 1];
//                    players[j - 1] = callings[i];
//                    players[j] = temp;
//                }
//            }
//        }

        HashMap<String, Integer> hsmap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            hsmap.put(players[i], i + 1);
        }

        int[] score = new int[players.length + 1];

        for (int i = 0; i < callings.length; i++) {
            score[hsmap.get(callings[i])]--;
            score[hsmap.get(callings[i]) - 1]++;
            hsmap.put(callings[i], hsmap.get(callings[i]) - 1);
        }

        System.out.println(Arrays.toString(score));

        return answer;
    }

}


//5
//mumu soe poe kai mine
//4
//kai kai mine mine
