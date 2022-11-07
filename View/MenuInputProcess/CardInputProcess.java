package View.MenuInputProcess;


import Model.Enums;


import java.util.Scanner;

public class CardInputProcess implements Process {
    public  Enum getProcess()
    {
        Scanner input = new Scanner(System.in);
       Enums.CardType cardType;
        System.out.println(" Debit card or Credit card:");
        String work = input.nextLine();
        work = work.toUpperCase();
        try {
                cardType = Enums.CardType.valueOf(work);
                return cardType;
            } catch (Exception e) {

                System.out.println("Please enter valid process");
            System.out.println("Swipe using Debit card or Credit card:");
                return getProcess();
            }

    }
}
