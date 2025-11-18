import java.util.Scanner;

/*
 * LetterGrade: 
 * This program is supposed to compute a student's letter grade
 * from multiple quiz scores ranging from 0-100 in value.
 * 
 * Intended behavior:
 * 1) Read the student's name.
 * 2) Read in multiple quiz scores as integer values.
 * 3) Validate that each score is between 0 and 100; if not, force it into this range.
 * 4) If the average >= 60, the student passes.
 * 5) Assign letter grade by average: A >= 90, B >= 80, C >= 70, D >= 60, else F.
 * 6) Print a short summary.
 */

public class LetterGrade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt user for name.
        System.out.print("Enter student name: ");
        String name = in.nextLine();

        // Initialize variables to be used to find the total points,
        // and the min and max values.
        int total = 0;

        // min was initialized to 0, so if all scores are > 0, the minimum
        // would stay at 0 instead of the actual lowest score.
        // int min = 0;
        // Fix it by initializing min to the maximum possible score so the first real score
        // will correctly update it.
        int min = 100;

        int max = -1;
        final int COUNT = 4;

        // loop COUNT times to obtain the test scores for the student.
        for (int i = 1; i <= COUNT; i++) {
            System.out.print("Enter score " + i + " (0-100): ");
            int s = in.nextInt();

            // Validate input.
            // Only scores from 0 to 100 are allowed.
            // If a score is less than zero, force it to be equal to zero.
            // If a score is greater than 100, force it to be equal to 100.

            // The condition (s < 0 && s > 100) can't be true, so the
            // code inside doesn't run.
            /*
            if (s < 0 && s > 100) {
                if (s < 0)
                    s = 0;
                if (s > 100)
                    s = 100;
            }
            */

            // Fix it by performing the two checks separately so that any value
            // outside [0, 100] is correct.
            if (s < 0) {
                s = 0;
            } else if (s > 100) {
                s = 100;
            }

            // Track min/max
            if (s < min)
                min = s;
            if (s > max)
                max = s;

            // add up the total.
            total += s;
        }

        // (total / COUNT) uses integer division first, losing the fractional
        // part before casting to double.
        // double avg = (double) (total / COUNT);

        // Fix it by casting total to double before dividing to get an average.
        double avg = (double) total / COUNT;

        // Did the student pass?
        boolean passed = false;

        // The stray semicolon after the if ends the if-statement immediately.
        // The block below then always runs, so passed is always true.
        /*
        if (avg >= 60)
            ;
        {
            passed = true;
        }
        */

        // Fix it by removing the stray semicolon and using an if/else.
        if (avg >= 60) {
            passed = true;
        } else {
            passed = false;
        }

        // Assign letter grade
        char letter = 'F';
        if (avg >= 90) {
            letter = 'A';
        } else if (avg >= 80) {
            letter = 'B';
        } else if (avg >= 70) {
            letter = 'C';
        } else if (avg >= 60) {
            letter = 'D';
        } else {
            letter = 'F';
        }

        // print summary
        System.out.println("\n----- Report -----");
        System.out.println("Name: " + name);
        System.out.println("Highest single score recorded: " + max);
        System.out.println("Lowest single score recorded: " + min);
        System.out.println("Passed? " + passed);
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Letter grade: " + letter);

        // close the Scanner object before exiting.
        in.close();
    }
}