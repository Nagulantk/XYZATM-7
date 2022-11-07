package Controller.Banking;
import Controller.GeneratingNumbers;
import Model.*;
import View.Display.*;
import View.Generation.AccountGeneration;
import View.Generation.BankAccountGeneration;
import View.Menu.BankDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.BankInputProcess;
import View.MenuInputProcess.EnumInputProcess;
import View.MenuInputProcess.Process;
import Controller.Verification.AccountFinding;

import java.time.LocalDate;
import java.util.HashMap;


public class NetBanking {

BankAccountGeneration accountGeneration=new AccountGeneration();
    private NetBanking(){}
    private static NetBanking bank=new NetBanking();
    EnumInputProcess inputProcess=new EnumInputProcess();
    Process process=new BankInputProcess();
    public void bankWorking() {
        Enums.BankAction bankAction;


        Server server = Server.getServer();

        GeneratingNumbers generatingNumbers = GeneratingNumbers.getGenerateNumbers();
        boolean conditon = true;
        while (conditon) {
            System.out.println("***************************************************************");
            DisplayMenu displayMenu = new BankDisplayMenu();
            displayMenu.displayMenu();
            System.out.println("***************************************************************");
            bankAction = (Enums.BankAction) inputProcess.inputProcess(process);
            switch (bankAction) {
                case ACCOUNTGENERATION:
                   HashMap<String,Object> detailsList = accountGeneration.accountGeneration();
                    AccountDetailsDisplay accountDetails = new AccountDetailsDisplay();
                    Customer customer = new Customer((String) detailsList.get("name"), (long) detailsList.get("panNumber"), (LocalDate) detailsList.get("dateOfBirth"), (long) detailsList.get("phoneNumber"));
                    Accounts accounts = new Accounts((long) detailsList.get("balance"), generatingNumbers.getGeneratingAccountNumber(), (String) detailsList.get("password"), customer);
                    accountDetails.printDetails(accounts);
                    server.setAccountList(accounts);
                    break;
                case CREDITCARDGENERATION:
                    AccountFinding finding = new AccountFinding();
                    Accounts account = finding.findingAccount();
                    if (account != null) {
                        CreditCard creditCard = account.setCreditCard(account);
                        CreditCardDetails creditCardDetailsDisplay = new CreditCardDetailsDisplay();
                        creditCardDetailsDisplay.displayDetails(creditCard);
                    }
                    break;
                case CREDITCARDPAYMENT:
                    CreditCardBillPayment bill = new CreditCardBillPayment();
                    Accounts accounts1 = bill.billPayment();
                    BalanceDisplay displayBalance = new DisplayBalance();
                    displayBalance.balanceDisplay(accounts1);
                    break;
                case GETCUSTOMERDETAILS:
                    CustomerDetails customerDetails = new CustomerDetailsDisplay();
                    customerDetails.getDetails();
                    break;
                case EXIT:
                    conditon = false;
            }
        }
    }
    public static NetBanking getBank()
    {
        return bank;
    }

}
