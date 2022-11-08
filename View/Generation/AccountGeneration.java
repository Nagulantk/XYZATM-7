package View.Generation;

import Controller.Verification.InputVerification;
import Controller.Verification.InterfaceInputVerification;
import View.Verification.DateVerification;
import View.Verification.LongInputValidation;
import View.Verification.VerifyDate;

import java.time.*;
import java.util.*;
public class AccountGeneration implements BankAccountGeneration {
    Scanner input=new Scanner(System.in);

    DateVerification dateVerification=new VerifyDate();
    InterfaceInputVerification inputVerification=new InputVerification();
    public HashMap<String, Object> accountGeneration()
    {
        boolean conditionOne=false;
     String name=null;
        while(!conditionOne)
        {    System.out.println("Enter Name:");
            System.out.println("Name must not contain space or numbers or special charaters and length must be greater than 4 and lesser than or equal to 20 ");
           name=input.nextLine();
            conditionOne=inputVerification.verifyName(name);
        }

        long phoneNumber=LongInputValidation.longValidation("Phone number");
        conditionOne=inputVerification.verifyPhoneNumber(phoneNumber);
        while(!conditionOne)
        {
            System.out.println("Phone number must be a 10 digit number");
            phoneNumber=LongInputValidation.longValidation("Phone number");
            conditionOne=inputVerification.verifyPhoneNumber(phoneNumber);
        }
        LocalDate dateOfBirth=dateVerification.verifyDate();

        System.out.println(dateOfBirth);

        long panNumber=LongInputValidation.longValidation("Pan card Number");
        conditionOne=inputVerification.verifyPanNumber(panNumber);
        while(!conditionOne)
        {
            System.out.println("Pan number must be a 14 digit number");
            panNumber=LongInputValidation.longValidation("Pan number");
            conditionOne=inputVerification.verifyPanNumber(panNumber);
        }
        long balance=LongInputValidation.longValidation("Balance");

       String newPassword=null;
       String password;

        do {
            System.out.println("Enter password");
            System.out.println("Password must contain one lowercase Alphabet ,one upper case alphabet ,one number,one special character and length of the password length must be greater than 8 and lesser than or equal to 20");
            password = input.nextLine();
            conditionOne=inputVerification.verifyPassword(password);
            if(!conditionOne)
            {
                System.out.println("Password must contain one lowercase Alphabet ,one upper case alphabet ,one number,one special character and length of the password length must be greater than 8 and lesser than or equal to 20");
                continue;
            }
            System.out.println("ReEnter password");

           newPassword = input.nextLine();
            if(!password.equals(newPassword))
            {
                System.out.println("Reentered password is not same as password");
            }
        }while(!password.equals(newPassword)||!conditionOne);
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


