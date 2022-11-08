package Controller;

import Controller.ATM.XyzAtm;
import Controller.Banking.NetBanking;
import Controller.Swiping.SwipeMachine;
import Model.Enums;
import View.Menu.DisplayMenu;
import View.Menu.MainDisplayMenu;
import View.MenuInputProcess.EnumInputProcess;
import View.MenuInputProcess.MainInputProcess;
import View.MenuInputProcess.Process;

public class MainMenu {

    public void mainWorking() {
        boolean condition = true;
        SwipeMachine machine = new SwipeMachine();
        EnumInputProcess inputProcess=new EnumInputProcess();
        Enums.Action action  ;
        while (condition) {
            System.out.println("***************************************************************");
            DisplayMenu displayMenu=new MainDisplayMenu();
            displayMenu.displayMenu();
            System.out.println("***************************************************************");
           Process process=new MainInputProcess();
            action= (Enums.Action) inputProcess.inputProcess(process);
            switch (action) {
                case ATM:
                    XyzAtm atm = new XyzAtm();
                    atm.AtmWorking();
                    break;
                case BANKING:
                    NetBanking bank = NetBanking.getBank();
                    bank.bankWorking();
                    break;
                case SWIPE:
                    machine.swipeMachineWork();
                    break;
                case EXIT:
                    condition = false;
                    System.out.println("Thank you");
                    break;
            }
        }
    }
}
