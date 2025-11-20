package InterfaceAdaptor.MarketStatus;

import Usecase.MarketStatus.MarketStatusInputBoundary;

public class MarketStatusController {

    private final MarketStatusInputBoundary interactor;

    public MarketStatusController(MarketStatusInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void updateStatus() {
        interactor.execute();
    }
}
