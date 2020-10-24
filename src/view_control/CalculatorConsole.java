package view_control;
import control_calculator.Calculate;
import java.util.Scanner;
import util.Operation.OPERATOR;
import util.Operation;
public class CalculatorConsole {
    private Operation.OPERATOR mathOp;
   private double arg1; // to be implemented in later
   private double arg2; // to be implemented in later
   private OPERATOR operator;
   private double awnser;
   private Calculate console;
   private String input;
    public CalculatorConsole()
    {
            console = new Calculate();
    }
    public void MathOpSetter(OPERATOR op)
    {
        this.mathOp = op;
    }

    public  void Arg1Setter(double arg1)
    {
                input = String.valueOf(arg1);
                this.console.updateCalcArea(this.input);
                this.console.saveValueOfArg1();
    }
    public  void Arg2Setter(double arg2)
    {
        input = String.valueOf(arg2);
        this.console.updateCalcArea(this.input);
        this.console.saveValueOfArg2();
    }
    public  void OperatorSetter(OPERATOR op)
    {
        this.operator = op;
    }
    public void Evaluate()
    {
            this.console.calculateAnswer();
            System.out.println(this.arg2 + mathOp.toString() +this.arg2+"="+ console.getterCalcArea());

    }

}
