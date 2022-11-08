package Model;



public class Enums {
    public enum CardType{
        DEBITCARD,
        CREDITCARD,

    }
    public enum BankAction
    {
        ACCOUNTGENERATION,
        CREDITCARDGENERATION,
        CREDITCARDPAYMENT,
        GETCUSTOMERDETAILS,
        EXIT

    }
    public enum AtmActions
    {
        DEPOSIT,
        WITHDRAW,
        GETBALANCE,
        CREDITCARDDUE,
        EXIT
    }
    public  enum Action {
        BANKING,
        ATM,
        SWIPE,
        EXIT
    }

}
