package View.Generation;

import View.Verification.DateVerification;
import View.Verification.LongInputValidation;
import View.Verification.VerifyDate;

import java.time.*;
import java.util.*;
public class AccountGeneration implements BankAccountGeneration {
    Scanner input=new Scanner(System.in);

    DateVerification dateVerification=new VerifyDate();
    public HashMap<String, Object> accountGeneration()
    {   System.out.println("Enter Name:");
        String name=input.nextLine();
        long phoneNumber=LongInputValidation.longValidation("Phone number");
        LocalDate dateOfBirth=dateVerification.verifyDate();

        System.out.println(dateOfBirth);

        long panNumber=LongInputValidation.longValidation("Pan card Number");
        long balance=LongInputValidation.longValidation("Balance");

       String newPassword;
       String password;
        do {
            System.out.println("Enter password");
            password = input.nextLine();
            System.out.println("ReEnter password");
           newPassword = input.nextLine();
            if(!password.equals(newPassword))
            {
                System.out.println("Reentered password is not same as password");
            }
        }while(!password.equals(newPassword));
      HashMap<String,Object> detailsList=new HashMap<>();
      detailsList.put("name",name);
        detailsList.put("phoneNumber",phoneNumber);
        detailsList.put("panNumber",panNumber);
        detailsList.put("password",password);
        detailsList.put("dateOfBirth",dateOfBirth);
        detailsList.put("balance",balance);

      return  detailsList;

    }

}


