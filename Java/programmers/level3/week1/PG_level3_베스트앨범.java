package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_베스트앨범 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int k = Integer.parseInt(br.readLine());

        String[] genres = new String[k];
        int[] plays = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < genres.length; i++) {
            genres[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < plays.length; i++) {
            plays[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = solution(genres, plays);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> s2.plays == s1.plays ? s1.id - s2.id : s2.plays - s1.plays);

            bestAlbum.add(songs.get(0).id);
            if (songs.size() > 1) {
                bestAlbum.add(songs.get(1).id);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
}
