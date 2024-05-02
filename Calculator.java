
//according to the given link (a  youtube video about writting a calculator on java)
//https://drive.google.com/file/d/1kBA3aRZ7mcHHuwh7Hsh5OvXBAWH7dl8x/view

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[9];
    JButton plusButton,minusButton,multiplyButton,divideButton;
    JButton decimalButton,equalButton,delButton,clrButton,negButton;
    JPanel panel;
    Font myFont = new Font("Arial",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButton[0] = plusButton;
        functionButton[1] = minusButton;
        functionButton[2] = multiplyButton;
        functionButton[3] = divideButton;
        functionButton[4] = decimalButton;
        functionButton[5] = equalButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;

        for(int i=0;i<9;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for (int i=0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.WHITE);

        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(plusButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(minusButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);
        panel.add(divideButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        Calculator calc = new Calculator ();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decimalButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==plusButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource()==minusButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource()==multiplyButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource()==divideButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()== equalButton){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton){
            textfield.setText("");
        }
        if(e.getSource()==delButton){
            String str = textfield.getText();
            textfield.setText("");
            for(int i=0;i<str.length()-1;i++){
                textfield.setText(textfield.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }

    }
}


