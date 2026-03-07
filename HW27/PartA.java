// The LocalDate and LocalTime classes are contained in the java.time package.
// Parent package: java

import java.time.LocalDate;
import java.time.LocalTime;

public class PartA {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        
        System.out.println("Today's date is " + today);
        System.out.println("The time is " + currentTime);
    }
}
