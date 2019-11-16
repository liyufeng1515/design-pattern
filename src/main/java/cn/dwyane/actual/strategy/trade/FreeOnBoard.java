package cn.dwyane.actual.strategy.trade;

import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-14 21:59
 * 起运港交货价
 * 产品吨价（EXW）+ FOB成本价（T）+ 佣金/柜重
 */
public class FreeOnBoard extends TradeOffers {
    private BigDecimal tonPrice;
    private BigDecimal fobPrice;
    private BigDecimal commission;
    private BigDecimal containerFee;
    public FreeOnBoard(BigDecimal tonPrice, BigDecimal fobPrice, BigDecimal commission, BigDecimal containerFee) {
        this.tonPrice = tonPrice == null?BigDecimal.ZERO:tonPrice;
        this.fobPrice = fobPrice == null?BigDecimal.ZERO:fobPrice;
        this.commission = commission == null?BigDecimal.ZERO:commission;
        this.containerFee = containerFee == null?BigDecimal.ONE:containerFee;
    }
    @Override
    BigDecimal calculate() {
        return tonPrice.add(fobPrice).add(commission.divide(containerFee,3,BigDecimal.ROUND_UP)).setScale(3,BigDecimal.ROUND_UP);
    }
}
