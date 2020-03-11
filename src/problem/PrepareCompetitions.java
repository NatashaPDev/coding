package problem;

import mooc.EdxIO;

public class PrepareCompetitions {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {

            int dayCount;

            int[] theory;

            int[] practice;

            dayCount = io.nextInt();

            theory = new int[dayCount];

            practice = new int[dayCount];

            for (int i = 0; i < dayCount; i++) {
                theory[i] = io.nextInt();
            }

            for (int i = 0; i < dayCount; i++) {
                practice[i] = io.nextInt();
            }

            io.print(getMaxAbility(theory, practice, dayCount));
        }
    }

    public static int getMaxAbility(int[] theory, int [] practice, int dayCount) {

        int[] theoryPracticeDifference = new int[dayCount];

        for (int i = 0; i < dayCount; i++) {
            theoryPracticeDifference[i] = theory[i] - practice[i];
        }

        int maxTheoryDay = findMaxTheoryDay(theoryPracticeDifference);

        int maxPracticeDay = findMaxPracticeDay(theoryPracticeDifference);

        int maxAbility = 0;

        for (int i = 0; i < dayCount; i++) {

            if (i == maxTheoryDay) {
                maxAbility += theory[i];
            } else if (i == maxPracticeDay) {

                maxAbility += practice[i];
            } else if (theoryIsBigger(theoryPracticeDifference, i)) {
                maxAbility += theory[i];

            } else {
                maxAbility += practice[i];
            }
        }

        return maxAbility;
    }

    private static boolean theoryIsBigger(int[] theoryPracticeDifference, int day) {
        return theoryPracticeDifference[day] > 0;
    }

    private static int findMaxPracticeDay(int[] theoryPracticeDifference) {

        int min = Integer.MAX_VALUE;

        int maxDay = -1;

        for (int i = 0; i < theoryPracticeDifference.length; i++) {

            if (theoryPracticeDifference[i] <= min) {

                min = theoryPracticeDifference[i];
                maxDay = i;
            }
        }

        return maxDay;
    }

    private static int findMaxTheoryDay(int[] theoryPracticeDifference) {

        int max = Integer.MIN_VALUE;

        int maxDay = -1;

        for (int i = 0; i < theoryPracticeDifference.length; i++) {

            if (theoryPracticeDifference[i] > max) {

                max = theoryPracticeDifference[i];
                maxDay = i;
            }
        }

        return maxDay;
    }
}
