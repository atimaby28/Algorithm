package level2.week2;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_다리를지나는트럭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int bridge_length = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[] section = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < section.length; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(bridge_length, weight, section);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> waitingTruck = new LinkedList<>();
        Queue<Integer> onTheRoad = new LinkedList<>();
        Queue<Integer> passedTruck = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waitingTruck.offer(truck_weights[i]);
        }

        int bridgeWeight = 0;
        while (!waitingTruck.isEmpty() || !onTheRoad.isEmpty()) {
            while ((onTheRoad.size() < bridge_length)) {
                int truckWeight = waitingTruck.peek() == null ? 0 : waitingTruck.peek();
                if (bridgeWeight + truckWeight <= weight) {
                    bridgeWeight += truckWeight;
                    onTheRoad.offer(truckWeight);
                    waitingTruck.poll();
                } else {
                    onTheRoad.offer(0);
                }
                answer++;
            }

            while (!onTheRoad.isEmpty()) {
                bridgeWeight -= onTheRoad.poll();
            }

        }

        return answer;
    }

}
