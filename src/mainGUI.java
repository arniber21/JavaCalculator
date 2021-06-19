import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGUI extends JFrame{
    private JTextField numberBox;
    private JButton nine;
    private JButton three;
    private JButton six;
    private JButton two;
    private JButton one;
    private JButton five;
    private JButton four;
    private JButton seven;
    private JButton eight;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;
    private JButton equals;
    private JPanel mainGUI;
    private JButton decimal;
    private JButton clear;
    private JButton negative;
    private JButton zero;
    private float num1;
    private boolean num1set;
    private boolean num2set;
    private float num2;
    private float answer;
    private String operator;
    public mainGUI(){
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainGUI);
        this.pack();
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "1");
            }
        });
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "2");
            }
        });
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "3");
            }
        });
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "4");
            }
        });
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "5");
            }
        });
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "6");
            }
        });
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "7");
            }
        });
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "8");
            }
        });
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "9");
            }
        });
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNum1(numberBox.getText());
                operator = "a";
            }
        });
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNum1(numberBox.getText());
                operator = "s";
            }
        });
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNum1(numberBox.getText());
                operator = "m";
            }
        });
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNum1(numberBox.getText());
                operator = "d";
            }
        });
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setNum2(numberBox.getText());
                compute();
            }
        });
        decimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + ".");
            }
        });
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText("");
            }
        });
        negative.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstChar = Character.toString(numberBox.getText().charAt(0));
                if(firstChar.equals("-")){
                    numberBox.setText(numberBox.getText().substring(1));
                }
                else{
                    numberBox.setText("-" + numberBox.getText());
                }
            }
        });
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberBox.setText(numberBox.getText() + "0");
            }
        });
    }
    public static void main(String[] args){
        JFrame window = new mainGUI();
        window.setVisible(true);
    }
    public void setNum1(String data){
        if(num1set && num2set){
            compute();
            return;
        }
        else if(num1set){
            setNum2(data);
        }
        else{
            num1 = Float.parseFloat(data);
            num1set = true;
        }
        numberBox.setText("");

    }
    public void setNum2(String data){
        if(!num1set){
            setNum1(data);
        }
        else if(num2set){
            compute();
            return;
        }
        else {
            num2 = Float.parseFloat(data);
            num2set = true;
        }
    }
    public void compute(){
        if(operator == "a"){
            answer = num1 + num2;
        }
        else if(operator == "s"){
            answer = num1 - num2;
        }
        else if(operator == "m"){
            answer = num1 * num2;
        }
        else{
            answer = num1/num2;
        }
        num1set = false;
        num2set = false;
        numberBox.setText(String.valueOf(answer));
    }

}
