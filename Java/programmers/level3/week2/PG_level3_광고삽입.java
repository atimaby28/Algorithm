package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_광고삽입 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String play_time = st.nextToken();
        String adv_time = st.nextToken();

        int n = Integer.parseInt(br.readLine());

        String[] logs = new String[n];

        for (int i = 0; i < logs.length; i++) {
            logs[i] = br.readLine();
        }

        String result = solution(play_time, adv_time, logs);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static String solution(String playTime, String advTime, String[] logs) {
        // 1. 전체 재생 시간과 광고 시간을 초 단위로 변환
        int playSeconds = timeToSeconds(playTime);
        int advSeconds = timeToSeconds(advTime);

        // 2. 초 단위 배열 생성 및 시청자 수 기록
        int[] watch = new int[playSeconds + 1];
        for (String log : logs) {
            String[] times = log.split("-");
            int start = timeToSeconds(times[0]);
            int end = timeToSeconds(times[1]);
            watch[start]++;
            if (end < playSeconds) watch[end]--;
        }

        // 3. 누적 시청자 수 계산
        for (int i = 1; i <= playSeconds; i++) {
            watch[i] += watch[i - 1];
        }

        // 4. 슬라이딩 윈도우로 누적 시청 시간 계산
        long maxWatchTime = 0;
        long currentWatchTime = 0;
        int startTime = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < advSeconds; i++) {
            currentWatchTime += watch[i];
        }
        maxWatchTime = currentWatchTime;

        // 슬라이딩 윈도우 이동
        for (int i = advSeconds; i <= playSeconds; i++) {
            currentWatchTime += watch[i] - watch[i - advSeconds];
            if (currentWatchTime > maxWatchTime) {
                maxWatchTime = currentWatchTime;
                startTime = i - advSeconds + 1;
            }
        }

        // 5. 초 단위를 HH:MM:SS 형식으로 변환하여 반환
        return secondsToTime(startTime);
    }

    // HH:MM:SS → 초 단위 변환
    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    // 초 단위 → HH:MM:SS 변환
    public static String secondsToTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

/*
02:03:55 00:14:15
5
01:20:15-01:45:14
00:40:31-01:00:00
00:25:50-00:48:29
01:30:59-01:53:29
01:37:44-02:02:30
 */