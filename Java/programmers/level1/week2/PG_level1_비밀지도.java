package level1.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_비밀지도 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr2 = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        String[] result = solution(n, arr1, arr2);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < arr1.length; i++) {
            String row1 = findBinary(arr1[i], n);

            System.out.println(row1);
            for (int j = 0; j < row1.length(); j++) {
                if(row1.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }

            String row2 = findBinary(arr2[i], n);
            System.out.println(row2);
            for (int j = 0; j < row2.length(); j++) {
                if(row2.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }

        }

        for (int i = 0; i < map.length; i++) {
            answer[i] = "";
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == true) {
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }

    private static String findBinary(int i, int n) {
        String bin = Integer.toBinaryString(i);

        String zero = "";
        if(bin.length() != n) {
            int size = n - bin.length();

            for (int j = 0; j < size; j++) {
                zero += "0";
            }
        }


        return zero + bin;
    }

}
