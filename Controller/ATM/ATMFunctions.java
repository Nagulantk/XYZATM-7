package Controller.ATM;
import Controller.Verification.DataVerification;
import Controller.Verification.DetailsVerification;
import Model.*;
import View.Verification.LongInputValidation;
public class ATMFunctions implements InterfaceATMFunctions{
    Server server=Server.getServer();
    DataVerification verify=new DetailsVerification() ;
    Accounts account;
    public Accounts deposit()
        {long accountNumber=  verify.verification(Enums.CardType.DEBITCARD);
            if(accountNumber!=0)
            {
                for(Accounts list:server.getAccountList()) {
                if (list.getAccountNumber() == accountNumber) {
                    account = list;
                }
              }
                long amount= LongInputValidation.longValidation("Amount");
              account.setBalance(account.getBalance()+amount);
                System.out.println("Amount is deposited successfully");
                return account;
            }
           return null;
        }

        public Accounts debitCardWithdraw()
        {
            float tax;
            long accountNumber= verify.verification(Enums.CardType.DEBITCARD );
            if(accountNumber!=0)
            {
                long amount=LongInputValidation.longValidation("Amount");
                for(Accounts list:server.getAccountList()) {
                    if (list.getAccountNumber() == accountNumber) {
                        account = list;
                    }
                }
                if(amount%5==0&&amount<= account.getBalance())


                {
                    if(amount<=100)
                    {
                        tax=0.02f;
                    }
                    else {
                        tax=0.04f;
                    }
                   account.setBalance(account.getBalance()-amount-(long)(amount*tax));
                    System.out.println("Amount is withdrawn successfully");
                    return account;
                }
                else
                {
                    System.out.println("Insufficient balance or Enter amount divisible by 5");
                    return account;
                }
            }

            return null;
        }
        public CreditCard creditCardWithdraw()
        {
            long cardNumber= verify.verification(Enums.CardType.CREDITCARD);
            if(cardNumber!=0) {
                long amount=LongInputValidation.longValidation("Withdrwa Amount(Limit-100000)");
                if(amount<=100000) {
                    for (Accounts list: server.getAccountList()) {
                        if (list.getCreditCard().getCardNumber() == cardNumber) {
                            if(amount<=100) {
                                list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.02));
                                System.out.println("Amount is withdrawn");
                                System.out.println("Tax:" + amount * 0.02);
                            }
                            else {
                                list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.04));
                                System.out.println("Amount is withdrawn");
                                System.out.println("Tax:" + amount * 0.04);
                            }
                            return  list.getCreditCard();

                        }
                    }
                }

            }
            return null;
        }
        public CreditCard creditCardDueBalance()
        {
            long cardNumber = verify.verification(Enums.CardType.CREDITCARD);
            if (cardNumber != 0)
            {
                for (Accounts list : server.getAccountList())
                {
                    if (list.getCreditCard().getCardNumber() == cardNumber)
                    {
                        return list.getCreditCard();
                    }
                }
            }
            return null;
        }


        public Accounts getBalance() {
            long accountNumber = verify.verification(Enums.CardType.DEBITCARD);
            if (accountNumber != 0) {
                for (Accounts list : server.getAccountList()) {
                    if (list.getAccountNumber() == accountNumber) {
                        account = list;
                    }
                }

            }
            return account;
        }
    }

