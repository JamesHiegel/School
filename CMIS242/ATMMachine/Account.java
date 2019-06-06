package JamesHiegel;
//imports

import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/* 
* This class contains the Account constructor and methods that return the balance,
* make deposits and withdrawals.  It also tracks the number of withdrawals and
* increase the service charge if withdrawals exceed four.
*/
public class Account {

    //create and instantize variables
    private String acctType = "";
    private double acctBal = 0;
    private static int numWD = 0;//tracks number of withdrawals made
    private static double svcChg = 0.0;//no charge until numWD > 4

    public Account(String type, double bal) {//constructor
        acctType = type;
        acctBal = bal;
    }

    public String getBalance() {//returns a formatted string of the account balance
        DecimalFormat numForm = new DecimalFormat("$###,###,###.00");
        return ("Current Balance is " + String.valueOf(numForm.format(this.acctBal)));
    }

    public void deposit(double dep) {//add funds to account
        acctBal = acctBal + dep;
    }

    public void fourWD() {//increases svcChg if withdrawals are over 4
        if (numWD > 4) {
            svcChg = 1.5;
        } else {
            svcChg = 0.0;
        }
    }

    public void withdrawal(double wd) throws InsufficientFunds {
        fourWD();//check for service charge increase
        if (this.acctBal < (wd + svcChg)) {//check for insufficient funds
            throw new InsufficientFunds();
        } else {//execute the transaction
            this.acctBal = this.acctBal - (wd + svcChg);
            numWD++;//increment withdrawal counter
            //System.out.println(numWD);//for debugging
        }
    }
}
