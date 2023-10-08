// NUMBER GAME

package src.Number_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Random;

public class NumGame extends JFrame {

    int gsdNum;
    String Txt = "";
    int r = rndNumGen();
    int count = 10;
    JButton btn;

    NumGame() {

        System.out.println(r);

        // Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500, 50, 500, 600);
        setTitle(" GUESS NUMBER GAME");
        getContentPane().setBackground(new Color(254, 254, 150));
        setLayout(null);

        //  "Remaining chance: ";
        JLabel remCh = new JLabel("Remaining chance:");
        remCh.setBounds(130, 145, 200, 30);
        remCh.setForeground(new Color(77, 77, 77));
        remCh.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(remCh);

        // Heading
        JLabel heading = new JLabel("Guess The Number");
        heading.setBounds(130, 30, 300, 30);
        heading.setForeground(new Color(77, 77, 77));
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(heading);

        // Label Text of "Guess"
        JLabel txt = new JLabel("Guess the correct the generated number (1 - 100).");
        txt.setBounds(50, 350, 400, 20);
        txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(txt);

        // Text field for Guessed number
        JTextField tf = new JTextField();
        tf.setBounds(70, 400, 300, 30);
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        tf.setHorizontalAlignment(JTextField.CENTER);

        //Allow only Numerics
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();  // save input into variable

                if ((c < '0' || '9' < c) && c != '\b'){
                    e.consume(); // if we type something that is not from 0 to 9 or backspace, we just block it from 'entering'
                }
            }
        });
        add(tf);

        // Enter Button
        btn = new JButton("Enter");
        btn.setBounds(200, 450, 100, 30);
        btn.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Empty text field
                if (Objects.equals(tf.getText(), "")) {
                    JOptionPane.showMessageDialog(null, "Please Enter The Number");
                } else {
                    gsdNum = Integer.parseInt(tf.getText());
                    // Range 1-100
                    if (gsdNum < 1 || gsdNum > 100) {
                        JOptionPane.showMessageDialog(null, "Please Take The Number 1-100");
                    } else {
                        if (count > 1) {
                            Txt = checkGsdNum(gsdNum);
                            count--;
                        } else if (count == 1) {
                            new Score(0);
                            setVisible(false);
                        }
                        repaint();
                    }
                }
            }
        });
        add(btn);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        String ct = "" + count;
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));
        g.setColor(new Color(77, 77, 77));
        g.drawString(ct, 332, 200);
        g.drawString(Txt, 170, 250);
    }

    //  feedback on guesses
    public String checkGsdNum(int gN) {
        String s = "";
            if (r == gN) { // Correct Answer
                scorePanel();
            } else if (gN <= r - 15) {
                s = "Too low";
            } else if (r - 14 <= gN && gN <= r - 1) {
                s = "Close but low";
            } else if (r + 1 <= gN && gN <= r + 15) {
                s = "Close but high";
            } else if (r + 16 <= gN) {
                s = "Too high";
            }
        return s;
    }

    // Display Score Panel
    public void scorePanel(){
        setVisible(false);
        new Score(count * 10);
    }
    public int rndNumGen(){
        Random random = new Random();
        int r = random.nextInt(100) + 1;//  +1 (for start from 1)
    return r;

    }
//    public static void main(String[] args) {
//        new NumGame();
//    }
}
