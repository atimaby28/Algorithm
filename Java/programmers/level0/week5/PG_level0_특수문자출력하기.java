package level0.week5;

import java.io.*;

public class PG_level0_특수문자출력하기 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("!@#$%^&*(\\'\"<>?:;");

        bw.flush();
        bw.close();
    }

}
