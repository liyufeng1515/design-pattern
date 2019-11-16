package cn.dwyane.actual.strategy.trade;

import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-14 21:58
 * 工厂交货价
 * 等于产品吨价
 */
public class ExWorks extends TradeOffers {
    private BigDecimal tonPrice;
    public ExWorks(BigDecimal tonPrice) {
        this.tonPrice = tonPrice == null?BigDecimal.ZERO:tonPrice;
    }
    @Override
    BigDecimal calculate() {
        return tonPrice;
    }
}
