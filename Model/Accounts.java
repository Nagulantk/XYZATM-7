package Model;

import Controller.Banking.CardGeneration;

public class Accounts {
    private final long accountNumber;
    private long balance;
    private Card debitCard;
    private CreditCard creditCard;
    private String password;
    private Customer customer;

   public Accounts(long balance, long accountNumber,String password, Customer customer)
    {

        this.balance=balance;
        this.accountNumber=accountNumber;
        CardGeneration cardGeneration=new CardGeneration();
       this.debitCard= cardGeneration.debitCardGeneration(balance);
       this.customer=customer;
       this.password=password;


    }
    public long getAccountNumber()
    {
        return accountNumber;
    }
    public long getBalance()
    {
        return balance;
    }
    public void setBalance(long balance)
    {
   this.balance=balance;
    }
    public Card getDebitCard() {
        return debitCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public CreditCard setCreditCard(Accounts accounts)
    {
       CardGeneration cardGeneration=new CardGeneration();
        this.creditCard=cardGeneration.creditCardGeneration(accounts);
        return creditCard;
    }
    public String getPassword() {
        return password;
    }



}




