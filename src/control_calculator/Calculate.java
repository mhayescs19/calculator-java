package control_calculator;

import util.Operation;
import util.Operation.OPERATOR;
import view_control.CalculatorUI;

public class Calculate {

    private boolean initialCalcAreaInputState;
    private enum STATE { INITIAL, SAVE1, SAVE2, CALC } // defines the structure of what the STATE enum is

    private STATE mathState;

    // calculator values
    private Operation.OPERATOR mathOp;
    private double arg1;
    private double arg2;
    private double calcAnswer;
    private String calcArea;

    public void getCalcArea(String currentDisplay) {
        calcArea = currentDisplay;
    }

    public String displayCalcArea() {
        return calcArea;
    }

    public void calculateAnswer()  // method to perform calculation
    {
        calcAnswer = util.Operation.calculateIt(arg1, mathOp, arg2);
        calcArea = String.valueOf(calcAnswer);
        arg1 = Double.parseDouble(calcArea);
        mathState = Calculate.STATE.CALC;
        initialCalcAreaInputState = true;
    }

    public void oneOpHelper() {
        arg2 = 0;
        calculateAnswer();
    }

    public void updateCalcArea(String input) {
        if (initialCalcAreaInputState) {  // sets text to string on initial key typed
            calcArea = input;
            initialCalcAreaInputState = false;
        } else  {                         // concatenates string to end of text subsequent keys typed
            calcArea = calcArea + input;
        }
    }

    /**
     * Save values for Calculator.
     */
    public void saveValueOfArg1() { // method to store 1st value in calculation (arg1)
        arg1 = Double.parseDouble(calcArea);
        mathState = Calculate.STATE.SAVE1;
        initialCalcAreaInputState = true;
    }

    public void saveValueOfArg2() { // method to store 2nd value in calculation (arg2)
        if (mathState != Calculate.STATE.CALC) {
            arg2 = Double.parseDouble(calcArea);
            mathState = Calculate.STATE.SAVE2;
        }
    }
}
