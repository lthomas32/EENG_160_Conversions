import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        int choice;
        String number;
        System.out.println("Welcome!\n\n");
        do
        {
           EENG160Methods.printMenu();
           System.out.println("Please select a menu option: ");
           choice = Integer.parseInt(kb.nextLine());
           while (choice > 12 || choice < 0){
               System.out.println("Please enter a valid choice");
               choice = Integer.parseInt(kb.nextLine());
           }

           switch (choice){
               case 1 ->
               //conversion from base 10 - base 2
               {
                   number = EENG160Methods.base10Conversion(kb, "base 2", 2);

               }
               case 2 ->
               //conversion from base 10 - base 8
               {
                   number = EENG160Methods.base10Conversion(kb, "base 8", 8);
               }
               case 3 ->
               //conversion from base 10 - base 16
               {
                   number = EENG160Methods.base10Conversion(kb, "base 16", 16);
                   System.out.println("\n" + number);
               }
               case 4 ->
               //conversion from base 2 - base 8
               {
               }
               case 5 ->
               //conversion from base 2 - base 10
               {}
               case 6 ->
               //conversion from base 2 - base 16
               {
               }
               case 7 ->
               //conversion from base 8 - base 2
               {
                   number = EENG160Methods.conversionToBinary(kb, "base 2", 8, "base 8");
                   System.out.println("\n" + number);


               }
               case 8 ->
               //conversion from base 8 - base 10
               {}
               case 9 ->
               //conversion from base 8 - base 16
               {}
               case 10 ->
               //conversion from base 16 - base 2
               {
                   number = EENG160Methods.conversionToBinary(kb, "base 2", 16, "base 16" );
                   System.out.println("\n" + number);


               }
               case 11 ->
               //conversion from base 16 - base 8
               {}
               case 12 ->
               //conversion from base 16 - base 8
               {}
               case 0 ->
               // quit
               {}
           }



       } while (choice != 0);




    }
}