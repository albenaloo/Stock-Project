package Usecase.FilterSearch;

/**
 * The input data for the Filter Search Use Case.
 */
public class FilterSearchInputData {

    private final String exchange;
    private final String mic;
    private final String securityType;
    private final String currency;

    public FilterSearchInputData(String exchange, String mic, String securityType, String currency) {
        this.exchange = exchange;
        this.mic = mic;
        this.securityType = securityType;
        this.currency = currency;
    }

    String getExchange() { return exchange; }

    String getMic() {
        return mic;
    }

    String getSecurityType() { return securityType; }

    String getCurrency() {
        return currency;
    }

}
