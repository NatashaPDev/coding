package problem;

import mooc.EdxIO;

public class GenerateTests {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int numberCount = io.nextInt();

            int maximalTestCount = getMaximalTestCount(numberCount);

            io.print(maximalTestCount);
        }
    }

    private static int getMaximalTestCount(int numberCount) {

        MaxDivisorResult maxDivisorResult = getMaxDivisorCount(numberCount);

        return maxDivisorResult.getNumberCount();
    }

    private static MaxDivisorResult getMaxDivisorCount(int numberCount) {

        MaxDivisorResult maxDivisorResult = new MaxDivisorResult();
        maxDivisorResult.setDivisorCount(0);
        maxDivisorResult.setNumberCount(0);

        for (int i = 2; i <= numberCount; i++) {

            for (int j = 2; j <= i / 2; j++) {

            }
        }

        return maxDivisorResult;
    }

    private static class MaxDivisorResult {

        private int divisorCount;

        private int numberCount;

        public int getDivisorCount() {
            return divisorCount;
        }

        public void setDivisorCount(int divisorCount) {
            this.divisorCount = divisorCount;
        }

        public int getNumberCount() {
            return numberCount;
        }

        public void setNumberCount(int numberCount) {
            this.numberCount = numberCount;
        }
    }
}
