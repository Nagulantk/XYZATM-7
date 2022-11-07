package Controller.Swiping;
import Model.Accounts;
import Model.CreditCard;
import Model.Enums;
import View.Display.BalanceDisplay;
import View.Display.CreditCardDetails;
import View.Display.CreditCardDetailsDisplay;
import View.Display.DisplayBalance;
import View.MenuInputProcess.CardInputProcess;
import View.MenuInputProcess.EnumInputProcess;
import View.MenuInputProcess.Process;

public class SwipeMachine {

   SwipeMachineFunctions swipe=new SwipeMachineFunctions();
   Process process=new CardInputProcess();
    EnumInputProcess inputProcess=new EnumInputProcess();

   public void swipeMachineWork()
   {
      Enums.CardType cardType;


       cardType= (Enums.CardType) inputProcess.inputProcess(process);
           switch (cardType) {
               case DEBITCARD:
                   Accounts accounts = swipe.debitCardSwipe();
                   BalanceDisplay displayBalance = new DisplayBalance();
                   displayBalance.balanceDisplay(accounts);
                   break;
               case CREDITCARD:
                   CreditCard creditCard = swipe.creditCardSwiping();
                   CreditCardDetails creditCardDueDisplay = new CreditCardDetailsDisplay();
                   creditCardDueDisplay.displayCreditCardDue(creditCard);
                   break;


       }
   }
}
