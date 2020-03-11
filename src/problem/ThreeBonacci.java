package problem;

import mooc.EdxIO;

public class ThreeBonacci {

    private static int a0;

    private static int a1;

    private static int a2;

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            a0 = io.nextInt();
            a1 = io.nextInt();
            a2 = io.nextInt();

            int i = io.nextInt();

            int t = threeBonacci(i);

            io.print(t);
        }
    }

    public static int threeBonacci(int i) {

        int tMinus1 = a2;

        int tMinus2 = a1;

        int tMinus3 = a0;

        int t = 0;

        if (i == 0) {
            t = a0;

        } else if (i == 1) {
            t = a1;

        } else if (i == 2) {
            t = a2;
        }

        for (int j = 3; j <= i; j++) {

            t = tMinus1 + tMinus2 - tMinus3;

            tMinus3 = tMinus2;
            tMinus2 = tMinus1;
            tMinus1 = t;
        }

        return t;
    }
}
