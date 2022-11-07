package View.Display;

import Model.Accounts;
import View.Display.BalanceDisplay;

public class DisplayBalance implements BalanceDisplay {
public void balanceDisplay(Accounts account)
{
    if(account!=null)
    {
        System.out.println("Balance:"+account.getBalance());
        }
    else
    {
        System.out.println("Enter valid details");
    }
}
}
