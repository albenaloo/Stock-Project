package Usecase.News;

public class NewsRequestModel {

    private final String symbol;   // null -> market news

    public NewsRequestModel() {
        this.symbol = null;
    }

    public NewsRequestModel(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}