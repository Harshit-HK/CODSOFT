package src.Quiz.Quiz_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;
    Rules(String name){
        this.name = name;
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(800, 650);
        setLocation(350, 100);

        JLabel heading = new JLabel("Welcome "+ name + " to Quiz Game");
        heading.setBounds(50, 20, 700, 40);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel rule = new JLabel("Rules: ");
        rule.setBounds(30, 80, 700, 40);
        rule.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        rule.setForeground(new Color(30,144,254));
        add(rule);

        JLabel rules = new JLabel();
        rules.setBounds(30, 150, 700, 350);
        rules.setFont(new Font("Tahomal", Font.PLAIN, 16));
        rules.setText(
                "<html>"+
                        "1. You have only 15 Seconds to solve each question. " + "<br><br>" +
                        "2. Don't skip any question because it's impact on your score." + "<br><br>" +
                        "3. There are total 4 options, chose any one of them." + "<br><br>" +
                        "4. Result will be visible after submission." + "<br><br>" +
                        "5. All the questions are compulsory." + "<br><br>" +
                        "6. One life line will be given." + "<br><br>" +
                        "7. Life line can be used only once." + "<br><br>" +
                        " ---------------------Good Luck----------------" + "<br><br>" +
                "<html>"
        );
        add(rules);

        // Back Button
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        // Start Button
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else {
            new Login();
            super.dispose();
        }
    }
}
