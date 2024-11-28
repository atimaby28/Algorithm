package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_표편집 {

    final static String[] friends = {"무지", "콘", "어피치", "제이지", "프로도", "네오", "튜브", "라이언"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());

        String[] cmd = new String[x];

        for (int i = 0; i < cmd.length; i++) {
            cmd[i] = br.readLine();
        }

        String result = solution(n, k, cmd);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        String [][] table = new String[n][3];

        for (int i = 0; i < table.length; i++) {
            table[i][0] = Integer.toString(i);
            table[i][1] = friends[i];
            table[i][2] = "O";
        }

        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + " " + table[i][1] + " " + table[i][2]);
            System.out.println();
        }

        int pointer = k;
        for (String command : cmd) {
            String[] c = command.split(" ");

            if(c[0].equals("D")) {
                pointer += Integer.parseInt(c[1]);
            } else if(c[0].equals("U")) {
                pointer -= Integer.parseInt(c[1]);
            } else if(c[0].equals("Z")) {
                table[pointer][2] = "O";
            } else {
                table[pointer][2] = "X";

                if(pointer != n - 1)
                    pointer++;
                else
                    pointer--;
            }
        }

        for (int i = 0; i < table.length; i++) {
            answer += table[i][2];
        }

        return answer;
    }

}

/*
8 2
9
D 2
C
U 3
C
D 4
C
U 2
Z
Z
 */

// OOOOXOOO