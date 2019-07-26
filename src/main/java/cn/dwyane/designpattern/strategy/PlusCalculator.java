package cn.dwyane.designpattern.strategy;

public class PlusCalculator extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] array = split(exp,"\\+");
        return array[0]+array[1];
    }
}
