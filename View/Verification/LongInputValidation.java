package View.Verification;

import java.util.Scanner;
public class LongInputValidation {

    private LongInputValidation(){}
    public static long longValidation(String name) {
        Scanner input=new Scanner(System.in);
        long value=0;
        boolean number=true;
        do
        {System.out.println("Enter the "+name);
            if(input.hasNextLong())
            {
               value=input.nextLong();
                number=false;
            }
            else
            {
                System.out.println("Enter the valid "+name);
                input.next();
            }
        }while(number);
        return value;
    }
}
