package Controller.Verification;

import Model.Accounts;
import Model.Enums;
import Model.Server;
import View.Verification.LongInputValidation;

public class DetailsVerification implements DataVerification {

    Server server=Server.getServer();
    public long verification(Enums.CardType cardType)
    {
        long cardNumber=LongInputValidation.longValidation("Card Number");

        long pin=LongInputValidation.longValidation("Pin");
        if(cardType== Enums.CardType.DEBITCARD) {
            for (Accounts list : server.getAccountList()) {
                if (list.getDebitCard().getCardNumber() == cardNumber && list.getDebitCard().getPin() == pin) {
                    return list.getAccountNumber();
                }
            }
        }
        else{
            for (Accounts list : server.getAccountList()) {
                try {
                    if (list.getCreditCard().getCardNumber() == cardNumber && list.getCreditCard().getPin() == pin) {
                        return list.getCreditCard().getCardNumber();
                    }
                } catch (NullPointerException e) {
                    System.out.println("No credit card available for you");
                    return 0;
                }
            }
        }
        return 0;

    }
}
