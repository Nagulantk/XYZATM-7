package Controller.ATM;

import Model.Accounts;
import Model.CreditCard;

public interface InterfaceATMFunctions {
     Accounts getBalance();
     CreditCard creditCardDueBalance();
     Accounts debitCardWithdraw();
     CreditCard creditCardWithdraw();
     Accounts deposit();

}
