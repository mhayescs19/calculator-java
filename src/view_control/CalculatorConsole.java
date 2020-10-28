package view_control;
import control_calculator.Calculate;
import java.util.Scanner;
import util.Operation.OPERATOR;
import util.Operation;
public class CalculatorConsole {
    private Operation.OPERATOR mathOp;
   //private double arg1; // to be implemented in later
  // private double arg2; // to be implemented in later

  // private double awnser;
   private Calculate console;
   private String input;
    public CalculatorConsole()
    {
            console = new Calculate();
    }
   /* public void MathOpSetter(OPERATOR op)
    {
        this.mathOp = op;
    } not needed anymore
    */

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

    public void Evaluate()
    {
            this.console.calculateAnswer();
            System.out.println(console.getArg1() + mathOp.toString() +console.getArg1()+"="+ console.getterCalcArea());

    }

    public void ConsoleCalc()
    {
        boolean exit = false;
        System.out.println("entered Console Calc");
        while (!exit)
        {
            System.out.println("enter a number for arg1");
            Scanner input = new Scanner(System.in);
            double arg1 = input.nextDouble();
            System.out.println("enter a number for arg2");
            input = new Scanner(System.in);
            double arg2 = input.nextDouble();
            System.out.println("1 = plus");
            System.out.println("2 = minus");
            System.out.println("3 = multiplication");
            System.out.println("4 = Division");
            int op = input.nextInt();
            switch (op) {
                case 1 -> this.mathOp = OPERATOR.PLUS;
                case 2 -> this.mathOp = OPERATOR.MINUS;
                case 3 -> this.mathOp = OPERATOR.MULTIPLY;
                case 4 -> this.mathOp = OPERATOR.DIVIDE;
            }
            Arg1Setter(arg1);
            Arg2Setter(arg2);
            Evaluate();
            System.out.println("would you like to continue using console Y/N");
            String stringinput;
            stringinput = input.nextLine();
            switch (stringinput)
            {
                case "N":
                case "n":
                     exit = true; break;
                default: break;
            }


        }

    }


}
