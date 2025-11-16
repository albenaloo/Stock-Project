package Usecase.ViewStockDetails;

public class ViewStockInputData {
    final private String ticker;

    public ViewStockInputData(String ticker) {
        this.ticker = ticker;
    }

    String getTicker() {
        return ticker;
    }
}
