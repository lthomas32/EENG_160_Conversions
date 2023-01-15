import java.util.*;
public class EENG160Methods
{
    public static void printMenu()
    {
        System.out.println("Press 1 for conversion from base 10 to base 2:");
        System.out.println("Press 2 for conversion from base 10 to base 8:");
        System.out.println("Press 3 for conversion from base 10 to base 16:");
        System.out.println("Press 4 for conversion from base 2 to base 8:");
        System.out.println("Press 5 for conversion from base 2 to base 10:");
        System.out.println("Press 6 for conversion from base 2 to base 16:");
        System.out.println("Press 7 for conversion from base 8 to base 2:");
        System.out.println("Press 8 for conversion from base 8 to base 10:");
        System.out.println("Press 9 for conversion from base 8 to base 16:");
        System.out.println("Press 10 for conversion from base 16 to base 2:");
        System.out.println("Press 11 for conversion from base 16 to base 3:");
        System.out.println("Press 12 for conversion from base 16 to base 4:");
        System.out.println("Press 0 to QUIT");
    }

    private static void askNumber(final String base, final String newBase)
    {
        System.out.printf("Please enter the %s number to convert to %s", base, newBase);
    }

    // Modify the Extended Euclidean Algorithm to convert base 10 to new base
    // this will make the number backwords in a string and flip it at the end

    private static String stringBackwards(final String digits)
    {
        String newDigits = digits;
        String finalDigits = "";
        for (int i = newDigits.length()-1; i > -1; i--){
            finalDigits = finalDigits + newDigits.charAt(i);
        }
        return finalDigits;
    }
    private static String convertedNumber(final int number, final int changeBase)
    {
        //Division algorithm a = bq + r
        int newNumber = number; //a
        //b is the base based in
        int quotient= newNumber / changeBase; //q

        int remainder = newNumber % changeBase;// r and the bit to add to new number
        String finalNumber = remainder+ "";


        int flag = 0;
        System.out.printf("%d = (%d)(%d) + %s //%s\n", newNumber,changeBase,quotient, remainder, (quotient == 0) ? "Final number" : "LSB");
        while (quotient != 0)
        {
            flag = 1;
            newNumber = quotient;
            quotient = newNumber / changeBase;
            remainder = newNumber % changeBase;
            finalNumber = finalNumber + remainder;

            System.out.printf("%d = (%d)(%d) + %s //%s\n", newNumber,changeBase,quotient, remainder, (quotient == 0) ? "MSB" : "Middle Bit");

        }
        if (flag == 1)
            finalNumber = stringBackwards(finalNumber);
        return finalNumber;


    }

    public static String base10Conversion(final Scanner kb, final String newBase, final int changeBase)
    {
        askNumber("base 10", newBase);
        double number = Double.parseDouble(kb.nextLine());
        int number1 = (int) number;
        String finalNumber = "";
        if ((double) number1 <= number)
        {
            finalNumber = convertedNumber(number1, changeBase);
        }
        System.out.printf("\n\nThe %f in base 10 is %s in %s!\n\n", number, finalNumber, newBase);
        return finalNumber;
    }




}
