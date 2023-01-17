import org.jetbrains.annotations.NotNull;

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
        System.out.println("Press 11 for conversion from base 16 to base 8");
        System.out.println("Press 12 for conversion from base 16 to base 10:");
        System.out.println("Press 0 to QUIT");
    }

    private static void askNumber(final String base, final String newBase)
    {
        System.out.printf("Please enter the %s number to convert to %s", base, newBase);
    }

    // Modify the Extended Euclidean Algorithm to convert base 10 to new base
    // this will make the number backwards in a string and flip it at the end

    private static String stringBackwards(final @NotNull String digits)
    {
        //The formula puts the string together backwards so must reverse it.
        String finalDigits = "";
        for (int i = digits.length()-1; i > -1; i--){
            finalDigits = finalDigits + digits.charAt(i);
        }
        return finalDigits;
    }
    private static String convertedNumber(final int number, final int changeBase)
    {


        //Division algorithm a = bq + r
        String remainder1 = "";
        String finalNumber;
        int newNumber = number; //a
        //b is the base based in
        int quotient= newNumber / changeBase; //q

        int remainder = newNumber % changeBase;// r and the bit to add to new number
        if (remainder > 9) //checks to see if it is a hex number
        {
            remainder1 = hexTable(remainder);
            finalNumber = remainder1; //hex numbers after 9 are capital letters
        }
        else
           finalNumber = remainder + ""; // if it is not just add the r as the bit.

        int flag = 0;
        System.out.printf("%d = (%d)(%d) + %s //%s\n", newNumber,changeBase,quotient, (remainder > 9) ? remainder1 : remainder, (quotient == 0) ? "Final number" : "LSB");
        while (quotient != 0) //When quotient of the division algorithm reaches 0 then the final number is complete.
        {
            flag = 1;
            newNumber = quotient;
            quotient = newNumber / changeBase;
            remainder = newNumber % changeBase;
            if (remainder > 9)
            {
                remainder1 = hexTable(remainder);
                finalNumber = finalNumber + remainder1;
            }
            else
                finalNumber = finalNumber + remainder;

            System.out.printf("%d = (%d)(%d) + %s //%s\n", newNumber,changeBase,quotient, remainder, (quotient == 0) ? "MSB" : "Middle Bit");

        }
        if (flag == 1)
            finalNumber = stringBackwards(finalNumber);
        return finalNumber;


    }

    private static String binaryTable(final String num, final int newBase)
    {
        switch (num)
        {
            case "0" ->
            {
                if (newBase == 16)
                    return "0000";
                return "000";
            }
            case "1" ->
            {
                if (newBase == 16)
                    return "0001";
                return "001";
            }
            case "2" ->
            {
                if (newBase == 16)
                    return "0010";
                return "010";
            }
            case "3" ->
            {
                if (newBase == 16)
                    return "0011";
                return "011";
            }
            case "4" ->
            {
                if (newBase == 16)
                    return "0100";
                return "100";
            }
            case "5" ->
            {
                if (newBase == 16)
                    return "0101";
                return "101";
            }
            case "6" ->
            {
                if (newBase == 16)
                    return "0110";
                return "110";
            }
            case "7" ->
            {
                if (newBase == 16)
                    return "0111";
                return "0111";
            }
            case "8" ->
            {
                return "1000";
            }
            case "9" ->
            {
                return "1001";
            }
            case "A" ->
            {
                return "1010";
            }
            case "B" ->
            {
                return "1011";
            }
            case "C" ->
            {
                return "1101";
            }
            case "D" ->
            {
                return "1100";
            }
            case "E" ->
            {
                return "1101";
            }
            case "F" ->
            {
                return "1111";
            }
        }
        return num;
    }
    private static String hexTable(final int num)
    {
        switch (num)
        {
            case 10 -> {return "A";}
            case 11 -> {return "B";}
            case 12 -> {return "C";}
            case 13 -> {return "D";}
            case 14 -> {return "E";}
            case 15 -> {return "F";}
        }
        return num + ""; //shouldn't reach this but let us shut the compiler up
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
    public static String conversionToBinary(final Scanner kb, final String newBase, final int prevBase, final String oldBase)
    {
        String finalNumber = "";
        askNumber(oldBase, newBase);
        String binaryNum = kb.nextLine();

        for (int i = 0; i < binaryNum.length(); i++)
            finalNumber += binaryTable(binaryNum.charAt(i) + "" , prevBase);

        System.out.printf("%s %s is %s in %s\n",binaryNum ,oldBase,finalNumber, newBase);

        return finalNumber;

    }



}
