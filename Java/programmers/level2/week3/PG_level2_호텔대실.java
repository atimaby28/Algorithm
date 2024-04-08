package level2.week3;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PG_level2_호텔대실 {

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());

        String[][] book_time = new String[p][2];

        for (int i = 0; i < book_time.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < book_time[0].length; j++) {
                book_time[i][j] = st.nextToken();
            }
        }

        int result = solution(book_time);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[][] book_time) {
        int answer = 0;

        int[] checkTime = new int[2500];

        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replaceAll("[^0-9]", ""));
            int end = Integer.parseInt(book_time[i][1].replaceAll("[^0-9]", ""));

            int newEnd = end + 10;
            while(newEnd > 100) {
                newEnd %= 100;
            }

            if(newEnd >= 60) {
                for (int j = start; j < end + 10 - 60 + 100; j++) {
                    checkTime[j] += 1;
                }
            } else {
                for (int j = start; j < end + 10; j++) {
                    checkTime[j] += 1;
                }
            }

        }

        int room = 0;
        for (int i = 0; i < checkTime.length; i++) {
            if(checkTime[i] > room) {
                room = checkTime[i];
            }
        }

        answer = room;

        return answer;
    }


}
