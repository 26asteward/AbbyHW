public class PartB {
    
    public static void main(String[] args) {
        int[][] array1 = {
            {8, 6, 7},
            {5, 3, 0}
        };
        
        int[][] array2 = {
            {0, 7, 6, 5},
            {2, 2, 0, 1},
            {8, 4, 5, 7}
        };
        
        System.out.println("First array:");
        print(array1);
        
        System.out.println("\nSecond array:");
        print(array2);
    }
    
    public static void print(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                System.out.printf("%3d", values[i][j]);
                if (j < values[i].length - 1) {
                    System.out.print(",");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

