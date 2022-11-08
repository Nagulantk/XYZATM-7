package Controller.Verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerification implements InterfaceInputVerification{

        public boolean verifyName(String name)
        {
            String regex = "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?!=[@#$%^&+=])"
                    + "(?=\\S+$).{4,20}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(name);
            return m.matches();
        }

        public boolean verifyPanNumber(long panNumber)
        {
            String regex = "^\\d{14}$";
            String number=String.valueOf(panNumber);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(number);
            return m.matches();
        }
        public boolean verifyPassword(String password)
        {
            String regex = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(password);
            return m.matches();
        }



        public boolean verifyPhoneNumber(long phoneNumber)
        {
            String regex = "^\\d{10}$";
            String number=String.valueOf(phoneNumber);
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(number);
            return m.matches();
        }
    }

