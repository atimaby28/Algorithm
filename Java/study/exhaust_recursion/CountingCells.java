package exhaust_recursion;

// 해당 위치에 있는 색칠된 범위
public class CountingCells {
    private static int N = 8;
    private static int UNCHECKED = 0;
    private static int IMAGE_COLOUR = 1;
    private static int ALREADY_COUNTED = 2;
    private static int[][] pixel = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };

    public static void main(String[] args) {

        printPixel();
        int blobCount = findBlobCount(5, 5);
        printPixel();

        System.out.println(blobCount);
    }

    private static int findBlobCount(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= N) {
            return UNCHECKED;
        } else if (pixel[x][y] != IMAGE_COLOUR) {
            return UNCHECKED;
        } else {
            pixel[x][y] = ALREADY_COUNTED;

            return 1 + findBlobCount(x - 1, y) + findBlobCount(x, y + 1)
                    + findBlobCount(x + 1, y) + findBlobCount(x, y - 1)
                    + findBlobCount(x - 1, y - 1) + findBlobCount(x - 1, y + 1)
                    + findBlobCount(x + 1, y + 1) + findBlobCount(x + 1, y - 1);

        }
    }

    private static void printPixel() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(pixel[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
