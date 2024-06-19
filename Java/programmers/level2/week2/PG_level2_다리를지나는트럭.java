package level2.week2;

import java.io.*;
import java.util.*;

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

        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        int time = 0;

        for(int i = 0; i < truck_weights.length; i++) { // 향상된 for문을 쓰는게 좋을 것
            int truck = truck_weights[i];

            while(true) {
                // 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리위에 없음
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++; // 다리에 오를 때만 시간 추가
                    break;
                } else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    sum -= queue.poll();
                } else  { // 다리 길이만큼 큐가 차지않았음
                    // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이
        answer = time + bridge_length;

        return answer;
    }

}
