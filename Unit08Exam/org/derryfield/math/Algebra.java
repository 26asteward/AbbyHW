package org.derryfield.math;

public class Algebra {
    /**
     * Calculate the harmonic mean of two positive values x and y.
     * Formula: H = 2xy / (x + y)
     *
     * @param x first positive value
     * @param y second positive value
     * @return harmonic mean of x and y
     * @throws IllegalArgumentException if x <= 0, y <= 0, or x + y == 0
     */
    public static double harmonicMean(double x, double y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("x and y must be positive values.");
        }
        if (x + y == 0) {
            throw new IllegalArgumentException("Sum of x and y must not be zero.");
        }

        return 2 * x * y / (x + y);
    }
}
