package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level3_디스크컨트롤러 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        int[][] jobs = new int[t][2];

        for (int i = 0; i < jobs.length; i++) {
            st = new StringTokenizer(br.readLine());

            jobs[i][0] = Integer.parseInt(st.nextToken());
            jobs[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(jobs);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 작업이 끝나는 시점
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 완료된 작업 수

        // 요청 시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 처리 시간을 기준으로 정렬되는 우선순위 큐
        PriorityQueue<Job> pq = new PriorityQueue<>();

        // 모든 작업이 처리될 때까지 반복
        while (count < jobs.length) {
            // 현재 시간(end) 이전에 요청된 작업들을 우선순위 큐에 추가
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.offer(new Job(jobsIdx, jobs[jobsIdx][0], jobs[jobsIdx][1]));
                jobsIdx++;
            }

            if (pq.isEmpty()) {
                // 큐가 비어 있다면, 다음 요청의 시작 시간으로 이동
                end = jobs[jobsIdx][0];
            } else {
                // 작업 시간이 가장 짧은 작업 처리
                Job currentJob = pq.poll();
                end += currentJob.taskTime;
                answer += end - currentJob.requestTime;
                count++;
            }
        }

        // 평균을 구하여 반환
        return answer / jobs.length;
    }

    static class Job implements Comparable<Job> {
        int jobNum;       // 작업 번호
        int requestTime;  // 요청 시간
        int taskTime;     // 작업 소요 시간

        public Job(int jobNum, int requestTime, int taskTime) {
            this.jobNum = jobNum;
            this.requestTime = requestTime;
            this.taskTime = taskTime;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.taskTime, o.taskTime); // 작업 시간이 짧은 순으로 정렬
        }

    }

}
