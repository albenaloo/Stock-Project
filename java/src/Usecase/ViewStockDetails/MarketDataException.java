package Usecase.ViewStockDetails;

public class MarketDataException extends Exception {
    public MarketDataException(String msg) { super(msg); }
    public MarketDataException(Throwable cause) { super(cause); }
}
