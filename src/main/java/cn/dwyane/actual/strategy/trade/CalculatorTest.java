package cn.dwyane.actual.strategy.trade;

import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-15 10:32
 */
public class CalculatorTest {
    public static void main(String[] args){
        BigDecimal fobPrice = BigDecimal.valueOf(60.4167);
        BigDecimal tonPrice = BigDecimal.valueOf(2120.0000);
        BigDecimal containerFee = BigDecimal.valueOf(24);
        BigDecimal oceanFreight = BigDecimal.valueOf(700);
        BigDecimal exchangeRate = BigDecimal.valueOf(6.78);
        BigDecimal insurance = BigDecimal.valueOf(0.007);
        BigDecimal commission = BigDecimal.valueOf(0);

        BigDecimal result1 = TradeOffersCalculator.init("EXW").setTonPrice(tonPrice).calculate();
        BigDecimal result2 = TradeOffersCalculator.init("FOB").setTonPrice(tonPrice).setFobPrice(fobPrice).setContainerFee(containerFee).setOceanFreight(oceanFreight).setExchangeRate(exchangeRate).setInsurance(insurance).setCommission(commission).calculate();
        BigDecimal result3 = TradeOffersCalculator.init("CFR").setTonPrice(tonPrice).setFobPrice(fobPrice).setContainerFee(containerFee).setOceanFreight(oceanFreight).setExchangeRate(exchangeRate).setInsurance(insurance).setCommission(commission).calculate();
        BigDecimal result4 = TradeOffersCalculator.init("CIF").setTonPrice(tonPrice).setFobPrice(fobPrice).setContainerFee(containerFee).setOceanFreight(oceanFreight).setExchangeRate(exchangeRate).setInsurance(insurance).setCommission(commission).calculate();

        System.out.println("result1: "+result1);
        System.out.println("result2: "+result2);
        System.out.println("result3: "+result3);
        System.out.println("result4: "+result4);
    }

}
