package Entity;

public final class EarningsRecord {
    public final String symbol, period;
    public final int year, quarter;
    public final double estimate, actual, surprise, surprisePercent;

    public EarningsRecord(String symbol, String period, int year, int quarter, double estimate, double actual, double surprise, double surprisePercent) {
        this.symbol = symbol;
        this.period = period;
        this.year = year;
        this.quarter = quarter;
        this.estimate = estimate;
        this.actual = actual;
        this.surprise = surprise;
        this.surprisePercent = surprisePercent;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPeriod() {
        return period;
    }

    public int getYear() {
            return year;
    }
    public int getQuarter() {
        return quarter;
    }

    public double getEstimate() {
        return estimate;
    }

    public double getActual() {
        return actual;
    }

    public double getSurprise() {
        return surprise;
    }

    public double getSurprisePercent() {
        return surprisePercent;
    }
}
