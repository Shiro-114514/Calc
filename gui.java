import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {
     JTextArea text;
     JButton button_c;
     JButton button_ac;
    public static void main(String[] args){
        gui frame = new gui("Calculator on Java");
        frame.setVisible(true);
    }

   gui(String title){
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        text = new JTextArea();
        text.setEditable(false);
        panel.setLayout(null);

        //button 0 ~ 9
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        //button 演算子
        JButton button_a = new JButton("+");
        JButton button_m = new JButton("-");
        JButton button_s = new JButton("*");
        JButton button_d = new JButton("/");
        JButton button_r = new JButton("%");
        JButton button_e = new JButton("=");
        button_c = new JButton("C");
        button_ac = new JButton("AC");

        if(text.getSelectionStart() == 0){
             button_c.setEnabled(false);
             button_ac.setEnabled(false);
        }

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        button_a.addActionListener(this);
        button_m.addActionListener(this);
        button_s.addActionListener(this);
        button_d.addActionListener(this);
        button_r.addActionListener(this);
        button_e.addActionListener(this);
        button_c.addActionListener(this);
        button_ac.addActionListener(this);

        //座標設定
        text.setBounds(10,50,300,25);
        button1.setBounds(10,100,50,50);
        button2.setBounds(70,100,50,50);
        button3.setBounds(130,100,50,50);
        button4.setBounds(10,160,50,50);
        button5.setBounds(70,160,50,50);
        button6.setBounds(130,160,50,50);
        button7.setBounds(10,220,50,50);
        button8.setBounds(70,220,50,50);
        button9.setBounds(130,220,50,50);
        button0.setBounds(10,280,50,50);
        button_a.setBounds(200,160,50,50);
        button_m.setBounds(200,220,50,50);
        button_s.setBounds(260,160,50,50);
        button_d.setBounds(260,220,50,50);
        button_r.setBounds(200,280,50,50);
        button_e.setBounds(260,280,50,50);
        button_c.setBounds(200,100,50,50);
        button_ac.setBounds(260,100,50,50);

        panel.add(text);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button0);
        panel.add(button_a);
        panel.add(button_m);
        panel.add(button_s);
        panel.add(button_d);
        panel.add(button_r);
        panel.add(button_e);
        panel.add(button_c);
        panel.add(button_ac);

       Container contentPane = getContentPane();
       contentPane.add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
          text.setCaretPosition(text.getText().length());
          String str = e.getActionCommand();
          if(!str.equals("C")) {
               if(!str.equals("AC")){
                    text.append(str);
               }
               else {
                    text.setText("");
               }
          }
          else {
               text.replaceRange("",text.getSelectionEnd() - 1,text.getSelectionEnd() );
          }

          if(text.getSelectionStart() != 0){
               button_c.setEnabled(true);
               button_ac.setEnabled(true);
          }
          else {
               button_c.setEnabled(false);
               button_ac.setEnabled(false);
          }
    }
}
