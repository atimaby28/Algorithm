package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_베스트앨범 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] genres = new String[k];
        int[] plays = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < genres.length; i++) {
            genres[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < plays.length; i++) {
            plays[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(genres, plays);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> hsmap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            hsmap.put(genres[i], hsmap.getOrDefault(genres[i], 0) + plays[i]);
        }

        String[][] board = new String[genres.length][4];

        for(int i = 0; i < board.length; i++) {
            board[i][0] = genres[i];
            board[i][1] = Integer.toString(plays[i]);
            board[i][2] = Integer.toString(hsmap.get(genres[i]));
            board[i][3] = Integer.toString(i);
        }

        Arrays.sort(board, (o1, o2) -> {
            if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
            }
            return Integer.compare(Integer.parseInt(o2[2]), Integer.parseInt(o1[2]));
        });

        List<Integer> arrList = new ArrayList<>();

        String str = board[0][0];
        int cnt = 1;

        arrList.add(Integer.parseInt(board[0][3]));

        for(int i = 1; i < board.length; i++) {

            if(str.equals(board[i][0]) && cnt < 2) {
                cnt++;
                arrList.add(Integer.parseInt(board[i][3]));
            } else if(!str.equals(board[i][0])) {
                arrList.add(Integer.parseInt(board[i][3]));
                cnt = 1;
                str = board[i][0];
            }
        }

        answer = arrList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
