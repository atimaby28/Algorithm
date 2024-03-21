package level2.week2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.StringTokenizer;

public class PG_level2_파일명정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] files = new String[k];

        for (int i = 0; i < files.length; i++) {
            files[i] = br.readLine();
        }

        String[] result = solution(files);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static String[] solution(String[] files) {
        String[] answer = {};

        String[][] fileList = new String[files.length][3];

        for (int i = 0; i < files.length; i++) {
            char[] cha = files[i].toCharArray();
            int range1 = 0;
            for (int j = 0; j < cha.length; j++) {
                if(Character.isDigit(cha[j])) {
                    range1 = j;
                    break;
                }
            }

            int range2 = cha.length;

            for (int j = range1; j < cha.length; j++) {
                if(!Character.isDigit(cha[j])) {
                    range2 = j;
                    break;
                }
            }

            fileList[i][0] = files[i].substring(0, range1);
            fileList[i][1] = files[i].substring(range1, range2);
            fileList[i][2] = files[i].substring(range2);
        }

        Arrays.sort(fileList, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                System.out.println(Arrays.toString(o1) + " " + Arrays.toString(o2));

                int headVal = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());

                if(headVal == 0) {
                    int a = Integer.parseInt(o1[1]);
                    int b = Integer.parseInt(o2[1]);

                    return a - b;
                } else {
                    return headVal;
                }
            }
        });

        answer = new String[fileList.length];

        for (int i = 0; i < fileList.length; i++) {
            answer[i] = "";
            for (int j = 0; j < 3; j++) {
                answer[i] += fileList[i][j];
                System.out.print(fileList[i][j] + " ");
            }
            System.out.println();
        }



        return answer;
    }

}
