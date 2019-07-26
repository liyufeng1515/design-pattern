package cn.dwyane.designpattern.strategy;

public class StrategyTest {
    public static void main(String[] args){
        String exp1 ="2+8";
        String exp2 ="2-8";
        ICalculator iCalculatorPlus = new PlusCalculator();
        System.out.println(iCalculatorPlus.calculate(exp1));

        ICalculator iCalculatorMinus = new MinusCalculator();
        System.out.println(iCalculatorMinus.calculate(exp2));
    }
}
