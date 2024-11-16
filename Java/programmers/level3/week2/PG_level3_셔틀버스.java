package level3.week2;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PG_level3_셔틀버스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] timetable = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < timetable.length; i++) {
            timetable[i] = st.nextToken();
        }

        String result = solution(n, t, m, timetable);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        // 1. 크루의 도착 시간을 분으로 변환하여 정렬
        List<LocalTime> crewTimes = new ArrayList<>();

        for (String time : timetable) {
            crewTimes.add(LocalTime.parse(time));
        }

        Collections.sort(crewTimes);

        // 2. 셔틀 버스 시간표 생성
        List<LocalTime> shuttleTimes = new ArrayList<>();

        LocalTime firstShuttle = LocalTime.of(9, 0);

        for (int i = 0; i < n; i++) {
            shuttleTimes.add(firstShuttle.plusMinutes(t * i));
        }

        // 3. 셔틀 운행 시뮬레이션
        int crewIndex = 0;
        LocalTime lastPossibleTime = LocalTime.MIN;

        for (LocalTime shuttleTime : shuttleTimes) {
            int capacity = m;

            while (capacity > 0 && crewIndex < crewTimes.size() && !crewTimes.get(crewIndex).isAfter(shuttleTime)) {
                capacity--;
                crewIndex++;
            }

            // 마지막 셔틀의 경우 가능한 가장 늦은 시간을 계산
            if (shuttleTime.equals(shuttleTimes.get(shuttleTimes.size() - 1))) {
                if (capacity > 0) {
                    // 자리가 남으면 셔틀 도착 시간에 탑승 가능
                    lastPossibleTime = shuttleTime;
                } else {
                    // 자리가 없으면 마지막으로 탄 크루보다 1분 빨리 도착해야 함
                    lastPossibleTime = crewTimes.get(crewIndex - 1).minusMinutes(1);
                }
            }
        }

        // 결과 반환
        return lastPossibleTime.toString();
    }
}
