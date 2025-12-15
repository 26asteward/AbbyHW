import java.util.Scanner;

public class PartC
{
   public static boolean isVowel(char c)
   {
      c = Character.toLowerCase(c); 
      return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
   }

   public static int countVowels(String phrase)
   {
      int count = 0;
      for (int i = 0; i < phrase.length(); i++)
      {
         char ch = phrase.charAt(i);
         if (isVowel(ch))
         {
            count++;
         }
      }
      return count;
   }

   public static void main(String[] args)
   {
      try (Scanner in = new Scanner(System.in)) {
        System.out.print("Enter a phrase: ");
          String phrase = in.nextLine();

          int vowelCount = countVowels(phrase);

          System.out.println("The number of vowels in the phrase is: " + vowelCount);
      }
   }
}
