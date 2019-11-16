package cn.dwyane.actual.strategy.trade;

import java.math.BigDecimal;

/**
 * @Author : dwyane
 * @create 2019-11-14 22:06
 */
public class TradeOffersCalculator {
    private String tradeOffersType;
    private BigDecimal tonPrice;
    private BigDecimal fobPrice;
    private BigDecimal commission;
    private BigDecimal containerFee;
    private BigDecimal oceanFreight;
    private BigDecimal insurance;
    private BigDecimal exchangeRate;
    public TradeOffersCalculator(String tradeOffersType){
        this.tradeOffersType = tradeOffersType;
    }
    public static TradeOffersCalculator init(String tradeOffersType){
        return  new TradeOffersCalculator(tradeOffersType);
    }
    public BigDecimal calculate(){
        TradeOffers tradeOffers = null;
        switch (tradeOffersType){
            case "EXW":
                tradeOffers = new ExWorks(this.tonPrice);
                break;
            case "FOB":
                tradeOffers = new FreeOnBoard(this.tonPrice,this.fobPrice,this.commission,this.containerFee);
                break;
            case "CFR":
                tradeOffers = new CostAndFreight(this.tonPrice,this.fobPrice,this.commission,this.containerFee,this.oceanFreight,this.exchangeRate);
                break;
            case "CIF":
                tradeOffers = new CostInsuranceAndFreight(this.tonPrice,this.fobPrice,this.commission,this.containerFee,this.oceanFreight,this.exchangeRate,this.insurance);
                break;
            default:
                return BigDecimal.ZERO;
        }
        BigDecimal offer = tradeOffers.calculate();
        return offer;
    }
    public  TradeOffersCalculator setTonPrice(BigDecimal tonPrice) {
        this.tonPrice = tonPrice;
        return this;
    }
    public TradeOffersCalculator setFobPrice(BigDecimal fobPrice) {
        this.fobPrice = fobPrice;
        return this;
    }
    public TradeOffersCalculator setCommission(BigDecimal commission) {
        this.commission = commission;
        return this;
    }
    public TradeOffersCalculator setContainerFee(BigDecimal containerFee) {
        this.containerFee = containerFee;
        return this;
    }
    public TradeOffersCalculator setOceanFreight(BigDecimal oceanFreight) {
        this.oceanFreight = oceanFreight;
        return this;
    }
    public TradeOffersCalculator setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
        return this;
    }
    public TradeOffersCalculator setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }
}
