package src.Quiz.Quiz_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Score extends JFrame implements ActionListener {

    JButton playAgain,exit;
    Score(String name, int score){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Top Image Quiz
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/Quiz/icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 200, 300, 250);
        add(img);

        // Questions number
        JLabel heading = new JLabel("Thank you " + name + " for playing Quiz Game");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tanpma", Font.PLAIN, 26));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel ldlscore = new JLabel("Your score is "+ score);
        ldlscore.setBounds(350, 200, 300, 30);
        ldlscore.setFont(new Font("Tanpma", Font.PLAIN, 26));
        add(ldlscore);

        // Play Again Button
        playAgain = new JButton("Play Again");
        playAgain.setBounds(350, 270, 120, 30);
        playAgain.setFont(new Font("Tahoma", Font.PLAIN, 16));
        playAgain.setBackground(new Color(30, 144, 255));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);

        add(playAgain);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBounds(500, 270, 120, 30);
        exit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        exit.setBackground(new Color(30, 144, 255));
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == playAgain){
            new Login();
            setVisible(false);
        } else {
            System.exit(34234);
        }
    }

    public static void main(String[] args) {
        new Score("HK", 0);
    }
}
