package greedy;

import java.io.*;
import java.util.*;

public class 씨름선수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] list = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }


        int result = solution(list);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    private static int solution(int[][] list) {
        int answer = 0;

        ArrayList<Player> players = new ArrayList<>();

        for (int[] player : list) {
            players.add(new Player(player[0], player[1]));
        }

        Collections.sort(players);

        int max = Integer.MIN_VALUE;

        for (Player player : players) {
            if(player.weight > max) {
                max = player.weight;
                answer++;
            }
        }

        return answer;
    }
}

class Player implements Comparable<Player>{
    int height, weight;

    Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Player p) {
        return Integer.compare(p.height, this.height);
    }

}


/*
5
172 67
183 65
180 70
170 72
181 60
 */
