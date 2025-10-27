import java.util.Scanner;

public class Unit03Project {

    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    enum PassengerType {
        BABY, CHILD, ADULT, SENIOR
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("name: ");
            String name = scanner.nextLine();

            System.out.print("day: ");
            String dayInput = scanner.nextLine().toUpperCase();
            Day day;
            if(dayInput.startsWith("MON")) day = Day.MON;
            else if(dayInput.startsWith("TUE")) day = Day.TUE;
            else if(dayInput.startsWith("WED")) day = Day.WED;
            else if(dayInput.startsWith("THU")) day = Day.THU;
            else if(dayInput.startsWith("FRI")) day = Day.FRI;
            else if(dayInput.startsWith("SAT")) day = Day.SAT;
            else if(dayInput.startsWith("SUN")) day = Day.SUN;
            else {
                System.err.println("Error: Unknown day. Stopping program.");
                return;
            }

            System.out.print("time: ");
            String timeInput = scanner.nextLine();
            if(!timeInput.contains(":")) {
                System.err.println("Error: Time must be in HH:MM format. Stopping program.");
                return;
            }
            String[] parts = timeInput.split(":");
            int hour, minute;
            try {
                hour = Integer.parseInt(parts[0]);
                minute = Integer.parseInt(parts[1]);
            } catch(NumberFormatException e) {
                System.err.println("Error: Invalid time format. Stopping program.");
                return;
            }

            System.out.print("age: ");
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.err.println("Error: Age must be an integer. Stopping program.");
                return;
            }
            if(age < 0) {
                System.err.println("Error: Age must be >= 0. Stopping program.");
                return;
            }

            System.out.print("student (y/n)?: ");
            char studentInput = scanner.nextLine().toLowerCase().charAt(0);
            boolean isStudent = studentInput == 'y';

            PassengerType type;
            if(age <= 2) type = PassengerType.BABY;
            else if(age <= 12) type = PassengerType.CHILD;
            else if(age <= 59) type = PassengerType.ADULT;
            else type = PassengerType.SENIOR;

            double basePrice;
            if(age == 100) {
                basePrice = 666;
            } else if(day == Day.SAT || day == Day.SUN) {
                basePrice = 80;
            } else {
                if((hour >= 6 && hour <= 7) || (hour >= 16 && hour <= 17)) basePrice = 100;
                else basePrice = 90;
            }

            double ageDiscount = 0;
            if(age != 100) {
                switch(type) {
                    case BABY -> ageDiscount = basePrice;
                    case CHILD -> ageDiscount = basePrice * 0.20;
                    case ADULT -> ageDiscount = 0;
                    case SENIOR -> ageDiscount = basePrice * 0.25;
                }
            }

            double studentDiscount = 0;
            if(isStudent && age != 100 && type != PassengerType.BABY) {
                studentDiscount = (basePrice - ageDiscount) * 0.05;
            }

            double finalCost = basePrice - ageDiscount - studentDiscount;

            System.out.println("------------------------------------------------------");
            System.out.printf("Name:    %s\n", name);
            System.out.printf("Day:     %s\n", day);
            System.out.printf("Time:    %02d:%02d\n", hour, minute);
            System.out.println("------------------------------------------------------");

            String rushHourLabel = "";
            if(day != Day.SAT && day != Day.SUN && ((hour >= 6 && hour <= 7) || (hour >= 16 && hour <= 17))) {
                rushHourLabel = " (RUSH HOUR FARE)";
            }

            System.out.printf("Base Price:         $%8.2f%s\n", basePrice, rushHourLabel);
            System.out.printf("Age Discount:       $%8.2f (%s)\n", ageDiscount, type);
            System.out.printf("Student Discount:   $%8.2f\n", -studentDiscount);
            System.out.println("------------------------------------------------------");
            System.out.printf("Final Cost:         $%8.2f\n", finalCost);
        }

        System.out.println("------------------------------------------------------");
    }
}