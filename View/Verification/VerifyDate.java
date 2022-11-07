package View.Verification;

import java.time.LocalDate;
import java.util.Scanner;

public class VerifyDate implements DateVerification {
    public LocalDate verifyDate()
    {
        Scanner input=new Scanner(System.in);

        try {
            System.out.println("Enter DOB:YYYY-MM-DD");
            String date=input.nextLine();
            LocalDate Date=LocalDate.parse(date);
            return Date;
        }
        catch (Exception e)
        {
             System.out.println("Enter date based on the given format");
            return verifyDate();
        }
    }
}
