/*Explain why the following program does not produce the output that some people would expect it to produce:
double a = 1.2; 
double b= 3.0;
double c = a * b; 
if(c == 3.6){
System.out.println("c is 3.6");
} else {
System.out.println("c is not 3.6");
}
Fix the program so it will produce the output that most people would expect it to produce.  Submit your corrected program for grading through MSA or GitHub.
 */
public class PartC {
    public static void main(String[] args) {
        double a = 1.2;
        double b = 3.0;
        double c = a * b;

        c = Math.round(c * 10.0) / 10.0;

        if (c == 3.6) {
            System.out.println("c is 3.6");
        } else {
            System.out.println("c is not 3.6");
        }
    }
}
