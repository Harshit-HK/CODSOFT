package desktop_app.ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Pin extends JFrame implements ActionListener {

    JTextField pin;
    JLabel pinTxt, heading, balance;
    Pin(){

        super.setTitle("PIN Verification");
        super.setBounds(550, 100, 500, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().setBackground(new Color(221, 244, 255));
        super.setLayout(null);

        // PIN
        pinTxt = new JLabel("PIN:123");
        pinTxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pinTxt.setBounds(10, 10, 100, 20);
        add(pinTxt);

        // Heading
        heading = new JLabel("PIN Verification");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
        heading.setBounds(100, 30, 300, 50);
        add(heading);

        //Show Text
        balance = new JLabel("Enter PIN");
        balance.setBounds(150, 150, 200, 30);
        balance.setFont(new Font("Times New Roman", Font.BOLD, 30));

        add(balance);

        // Number Box
        pin = new JTextField();
        pin.setBounds(50, 200, 380, 40);
        pin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pin.setHorizontalAlignment(JTextField.CENTER);
        add(pin);

        pin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();  // save input into variable

                if ((c < '0' || '9' < c) && c != '\b'){
                    e.consume(); // if we type something that is not from 0 to 9 or backspace, we just block it from 'entering'
                }
            }
        });

        // Enter Button
        JButton Enter = new JButton("Enter");
        Enter.setBounds(150, 300, 200, 30);
        Enter.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Enter.addActionListener(this);
        add(Enter);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // When text field is empty
        if (Objects.equals(pin.getText(), "")) {
            JOptionPane.showMessageDialog(null, "Please Enter PIN");
        } else {
            int p = Integer.parseInt(pin.getText());
            if (p == 123) {
                new Atm();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect PIN");
            }
        }
    }
}
