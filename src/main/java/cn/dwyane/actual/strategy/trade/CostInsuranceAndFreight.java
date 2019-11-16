package cn.dwyane.actual.strategy.trade;

import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-14 22:02
 * 含保险的目的港交货价
 * CFR/(1-保险费率*1.1）
 */
public class CostInsuranceAndFreight extends TradeOffers {
    private BigDecimal tonPrice;
    private BigDecimal fobPrice;
    private BigDecimal commission;
    private BigDecimal containerFee;
    private BigDecimal oceanFreight;
    private BigDecimal insurance;
    private BigDecimal exchangeRate;
    public CostInsuranceAndFreight(BigDecimal tonPrice, BigDecimal fobPrice, BigDecimal commission, BigDecimal containerFee, BigDecimal oceanFreight, BigDecimal exchangeRate, BigDecimal insurance) {
        this.tonPrice = tonPrice == null?BigDecimal.ZERO:tonPrice;
        this.fobPrice = fobPrice == null?BigDecimal.ZERO:fobPrice;
        this.commission = commission == null?BigDecimal.ZERO:commission;
        this.containerFee = containerFee == null?BigDecimal.ONE:containerFee;
        this.oceanFreight = oceanFreight == null?BigDecimal.ZERO:oceanFreight;
        this.exchangeRate = exchangeRate == null?BigDecimal.ONE:exchangeRate;
        this.insurance = insurance == null?BigDecimal.ZERO:insurance;
    }
    @Override
    BigDecimal calculate() {
        return tonPrice.add(fobPrice).add(commission.divide(containerFee,3,BigDecimal.ROUND_UP)).add(oceanFreight.multiply(exchangeRate).divide(containerFee,3,BigDecimal.ROUND_UP)).divide(BigDecimal.ONE.subtract(insurance.multiply(BigDecimal.valueOf(1.1))),3,BigDecimal.ROUND_UP).setScale(3,BigDecimal.ROUND_UP);
    }
}
