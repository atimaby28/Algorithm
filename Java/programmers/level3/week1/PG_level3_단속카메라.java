package level3.week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level3_단속카메라 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        int[][] routes = new int[k][2];

        for (int i = 0; i < routes.length; i++) {
            st = new StringTokenizer(br.readLine());
            routes[i][0] = Integer.parseInt(st.nextToken());
            routes[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = solution(routes);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    /*
        카메라는 항상 진출지점을 기준으로 설치되어야한다. 만약, 가장 먼저 진입한 차량의 종점구간에 카메라가 설치된다면,
        중간에 진입한 차량이 진출구간이전에 진출하였다면, 카메라가 단속을 하지 못하게 된다. 어차피 진출한 지점에 카메라를
        설치해야한다면, 가장 먼저 진출한 차량지점에 카메라를 설치하게된다. 그럼 모든 위치를 커버할 수 있게된다.
        진입지점에서는 카메라를 볼 수 없으므로, 진출지점에는 무조건 카메라가 존재해야한다.
     */
    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int lastLength = Integer.MIN_VALUE;
        for(int[] route : routes) {
            System.out.println(route[0] + " " + route[1]);
            int head = route[0];
            int tail = route[1];

            if(head > lastLength) {
                lastLength = tail;
                System.out.println(lastLength);
                answer++;
            }

        }

        return answer;
    }

}
