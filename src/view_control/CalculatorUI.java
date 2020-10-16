package view_control;

import util.Math.OPERATOR;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculatorUI extends JFrame {
	private final JLabel calcArea = new JLabel("");

	private boolean initialCalcAreaInputState;
	private enum STATE { INITIAL, SAVE1, SAVE2, CALC } // defines the structure of what the STATE enum is

	private STATE mathState;
	
	// calculator values
    private OPERATOR mathOp;
	private double arg1;
    private double arg2;
    private double calcAnswer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CalculatorUI frame = new CalculatorUI();
				frame.setVisible(true); // inherited from JFrame "magic method"
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	private void calculateAnswer()  // method to perform calculation
	{
	    calcAnswer = util.Math.calculateIt(arg1, mathOp, arg2);
		calcArea.setText(String.valueOf(calcAnswer));
	    arg1 = Double.parseDouble(calcArea.getText());
	    mathState = STATE.CALC;
		initialCalcAreaInputState = true;
	}
	
	private void updateCalcArea(String string) {
		if (initialCalcAreaInputState) {  // sets text to string on initial key typed
			calcArea.setText(string);
			initialCalcAreaInputState = false;
	    } else  {                         // concatenates string to end of text subsequent keys typed
			calcArea.setText(calcArea.getText() + string);
	    }
	}
	
	/**
	 * Save values for Calculator.
	 */
	private void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
	    arg1 = Double.parseDouble((calcArea.getText()));
	    mathState = STATE.SAVE1;
		initialCalcAreaInputState = true;
	}
	
	private void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
		if (mathState != STATE.CALC) {
			arg2 = Double.parseDouble((calcArea.getText()));
			mathState = STATE.SAVE2;
		}
	}
	
	private void saveValueOfMathOp(OPERATOR op) { // method to store operator
		mathOp = op;
	}

	private void oneArgCalculate() {
		calculateAnswer();
	}
	
	private void clearCalculator() {  // helper method to clear and update calculator to default
		// calculator control
		String calcAreaDefault = "0.0";
		calcArea.setText(calcAreaDefault);
		mathState = STATE.INITIAL;
		initialCalcAreaInputState = true;
		arg1 = 0.0;
		arg2 = 0.0;
		calcAnswer = 0.0;
	}

	/**
	 * Create the frame.
	 */
	public CalculatorUI() { // constructor for main method, makes the buttons "alive"
		// sets up the frame
		getContentPane().setBackground(Color.decode("#4C4C4C"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 340); // -25
		int offset = 25;
		getContentPane().setLayout(null);
		calcArea.setForeground(Color.WHITE);
		calcArea.setBackground(Color.BLACK);
		calcArea.setFont(new Font("San Francisco", Font.PLAIN, 45));
		calcArea.setHorizontalAlignment(SwingConstants.RIGHT);
		calcArea.setBounds(18, 0, 377, 67);
		getContentPane().add(calcArea);
		
		JButton button_1 = new JButton("1"); // text displayed on button
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_1.setBackground(Color.decode("#9E9E9E"));
			} // change color to get an interaction
			@Override
			public void mouseReleased(MouseEvent e) {
				button_1.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_1.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_1.setBackground(Color.decode("#B4B4B4"));
		button_1.addActionListener(e -> updateCalcArea(button_1.getText()));
		button_1.setBounds(167, 192 + offset, 62, 50);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_2.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_2.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_2.addActionListener(e -> updateCalcArea(button_2.getText()));
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_2.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_2.setBackground(Color.decode("#B4B4B4"));
		button_2.setBounds(229, 192 + offset, 62, 50);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_3.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_3.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_3.addActionListener(e -> updateCalcArea(button_3.getText()));
		button_3.setOpaque(true);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_3.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_3.setBackground(Color.decode("#B4B4B4"));
		button_3.setBounds(291, 192 + offset, 62, 50);
		getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_4.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_4.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_4.addActionListener(e -> updateCalcArea(button_4.getText()));
		button_4.setOpaque(true);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_4.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_4.setBackground(Color.decode("#B4B4B4"));
		button_4.setBounds(167, 142 + offset, 62, 50);
		getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_5.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_5.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_5.addActionListener(e -> updateCalcArea(button_5.getText()));
		button_5.setOpaque(true);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_5.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_5.setBackground(Color.decode("#B4B4B4"));
		button_5.setBounds(229, 142 + offset, 62, 50);
		getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_6.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_6.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_6.addActionListener(e -> updateCalcArea(button_6.getText()));
		button_6.setOpaque(true);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_6.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_6.setBackground(Color.decode("#B4B4B4"));
		button_6.setBounds(291, 142 + offset, 62, 50);
		getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_7.setBackground(Color.decode("#9E9E9E"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_7.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_7.addActionListener(e -> updateCalcArea(button_7.getText()));
		button_7.setOpaque(true);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_7.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_7.setBackground(Color.decode("#B4B4B4"));
		button_7.setBounds(167, 92 + offset, 62, 50);
		getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_8.setBackground(Color.decode("#9E9E9E"));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button_8.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_8.addActionListener(e -> updateCalcArea(button_8.getText()));
		button_8.setOpaque(true);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_8.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_8.setBackground(Color.decode("#B4B4B4"));
		button_8.setBounds(229, 92 + offset, 62, 50);
		getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_9.setBackground(Color.decode("#9E9E9E"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_9.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_9.addActionListener(e -> updateCalcArea(button_9.getText()));
		button_9.setOpaque(true);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_9.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_9.setBackground(Color.decode("#B4B4B4"));
		button_9.setBounds(291, 92 + offset, 62, 50);
		getContentPane().add(button_9);
		
		JButton button_0 = new JButton("0");
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_0.setBackground(Color.decode("#9E9E9E"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_0.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_0.addActionListener(e -> updateCalcArea(button_0.getText()));
		button_0.setOpaque(true);
		button_0.setForeground(Color.WHITE);
		button_0.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_0.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_0.setBackground(Color.decode("#B4B4B4"));
		button_0.setBounds(167, 242 + offset, 124, 50);
		getContentPane().add(button_0);

		JButton button_divide = new JButton("÷");
		button_divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_divide.setBackground(Color.decode("#E8AC2D"));
			}

			public void mouseReleased(MouseEvent e) {
				button_divide.setBackground(Color.decode("#FFBD33"));
			}
		});
		button_divide.addActionListener(e -> { //
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.DIVIDE);
		});
		button_divide.setOpaque(true);
		button_divide.setForeground(Color.WHITE);
		button_divide.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_divide.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_divide.setBackground(Color.decode("#FFBD33"));
		button_divide.setBounds(353, 42 + offset, 62, 50);
		getContentPane().add(button_divide);

		JButton button_mult = new JButton("x");
		button_mult.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_mult.setBackground(Color.decode("#E8AC2D"));
			}

			public void mouseReleased(MouseEvent e) {
				button_mult.setBackground(Color.decode("#FFBD33"));
			}
		});
		button_mult.addActionListener(e -> { //
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.MULTIPLY);
		});
		button_mult.setOpaque(true);
		button_mult.setForeground(Color.WHITE);
		button_mult.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_mult.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_mult.setBackground(Color.decode("#FFBD33"));
		button_mult.setBounds(353, 92 + offset, 62, 50);
		getContentPane().add(button_mult);

		JButton button_decimal = new JButton(".");
		button_decimal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_decimal.setBackground(Color.decode("#9E9E9E"));
			}

			public void mouseReleased(MouseEvent e) {
				button_decimal.setBackground(Color.decode("#B4B4B4"));
			}
		});
		button_decimal.addActionListener(e -> { //
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.PLUS);
		});
		button_decimal.setOpaque(true);
		button_decimal.setForeground(Color.WHITE);
		button_decimal.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_decimal.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_decimal.setBackground(Color.decode("#B4B4B4"));
		button_decimal.setBounds(291, 242 + offset, 62, 50);
		getContentPane().add(button_decimal);

		JButton button_plus = new JButton("+");
		button_plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_plus.setBackground(Color.decode("#E8AC2D"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_plus.setBackground(Color.decode("#FFBD33"));
			}
		});
		button_plus.addActionListener(e -> { //
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.PLUS);
		});
		button_plus.setOpaque(true);
		button_plus.setForeground(Color.WHITE);
		button_plus.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_plus.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_plus.setBackground(Color.decode("#FFBD33"));
		button_plus.setBounds(353, 192 + offset, 62, 50);
		getContentPane().add(button_plus);
		
		JButton button_minus = new JButton("-");
		button_minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_minus.setBackground(Color.decode("#E8AC2D"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_minus.setBackground(Color.decode("#FFBD33"));
			}
		});
		button_minus.addActionListener(e -> {
			saveValueOfArg1();
			saveValueOfMathOp(OPERATOR.MINUS);
		});
		button_minus.setOpaque(true);
		button_minus.setForeground(Color.WHITE);
		button_minus.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_minus.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_minus.setBackground(Color.decode("#FFBD33"));
		button_minus.setBounds(353, 142 + offset, 62, 50);
		getContentPane().add(button_minus);


		JButton button_equals = new JButton("=");
		button_equals.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_equals.setBackground(Color.decode("#E8AC2D"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_equals.setBackground(Color.decode("#FFBD33"));
			}
		});
		button_equals.addActionListener(e -> {
			saveValueOfArg2();
			calculateAnswer();
		});
		button_equals.setOpaque(true);
		button_equals.setForeground(Color.WHITE);
		button_equals.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_equals.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_equals.setBackground(Color.decode("#FFBD33"));
		button_equals.setBounds(353, 242 + offset, 62, 50);
		getContentPane().add(button_equals);
		
		JButton button_clear = new JButton("AC");
		button_clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				button_clear.setBackground(Color.decode("#878787"));
			}
			
			public void mouseReleased(MouseEvent e) {
				button_clear.setBackground(Color.decode("#787777"));
			}
		});
		button_clear.addActionListener(e -> clearCalculator());
		button_clear.setOpaque(true);
		button_clear.setForeground(Color.WHITE);
		button_clear.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		button_clear.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		button_clear.setBackground(Color.decode("#787777"));
		button_clear.setBounds(167, 42 + offset, 62, 50);
		getContentPane().add(button_clear);
		
		JLabel label_title = new JLabel("PEGG, HAYES");
		label_title.setBounds(6, 6, 134, 16);
		label_title.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		label_title.setForeground(Color.WHITE);

		getContentPane().add(label_title);

	}
}






	
