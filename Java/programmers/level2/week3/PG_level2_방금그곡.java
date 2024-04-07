package level2.week3;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PG_level2_방금그곡 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        String m = br.readLine();

        int k = Integer.parseInt(br.readLine());

        String[] musicinfos = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < musicinfos.length; i++) {
            musicinfos[i] = st.nextToken();
        }

        String result = solution(m, musicinfos);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static String solution(String m, String[] musicinfos) throws ParseException {
        String answer = "(None)";

        String[][] infotable = new String[musicinfos.length][];
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        m = m.replaceAll("C#", "U");
        m = m.replaceAll("D#", "V");
        m = m.replaceAll("F#", "W");
        m = m.replaceAll("G#", "X");
        m = m.replaceAll("A#", "Y");
        m = m.replaceAll("B#", "Z");

        for (int i = 0; i < musicinfos.length; i++) {
            infotable[i] = musicinfos[i].split(",");
        }

        int songLength = 0;
        for (int i = 0; i < infotable.length; i++) {
            Date startTime = sdf.parse(infotable[i][0]);
            Date endTime = sdf.parse(infotable[i][1]);

            int time = (int)(endTime.getTime() - startTime.getTime()) / (1000 * 60);

            infotable[i][3] = infotable[i][3].replaceAll("C#", "U");
            infotable[i][3] = infotable[i][3].replaceAll("D#", "V");
            infotable[i][3] = infotable[i][3].replaceAll("F#", "W");
            infotable[i][3] = infotable[i][3].replaceAll("G#", "X");
            infotable[i][3] = infotable[i][3].replaceAll("A#", "Y");
            infotable[i][3] = infotable[i][3].replaceAll("B#", "Z");

            String tempo = "";

            for (int j = 0; j < time; j++) {
                tempo += infotable[i][3].charAt(j % infotable[i][3].length());
            }

            if(tempo.contains(m) && songLength < time) {
                answer = infotable[i][2];
                songLength = time;
            }

        }

        return answer;
    }
}


//ABCDEFG
//2
//12:00,12:14,HELLO,CDEFGAB 13:00,13:05,WORLD,ABCDEF

//CC#BCC#BCC#BCC#B
//2
//03:00,03:30,FOO,CC#B 04:00,04:08,BAR,CC#BCC#BCC#B