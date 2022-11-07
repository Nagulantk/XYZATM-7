package View.MenuInputProcess;
import Model.Enums;
import View.Menu.BankDisplayMenu;
import View.Menu.DisplayMenu;


import java.util.Scanner;

public class BankInputProcess implements Process {
    public  Enum getProcess() {
        DisplayMenu displayMenu=new BankDisplayMenu();
        Scanner input = new Scanner(System.in);
        Enums.BankAction bankAction;
        String work = input.nextLine();
        work = work.toUpperCase();

        try {
            bankAction = Enums.BankAction.valueOf(work);
            return bankAction;
        }
        catch (Exception e) {
            System.out.println("Please enter valid process");
            displayMenu.displayMenu();
            return getProcess();
        }
    }
}
