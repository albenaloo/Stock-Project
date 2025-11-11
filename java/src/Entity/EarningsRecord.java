package Entity;

public final class EarningsRecord {
    public final String symbol, period;
    public final int year, quarter;
    public final double estimate, actual, surprise, surprisePercent;
    public EarningsRecord(String symbol, String period, int year, int quarter) {
        this.symbol = symbol;
        this.period = period;
        this.year = year;
        this.quarter = quarter;
        this.estimate = 0.0;
        this.actual = 0.0;
        this.surprise = 0.0;
        this.surprisePercent = 0.0;
    }
}
