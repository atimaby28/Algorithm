package level2.week2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PG_level2_주차요금계산 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] fees = new int[p];
        String[] records = new String[q];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fees.length; i++) {
            fees[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < records.length; i++) {
            records[i] = br.readLine();
        }

        int[] result = solution(fees, records);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int[] answer = {};

        HashMap<String, Date> dateHash = new HashMap<>();
        HashMap<String, Long> totalHash = new HashMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        String[][] table = new String[records.length][3];

        for (int i = 0; i < records.length; i++) {
            table[i] = records[i].split(" ");
        }

        for (int i = 0; i < table.length; i++) {

            if(table[i][2].equals("IN")) {
                dateHash.put(table[i][1], sdf.parse(table[i][0]));
            } else {
                Date dateIn = dateHash.get(table[i][1]);
                Date dateOut = sdf.parse(table[i][0]);

                Long time = (dateOut.getTime() - dateIn.getTime()) / (1000 * 60);

                totalHash.put(table[i][1], totalHash.getOrDefault(table[i][1], 0L) + time);

                dateHash.remove(table[i][1]);
            }
        }

        for (String key : dateHash.keySet()) {
            Date Oclock = sdf.parse("23:59");

            Long remainTime = (Oclock.getTime() - dateHash.get(key).getTime()) / (1000 * 60);

            totalHash.put(key, totalHash.getOrDefault(key, 0L) + remainTime);
        }

        ArrayList<String> arrayList = new ArrayList<>(totalHash.keySet());

        Collections.sort(arrayList, (o1, o2) -> {
            if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                return 1;
            } else if (Integer.parseInt(o1) < Integer.parseInt(o2)) {
                return -1;
            } else {
                return 0;
            }
        });

        answer = new int[totalHash.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            Long hour = totalHash.get(arrayList.get(i));

            if(hour > fees[0]) {
                answer[i] += fees[1];
                answer[i] += (int) (Math.ceil((double) (hour - fees[0]) / fees[2]) * fees[3]);
            } else if(hour <= fees[0]) {
                answer[i] += fees[1];
            }
        }

        return answer;
    }

}
