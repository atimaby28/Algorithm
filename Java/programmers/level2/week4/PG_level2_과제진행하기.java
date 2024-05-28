package level2.week4;

import java.io.*;
import java.util.*;

public class PG_level2_과제진행하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        String[][] plans = new String[k][3];

        for (int i = 0; i < plans.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < plans[0].length; j++) {
                plans[i][j] = st.nextToken();
            }
        }

        String[] result = solution(plans);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }
    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        Stack<int[]> stack = new Stack<>();

        // 1. 시간순으로 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int n1 = Integer.parseInt(o1[1].replaceAll("[^0-9]", ""));
                int n2 = Integer.parseInt(o2[1].replaceAll("[^0-9]", ""));

                return Integer.compare(n1, n2);
            }
        });

        // 2. 과제 중 새로운 과제가 들어온다면 Stack에 삽입
        int k = 0;
        for(int i = 0; i < plans.length - 1; i++) {
            String[] t1 = plans[i][1].split(":");
            String[] t2 = plans[i + 1][1].split(":");

            int time1 = Integer.parseInt(t1[0]) * 60 + Integer.parseInt(t1[1]);
            int time2 = Integer.parseInt(t2[0]) * 60 + Integer.parseInt(t2[1]);

            int playtime = Integer.parseInt(plans[i][2]);

            int taskTime = time2 - time1;
            int remainTime = taskTime - playtime;

            if(taskTime < playtime) {
                stack.push(new int[]{i, playtime - taskTime});
            } else {
                answer[k++] = plans[i][0];

                while(remainTime > 0 && !stack.isEmpty()) {
                    int[] temp = stack.pop();
                    int index = temp[0];
                    int res = temp[1];

                    if(remainTime < res) {
                        stack.push(new int[]{index, res - remainTime});
                        break;
                    } else {
                        answer[k++] = plans[index][0];
                        remainTime = remainTime - res;
                    }
                }
            }

            if(i + 1 == plans.length - 1) {
                answer[k++] = plans[plans.length - 1][0];
            }

        }

        while(!stack.isEmpty()) {
            answer[k++] = plans[stack.pop()[0]][0];
        }

        return answer;
    }

}

/*

3
korean 11:40 30
english 12:10 20
math 12:30 40


4
science 12:40 50
music 12:20 40
history 14:00 30
computer 12:30 100

3
aaa 12:00 20
bbb 12:10 30
ccc 12:40 10

5
a 9:00 10
b 9:10 10
c 9:15 10
d 9:30 10
e 9:35 10

 */