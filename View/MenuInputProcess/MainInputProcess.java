package View.MenuInputProcess;
import Model.Enums;
import View.Menu.DisplayMenu;
import View.Menu.MainDisplayMenu;

import java.util.Scanner;
public class MainInputProcess implements Process {

    public  Enum getProcess() {
        Scanner input = new Scanner(System.in);
        Enums.Action action;
        String work = input.nextLine();
        work = work.toUpperCase();
        DisplayMenu displayMenu=new MainDisplayMenu();
        try {
                action = Enums.Action.valueOf(work);
                return action;
            } catch (Exception e) {

                System.out.println("Please enter valid process");
                displayMenu.displayMenu();
                return getProcess();

            }
    }
}
