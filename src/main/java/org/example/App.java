package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 */
public class App {

    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;

    private double num1, num2, result;
    private char operator;

    public App() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(null);


        panel = new JPanel();
        panel.setBounds(10, 10, 260, 340);
        panel.setLayout(new GridLayout(5, 4));


        textField = new JTextField();
        textField.setBounds(10, 10, 260, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);


        numberButtons = new JButton[10];

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].addActionListener(new NumberButtonListener());
        }
        functionButtons = new JButton[6];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equalsButton;
        functionButtons[5] = clearButton;
        for (int i = 0; i < 6; i++) {
            functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            functionButtons[i].addActionListener(new FunctionButtonListener());
        }
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[0]);
        panel.add(clearButton);
        panel.add(equalsButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new App();


    }

    class NumberButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String ButtonText = ((JButton) e.getSource()).getText();

            textField.setText(textField.getText() + ButtonText);

        }
    }

    class FunctionButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String buttonText = ((JButton) e.getSource()).getText();

            switch (buttonText) {
                case "+":
                    num1 = Double.parseDouble(textField.getText());
                    operator = '+';
                    textField.setText("");
                    break;
                case "-":
                    num1 = Double.parseDouble(textField.getText());
                    operator = '-';
                    textField.setText("");
                    break;
                case "*":
                    num1 = Double.parseDouble(textField.getText());
                    operator = '*';
                    textField.setText("");
                    break;
                case "/":
                    num1 = Double.parseDouble(textField.getText());
                    operator = '/';
                    textField.setText("");
                    break;
                case "=":
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;

                    }
                    textField.setText(String.valueOf(result));
                    break;
                case "C":
                    textField.setText("");
                    break;
            }

        }
    }
}

