package desktop_app.ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


public class Atm extends JFrame implements ActionListener {

    JButton withdraw,deposit,check_balance;
    JTextField amount;
    JLabel balance;
    Account ac = new Account();
    Atm(){

        // JFrame
        super.setTitle("ATM Machine");
        super.setBounds(550, 100, 500, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().setBackground(new Color(221, 244, 255));
        super.setLayout(null);

        //ATM Heading
        JLabel heading = new JLabel("ATM");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 50));
        heading.setBounds(190, 20, 300, 50);
        add(heading);

        //Show Text
        balance = new JLabel("Enter Amount");
        balance.setBounds(150, 100, 200, 30);
        balance.setFont(new Font("Times New Roman", Font.BOLD, 30));

        add(balance);

        // Number Box
        amount = new JTextField();
        amount.setBounds(50, 140, 380, 40);
        amount.setFont(new Font("Times New Roman", Font.BOLD, 20));
        amount.addActionListener(this);
        amount.setHorizontalAlignment(JTextField.CENTER);
        add(amount);

        amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();  // save input into variable

                if ((c < '0' || '9' < c) && c != '\b'){
                    e.consume(); // if we type something that is not from 0 to 9 or backspace, we just block it from 'entering'
                }
                super.keyTyped(e);
            }
        });

        // Withdraw Button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(150, 300, 200, 30);
        withdraw.setFont(new Font("Times New Roman", Font.BOLD, 20));
        withdraw.addActionListener(this);
        add(withdraw);

        //Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 350, 200, 30);
        deposit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        deposit.addActionListener(this);
        add(deposit);

        //Check_Balance Button
        check_balance = new JButton("Check Balance");
        check_balance.setBounds(150, 400, 200, 30);
        check_balance.setFont(new Font("Times New Roman", Font.BOLD, 20));
        check_balance.addActionListener(this);
        add(check_balance);

        setVisible(true);
    }

    // Action On Button
    public void actionPerformed(ActionEvent ae){

        //Action on 'withdraw'
        if(ae.getSource() == withdraw){

            // When text field is empty
            if(Objects.equals(amount.getText(), "")) {
                JOptionPane.showMessageDialog(null, "please Enter Amount");

            } else {
                int amt = Integer.parseInt(amount.getText());
                // Limit of Amount
                if(amt > 8000){
                    JOptionPane.showMessageDialog(null, "Exceeds limit: 8000");
                }
                // Compare balance
                else if(ac.getBalance() >= amt){
                    withdraw(amt);
                    JOptionPane.showMessageDialog(null, "Withdrawal Amount " + amt);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                }
                // do empty text field
                amount.setText("");
            }
        }

        //Action on 'Deposit'
        else if(ae.getSource() == deposit){

            // When text field is empty
            if(Objects.equals(amount.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount");
            } else {
                int amt = Integer.parseInt(amount.getText());
                deposit(amt);
                JOptionPane.showMessageDialog(null, "Amount " + amt + " has been Deposited ");
            }
            amount.setText("");
        }

        //Action on 'Check Balance'
         else if(ae.getSource() == check_balance){
            int amt = check_balance();
            JOptionPane.showMessageDialog(null, "Current Balance: "+ amt);

        }
    }

    public void withdraw (int amount) {
        int balance = ac.getBalance();
        if (amount < balance) {
            ac.setBalance(ac.getBalance() - amount);
        }
    }
    public void deposit (int amount){
        ac.setBalance(ac.getBalance() + amount);
    }
    public int check_balance () {
        return ac.getBalance();
    }
    public static void main(String[] args) {
        new Atm();
    }

}
