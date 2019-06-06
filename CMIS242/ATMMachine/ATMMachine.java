package JamesHiegel;
//imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/* 
* This program simulates an Automatic Teller Machine (ATM).  The user can check
* their account balances, withdraw money in $20 increments, make deposits and
* transfer funds between accounts.  Text entered is checked to ensure only
* positive numbers are processed.
*/
public class ATMMachine {

    static class ATMFrame extends JFrame {

        //create and initialize variables
        static final int WIDTH = 350, HEIGHT = 200;
        private static String acctType = "";
        private String acctBal = "";

        //create components
        protected JButton withdrawalBtn = new JButton("Withdrawal");
        protected JButton depositBtn = new JButton("Deposit");
        protected JButton transferBtn = new JButton("Transfer");
        protected JButton balanceBtn = new JButton("Balance");
        protected JRadioButton checkingBtn = new JRadioButton("Checking", true);
        protected JRadioButton savingsBtn = new JRadioButton("Savings");
        protected JTextField amountTxt = new JTextField("");

        public ATMFrame() {//default constructor
            //create frame
            super("ATM Machine");
            setSize(WIDTH, HEIGHT);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //create panel and use GridBagLayout
            JPanel topPanel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(5, 5, 5, 5);//5px internal margin
            //add components to panel
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridy = 0;//first row
            c.gridx = 0;//first column
            topPanel.add(withdrawalBtn, c);
            c.gridx = 1;//second column
            topPanel.add(depositBtn, c);
            c.gridy = 1;//second row
            c.gridx = 0;//first column
            topPanel.add(transferBtn, c);
            c.gridx = 1;//second column
            topPanel.add(balanceBtn, c);
            c.gridy = 2;//third row
            c.gridx = 0;//first column
            topPanel.add(checkingBtn, c);
            c.gridx = 1;//second column
            topPanel.add(savingsBtn, c);
            c.gridy = 3;//fourth row
            c.gridx = 0;//first column
            c.gridwidth = 2;//span two columns
            topPanel.add(amountTxt, c);

            //create group for radio buttons, ensures only one is selectable
            ButtonGroup radioBtns = new ButtonGroup();
            radioBtns.add(checkingBtn);
            radioBtns.add(savingsBtn);

            //add panel to frame
            add(topPanel, BorderLayout.NORTH);

            //create checking and savings accounts with starting balances
            Account checking = new Account("Checking", 100.25);
            Account savings = new Account("Savings", 200.50);

            //withdrawal button clicked
            withdrawalBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //amountTxt.setText("Withdrawal from " + acctType());//for testing
                    if (numCheck() && incCheck() == true) {//has to be a number and increment of 20
                        acctType();//updates acctType variable
                        try {
                            if (acctType.equals("Checking")) {
                                //converts text to double
                                checking.withdrawal(Double.parseDouble(amountTxt.getText()));
                                //passes text to messagePane method
                                messagePane("Please take your withdrawal.\n"
                                        + checking.getBalance(), acctType());

                            } else {
                                savings.withdrawal(Double.parseDouble(amountTxt.getText()));
                                messagePane("Please take your withdrawal.\n"
                                        + savings.getBalance(), acctType());
                            }
                        } catch (InsufficientFunds f) {//catches the thrown exception
                            messagePane("Insufficient Funds.", acctType());//alerts user
                        }
                    }
                }
            });
            //deposit button clicked
            //utilizes similar code to withdrawal
            depositBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //amountTxt.setText("Deposit to " + acctType());//for testing
                    if (numCheck() == true) {//only checks for valid numbers
                        acctType();//updates acctType variable
                        if (acctType.equals("Checking")) {
                            checking.deposit(Double.parseDouble(amountTxt.getText()));
                            messagePane("Thank you for your deposit.\n"
                                    + checking.getBalance(), acctType());
                        } else {
                            savings.deposit(Double.parseDouble(amountTxt.getText()));
                            messagePane("Thank you for your deposit.\n"
                                    + savings.getBalance(), acctType());
                        }
                    }
                }
            });
            //transfer button clicked
            /*
            * attempts a withdrawal from the non-selected account, if successful
            * it then performs a deposit into the selected account.
            */
            transferBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //amountTxt.setText("Transfer from " + acctType());//for testing
                    if (numCheck() == true) {
                        acctType();//updates acctType variable
                        try {
                            if (acctType.equals("Checking")) {
                                //attempts to process a withdrawal
                                savings.withdrawal(Double.parseDouble(amountTxt.getText()));
                                //then a deposit
                                checking.deposit(Double.parseDouble(amountTxt.getText()));
                                //informs user that transfer was successful
                                messagePane("Transfer Complete.\n"
                                        + "Checking: " + checking.getBalance()
                                        + "\nSavings: " + savings.getBalance(),
                                        "Account Transfer");
                            } else {
                                checking.withdrawal(Double.parseDouble(amountTxt.getText()));
                                savings.deposit(Double.parseDouble(amountTxt.getText()));
                                messagePane("Transfer Complete.\n"
                                        + "Checking: " + checking.getBalance()
                                        + "\nSavings: " + savings.getBalance(),
                                        "Account Transfer");
                            }
                        } catch (InsufficientFunds f) {
                            //catches exception if transfer amount is too large
                            messagePane("Insufficient Funds.", "Account Transfer");
                        }
                    }
                }
            });
            //balance button clicked
            balanceBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    acctType();//updates acctType variable
                    //displays balance for selected account
                    if (acctType.equals("Checking")) {
                        messagePane(checking.getBalance(), "Checking");
                    } else {
                        messagePane(savings.getBalance(), "Savings");
                    }
                }
            });
        }

        public void display() {//displays frame
            setVisible(true);
        }

        private String acctType() {//determines what account is selected
            if (checkingBtn.isSelected()) {
                acctType = "Checking";
            } else if (savingsBtn.isSelected()) {
                acctType = "Savings";
            }
            return acctType;
        }

        private boolean numCheck() {//checks for valid double in textbox
            try {
                Double.parseDouble(amountTxt.getText());
                //checks for positive number in textbox
                if (Double.parseDouble(amountTxt.getText()) > 0) {
                    return true;
                } else {
                    messagePane("Please use positive numbers.",
                            "Invalid Number Error");
                    return false;
                }
            } catch (NumberFormatException e) {//non double entries throw exemption
                messagePane("Please enter numbers only.",
                        "Invalid Number Error");
                return false;
            }
        }

        private boolean incCheck() {//checks for increments of 20
            try {
                if ((Double.parseDouble(amountTxt.getText())) % 20 == 0) {
                    return true;
                } else {
                    messagePane("Please enter increments of 20.",
                            "Invalid Increment Error");
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        private void messagePane(String msg, String title) {
            //reusable JOptionPane output
            JFrame msgFrame = new JFrame("Error");
            setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(msgFrame, msg, title,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {

        ATMFrame frame = new ATMFrame();//creates ATMFrame object
        frame.display();//displays created ATMFrame object
    }

}
