package problem;

import mooc.EdxIO;

public class PutChairsRightWay {

    public static void main(String[] args) {

        int a;
        int b;
        int c;

        try (EdxIO io = EdxIO.create()) {

            a = io.nextInt();
            b = io.nextInt();
            c = io.nextInt();

            io.print(getAverageDistance(a, b, c));
        }
    }

    private static double getAverageDistance(int a, int b, int c) {

        return (((double) a) / 2 + ((double) b) /2 + ((double) c) / 2) / 3;
    }
}
