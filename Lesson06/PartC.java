public class PartC {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter three strings: ");
        String str1 = scanner.next();
        String str2 = scanner.next();
        String str3 = scanner.next();
        scanner.close();

        String[] strings = {str1, str2, str3};
        java.util.Arrays.sort(strings);

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
