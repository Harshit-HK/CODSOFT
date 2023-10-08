/*

* Student Grade Calculator
 */


package desktop_app.Marks_Student_Grade_Calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Calc extends JFrame implements ActionListener {

    // Global Variables
    JTextField subTxtBox, mkTxtBox;
    JLabel sbTxt, mk;
    JButton enSub, stAg;
    static int marks = 0;
    static int totalSub = 0;
    int per;
    String grd = "";

    // Constructor
    Calc(){

        super.setTitle("Total & Percentage");
        super.setBounds(450, 100, 600, 500);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().setBackground(new Color(255, 252, 246));
        super.setLayout(null);


        //Enter Subject Text
        sbTxt = new JLabel("Enter Subject");
        sbTxt.setBounds(100, 100, 150, 25);
        sbTxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(sbTxt);

        //Text Box for Subject
        subTxtBox = new JTextField();
        subTxtBox.setBounds(90, 150, 150, 30);
        subTxtBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        subTxtBox.setHorizontalAlignment(JTextField.CENTER);
        add(subTxtBox);

        //Enter Marks Text
        mk = new JLabel("Enter Marks");
        mk.setBounds(340, 100, 150, 25);
        mk.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(mk);

        //Text Box
        mkTxtBox = new JTextField();
        mkTxtBox.setBounds(320, 150, 150, 30);
        mkTxtBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mkTxtBox.setHorizontalAlignment(JTextField.CENTER);

        //Allow only Numerics
        mkTxtBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();  // save input into variable

                if ((c < '0' || '9' < c) && c != '\b'){
                    e.consume(); // if we type something that is not from 0 to 9 or backspace, we just block it from 'entering'
                }
            }
        });
        add(mkTxtBox);

        //Enter Subject Button
        enSub = new JButton("Next Subject");
        enSub.setBounds(90, 350, 150, 25);
        enSub.setFont(new Font("Times New Roman", Font.BOLD, 20));
        enSub.addActionListener(this);
        add(enSub);

        // Start Again
        stAg = new JButton("Start Again");
        stAg.setBounds(320, 350, 150, 25);
        stAg.setFont(new Font("Times New Roman", Font.BOLD, 20));
        stAg.addActionListener(this);
        add(stAg);

        super.setVisible(true);
    }

    //Action Button
    public void actionPerformed(ActionEvent ae){

        // Next Subject Action
        if (ae.getSource() == enSub) {
            // If Blank Enter
            if (Objects.equals(subTxtBox.getText(), "") || Objects.equals(mkTxtBox.getText(), "")) {
                JOptionPane.showMessageDialog(null, "Missing Subject or Marks");
            } else if ((Integer.parseInt(mkTxtBox.getText())) > 100) {
                JOptionPane.showMessageDialog(null, "Marks between 0-100");
            } else {
                String s = subTxtBox.getText();
                marks += Integer.parseInt(mkTxtBox.getText());
                totalSub++;
                per = marks / totalSub;
                grade(per);
                repaint();
                subTxtBox.setText("");
                mkTxtBox.setText("");
            }
            // Start Again Action
        }else {
            marks = 0;
            per = 0;
            totalSub = 0;
            grd = "";
            repaint();
            subTxtBox.setText("");
            mkTxtBox.setText("");
        }
    }

    // Grade
    public String grade(int per){
        if(90 <= per && per <= 100){
            grd = "A+";
        } else if (80 <= per && per <= 89) {
            grd = "A";
        } else if (70 <= per && per <= 79) {
            grd = "B+";
        } else if (60 <= per && per <= 69) {
            grd = "B";
        } else if (50 <= per && per <= 59) {
            grd = "C";
        } else if (40 <= per && per <= 49) {
            grd = "E";
        } else if ( 0<= per && per <= 39) {
            grd = "F";
        }
        return grd;
    }

    // Changeable Graphics
    public void paint(Graphics g){

        super.paint(g);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));

        String t = "Total: " + marks;
        g.drawString(t, 120, 280);

        String p = "Percentage: " + per + "%";
        g.drawString(p, 340, 280);

        String gd = "Grade: "+ grd;
        g.drawString(gd, 245, 80);
    }
}


