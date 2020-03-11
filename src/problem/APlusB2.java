package problem;

import mooc.EdxIO;

public class APlusB2 {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            long a = io.nextLong();
            long b = io.nextLong();

            io.print(a + b * b);
        }
    }
}
