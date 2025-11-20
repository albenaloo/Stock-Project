package Usecase.MarketStatus;

public class MarketStatusRequestModel {
    private final String exchange;

    public MarketStatusRequestModel(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }
}
