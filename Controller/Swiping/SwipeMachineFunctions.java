package Controller.Swiping;
import Model.*;
import Controller.Verification.DataVerification;
import View.Verification.LongInputValidation;
import Controller.Verification.DetailsVerification;
public class SwipeMachineFunctions {
    DataVerification verify = new DetailsVerification();
    Accounts account;
    Server server=Server.getServer();

    public Accounts debitCardSwipe() {
        long accountNumber = verify.verification(Enums.CardType.DEBITCARD);
        if (accountNumber != 0) {

            long amount = LongInputValidation.longValidation("Purchase Amount");
            for(Accounts list:server.getAccountList()) {
                if (list.getAccountNumber() == accountNumber) {
                    account = list;
                }
            }
            if (amount <= account.getBalance()) {
                account.setBalance(account.getBalance()-amount+(long)(amount*0.01));
                System.out.println("purchase is successfully");
                System.out.println("Cashback:" + amount * 0.01);
               return  account;
            } else {
                System.out.println("Insufficient balance");
            }
        }
        return null;
    }
    public CreditCard creditCardSwiping()
    {
        long cardNumber= verify.verification(Enums.CardType.CREDITCARD);
        if(cardNumber!=0) {
            System.out.println("Enter the purchase amount(limit -100000):");
            long amount = LongInputValidation.longValidation("Amount");

            for(Accounts list:server.getAccountList())
            {
                if(list.getCreditCard().getCardNumber()==cardNumber)
                {
                    list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue()+amount-(int)(amount*0.01));
                    System.out.println("purchase is successfully");
                    System.out.println("Cashback:"+amount*0.01);
                    return list.getCreditCard();
                }
            }

        }
        return null;

    }
}
