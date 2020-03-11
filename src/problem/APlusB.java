package problem;

import mooc.EdxIO;

public class APlusB {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()){
            io.println(io.nextInt() + io.nextInt());
        }
    }
}
