package problem;

import mooc.EdxIO;

public class CreateTeam {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            double[] andrew = new double[3];
            double[] peter = new double[3];
            double[] paul = new double[3];

            for (int i = 0; i < andrew.length; i++) {
                andrew[i] = io.nextDoublePrecise();
            }

            for (int i = 0; i < peter.length; i++) {
                peter[i] = io.nextDoublePrecise();
            }

            for (int i = 0; i < paul.length; i++) {
                paul[i] = io.nextDoublePrecise();
            }

            io.print(getEfficiency(andrew, peter, paul));
        }
    }

    private static double getEfficiency(double[] andrew, double[] peter, double[] paul) {

        double max = 0;

        for (int i = 0; i < andrew.length; i++) {

            for (int j = 0; j < peter.length; j++) {

                for (int k = 0; k < paul.length; k++) {

                    if (i != j && j != k && i != k) {

                        double efficiency = Math.sqrt(
                                Math.pow(andrew[i], 2) + Math.pow(peter[j], 2) + Math.pow(paul[k], 2));

                        if (efficiency > max) {
                            max = efficiency;
                        }
                    }
                }
            }
        }

        return max;
    }
}
