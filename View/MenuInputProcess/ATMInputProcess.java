package View.MenuInputProcess;
import Model.Enums;
import View.Menu.ATMDisplayMenu;
import View.Menu.DisplayMenu;
import java.util.Scanner;
import java .lang.Enum;
public class ATMInputProcess implements Process {
    public Enum getProcess() {
        Scanner input=new Scanner(System.in);
        Enums.AtmActions atmAction;
        String work = input.nextLine();
        work = work.toUpperCase();
        DisplayMenu displayMenu = new ATMDisplayMenu();
        try {
            atmAction = Enums.AtmActions.valueOf(work);
            return atmAction;
        } catch (Exception e) {
            System.out.println("Please enter valid process");
            displayMenu.displayMenu();
            return getProcess();
        }
    }
}
