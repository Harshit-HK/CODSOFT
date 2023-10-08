package src.Quiz.Quiz_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton next, exit;
    JTextField tfname;
    Login(){

        setTitle("Quiz Game");
        ImageIcon icon = new ImageIcon("src/Quiz/icons/game_icon.jpg");
        setIconImage(icon.getImage());
        // to take exit when click on cross (x close) button
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1200, 500);
        setLocation(200, 150);


        getContentPane().setBackground(Color.white);
        // to create personal Layout, set it null
        setLayout(null);

        //Images Insert
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/Quiz/icons/log.jpg"));
        JLabel image1 = new JLabel(i1);
        image1.setBounds(0, 0, 600,500);
        add(image1);

        //heading
        JLabel heading = new JLabel("Quiz Game");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        // Name
        JLabel name = new JLabel(" Enter your name");
        name.setBounds(810, 150, 300, 25);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        name.setForeground(new Color(30,144,254));
        add(name);

        //input Box
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        // Next Button
        next = new JButton("Next");
        next.setBounds(915, 270, 120, 25);
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(735, 270, 120, 25);
        exit.setBackground(new Color(30, 144, 254));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);

    }
    // Button Action
    public void actionPerformed(ActionEvent ae){

        // (Next Button Action) Next Template
        if (ae.getSource() == next){
            String name = tfname.getText();
            new Rules(name);
            setVisible(false);
        }

        // Exit from Game--
        else if (ae.getSource() == exit){
            System.exit(0);
        }
    }

//    public static void main(String[] args) {
//        new Login();
//    }

}
