package cn.dwyane.actual.strategy.trade;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-14 22:00
 * 目的港交货价
 * FOB价+海运费/柜重
 */
public class CostAndFreight extends TradeOffers {
    private BigDecimal tonPrice;
    private BigDecimal fobPrice;
    private BigDecimal commission;
    private BigDecimal containerFee;
    private BigDecimal oceanFreight;
    private BigDecimal exchangeRate;
    public CostAndFreight(BigDecimal tonPrice, BigDecimal fobPrice, BigDecimal commission, BigDecimal containerFee, BigDecimal oceanFreight, BigDecimal exchangeRate) {
        this.tonPrice = tonPrice == null?BigDecimal.ZERO:tonPrice;
        this.fobPrice = fobPrice == null?BigDecimal.ZERO:fobPrice;
        this.commission = commission == null?BigDecimal.ZERO:commission;
        this.containerFee = containerFee == null?BigDecimal.ONE:containerFee;
        this.oceanFreight = oceanFreight == null?BigDecimal.ZERO:oceanFreight;
        this.exchangeRate = exchangeRate == null?BigDecimal.ONE:exchangeRate;
    }
    @Override
    BigDecimal calculate() {
        return tonPrice.add(fobPrice).add(commission.divide(containerFee,3,BigDecimal.ROUND_UP)).add(oceanFreight.multiply(exchangeRate).divide(containerFee,3,BigDecimal.ROUND_UP)).setScale(3,BigDecimal.ROUND_UP);
    }
}
