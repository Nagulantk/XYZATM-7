package Controller.Banking;
import Controller.GeneratingNumbers;
import Model.Accounts;
import Model.Card;
import Model.CreditCard;
import Model.DebitCard;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CardGeneration {
    GeneratingNumbers generatingNumbers=GeneratingNumbers.getGenerateNumbers();
    Date date1=new Date();
    SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");

    public Card debitCardGeneration(long balance)
    {
        String d=dateForm.format(date1);
        LocalDate dateOf=LocalDate.parse(d);
        LocalDate expiryDate=dateOf.plusYears(5);
        String cardType;
        if(balance<100000)
        {
            cardType="Visa Classic";
        }
        else if(balance>=100000&&balance<1000000)
        {
            cardType="visa Gold";
        }
        else {
            cardType="Visa Platinum";
        }
        Card card=new DebitCard(generatingNumbers.getGeneratingDebitCardNumber(),generatingNumbers.getGeneratingPin(),generatingNumbers.getGeneratingCcv(),expiryDate,cardType);

        return card;
    }

    public CreditCard creditCardGeneration(Accounts accounts) {


        String d=dateForm.format(date1);
        LocalDate dateOf=LocalDate.parse(d);
        LocalDate expiryDate=dateOf.plusYears(5);
        String cardType;
        cardType = accounts.getDebitCard().getCardType();
        CreditCard card = new CreditCard(generatingNumbers.getGeneratingCreditCardNumber(), generatingNumbers.getGeneratingPin(),generatingNumbers.getGeneratingCcv(), expiryDate,cardType);

        return  card;

    }
}
