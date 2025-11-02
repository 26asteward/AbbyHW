import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Unit03Project {

    enum DayOfWeek {
        MON, TUE, WED, THU, FRI, SAT, SUN;

        static DayOfWeek parse(String input) {
            if (input == null) return null;
            String s = input.trim().toLowerCase(Locale.ROOT);
            switch (s) {
                case "monday": case "mon": case "m": return MON;
                case "tuesday": case "tue": case "tues": case "tu": return TUE;
                case "wednesday": case "wed": case "w": return WED;
                case "thursday": case "thu": case "thur": case "thurs": case "th": return THU;
                case "friday": case "fri": case "f": return FRI;
                case "saturday": case "sat": case "sa": return SAT;
                case "sunday": case "sun": case "su": return SUN;
                default: return null;
            }
        }

        boolean isWeekend() {
            return this == SAT || this == SUN;
        }

        boolean isWeekday() {
            return !isWeekend();
        }
    }

    enum CustomerType {
        BABY("BABY", 0),     
        CHILD("CHILD", 20),
        ADULT("ADULT", 0),
        SENIOR("SENIOR", 25);

        final String label;
        final int ageDiscountPercent;

        CustomerType(String label, int pct) {
            this.label = label;
            this.ageDiscountPercent = pct;
        }

        static CustomerType fromAge(int age) {
            if (age >= 0 && age <= 2) return BABY;
            if (age <= 12) return CHILD;
            if (age <= 59) return ADULT;
            return SENIOR;
        }
    }

    private static final BigDecimal HUNDRED = new BigDecimal("100");
    private static BigDecimal money(double v) { return BigDecimal.valueOf(v).setScale(2, RoundingMode.HALF_UP); }
    private static BigDecimal percent(BigDecimal base, int pct) {
        return base.multiply(BigDecimal.valueOf(pct)).divide(HUNDRED, 2, RoundingMode.HALF_UP);
    }

    private static boolean isRushHour(int hour, int minute) {
        return (hour >= 6 && hour <= 7) || (hour >= 16 && hour <= 17);
    }

    private static int[] parseTimeOrNull(String timeText) {
        if (timeText == null) return null;
        String t = timeText.trim();
        if (!t.contains(":")) return null;
        String[] parts = t.split(":", -1);
        if (parts.length != 2) return null;
        try {
            int hour = Integer.parseInt(parts[0].trim());
            int minute = Integer.parseInt(parts[1].trim());
            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) return null;
            return new int[]{hour, minute};
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    private static String padTime(int hour, int minute) {
        return String.format("%02d:%02d", hour, minute);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("name: ");
            String name = sc.nextLine();

            System.out.print("day: ");
            String dayInput = sc.nextLine();
            DayOfWeek day = DayOfWeek.parse(dayInput);
            if (day == null) {
                System.err.println("Error: Unknown day. Stopping program.");
                return;
            }

            System.out.print("time: ");
            String timeInput = sc.nextLine();
            int[] hm = parseTimeOrNull(timeInput);
            if (hm == null) {
                System.err.println("Error: Time must be in HH:MM (24-hour) format. Stopping program.");
                return;
            }
            int hour = hm[0], minute = hm[1];

            System.out.print("age: ");
            String ageStr = sc.nextLine().trim();
            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age < 0) {
                    System.err.println("Error: Age must be >= 0. Stopping program.");
                    return;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Error: Age must be an integer. Stopping program.");
                return;
            }

            System.out.print("student (y/n)?: ");
            String studentText = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            boolean isStudent;
            if (studentText.equals("y") || studentText.equals("yes") || studentText.equals("true")) {
                isStudent = true;
            } else if (studentText.equals("n") || studentText.equals("no") || studentText.equals("false")) {
                isStudent = false;
            } else {
                System.err.println("Error: Student value must be y/n (or true/false). Stopping program.");
                return;
            }

            BigDecimal basePrice;
            String baseNote;
            if (day.isWeekend()) {
                basePrice = money(80.00);
                baseNote = "(WEEKEND FARE)";
            } else {
                if (isRushHour(hour, minute)) {
                    basePrice = money(100.00);
                    baseNote = "(RUSH HOUR FARE)";
                } else {
                    basePrice = money(90.00);
                    baseNote = "(OFF-PEAK FARE)";
                }
            }

            CustomerType type = CustomerType.fromAge(age);

            BigDecimal ageDiscount = BigDecimal.ZERO.setScale(2);
            BigDecimal studentDiscount = BigDecimal.ZERO.setScale(2);
            BigDecimal finalCost;

            if (type == CustomerType.BABY) {
                finalCost = BigDecimal.ZERO.setScale(2);
                ageDiscount = basePrice; 
            } else {
                ageDiscount = percent(basePrice, type.ageDiscountPercent);

                BigDecimal afterAge = basePrice.subtract(ageDiscount);

                if (isStudent) {
                    studentDiscount = percent(afterAge, 5);
                }

                finalCost = afterAge.subtract(studentDiscount);
            }

            String normalizedTime = padTime(hour, minute);
            DecimalFormat moneyFmt = new DecimalFormat("0.00");

            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.printf("Name:    %s%n", name);
            System.out.printf("Day:     %s%n", day.name());
            System.out.printf("Time:    %s%n", normalizedTime);
            System.out.println("------------------------------------------------------");

            System.out.printf("Base Price:         $%10s %s%n",
                    moneyFmt.format(basePrice), baseNote);
            System.out.printf("Age Discount:       $%10s (%s)%n",
                    moneyFmt.format(ageDiscount), type.label);

            BigDecimal studentLine = studentDiscount.signum() == 0 ? studentDiscount : studentDiscount.negate();
            System.out.printf("Student Discount:   $%10s%n",
                    moneyFmt.format(studentLine));

            System.out.println("------------------------------------------------------");
            System.out.printf("Final Cost:         $%10s%n",
                    moneyFmt.format(finalCost));
        }

        System.out.println("------------------------------------------------------");
    }
}
