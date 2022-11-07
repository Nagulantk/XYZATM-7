package Controller.ATM;
import Model.Accounts;
import Model.CreditCard;
import Model.Enums;
import View.Display.BalanceDisplay;
import View.Display.CreditCardDetails;
import View.Display.CreditCardDetailsDisplay;
import View.Display.DisplayBalance;
import View.Menu.ATMDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.ATMInputProcess;
import View.MenuInputProcess.CardInputProcess;
import View.MenuInputProcess.EnumInputProcess;
import View.MenuInputProcess.Process;
public class XyzAtm {


  InterfaceATMFunctions atm=new ATMFunctions();
    Process cardInputProcess=new CardInputProcess();
    Process atmInputProcess=new ATMInputProcess();
    EnumInputProcess inputProcess=new EnumInputProcess();
   public void AtmWorking()
   {

       Enums.AtmActions action;

Enums.CardType card;
       Accounts account;
       BalanceDisplay displayBalance=new DisplayBalance();
       boolean condition=true;
       while(condition) {
           System.out.println("***************************************************************");
           DisplayMenu displayMenu=new ATMDisplayMenu();
           displayMenu.displayMenu();
           System.out.println("***************************************************************");
           action= (Enums.AtmActions) inputProcess.inputProcess(atmInputProcess);
           switch (action) {
               case DEPOSIT:
                   account = atm.deposit();
                   displayBalance.balanceDisplay(account);
                   break;
               case WITHDRAW:
                   Enums.CardType cardType;
                   cardType = (Enums.CardType) inputProcess.inputProcess(cardInputProcess);
                   switch (cardType) {
                       case DEBITCARD:
                           account = atm.debitCardWithdraw();
                           displayBalance.balanceDisplay(account);
                           break;
                       case CREDITCARD:
                           CreditCard creditCard = atm.creditCardWithdraw();
                           if (creditCard != null) {
                               CreditCardDetails creditCardDueDisplay = new CreditCardDetailsDisplay();
                               creditCardDueDisplay.displayCreditCardDue(creditCard);
                           }
                           break;
                   }
                   break;
               case GETBALANCE:
                   account = atm.getBalance();
                   displayBalance.balanceDisplay(account);

                   break;
               case CREDITCARDDUE:
                   CreditCard creditCard = atm.creditCardDueBalance();
                   CreditCardDetails creditCardDueDisplay = new CreditCardDetailsDisplay();
                   creditCardDueDisplay.displayCreditCardDue(creditCard);

                   break;

               case EXIT:
                   condition=false;

           }
       }

   }


}
