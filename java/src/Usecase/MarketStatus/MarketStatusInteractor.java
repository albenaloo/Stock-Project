package Usecase.MarketStatus;

import Entity.MarketStatus;

public class MarketStatusInteractor implements MarketStatusInputBoundary{
    private final MarketStatusDataAccessInterface dataAccess;
    private final MarketStatusOutputBoundary presenter;

    public MarketStatusInteractor(MarketStatusDataAccessInterface dataAccess,
                                  MarketStatusOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(MarketStatusRequestModel requestModel) {
        String exchange = requestModel.getExchange();
        if (exchange == null || exchange.isBlank()) {
            // default to US if nothing provided
            exchange = "US";
        }

        try {
            MarketStatus status = dataAccess.loadStatus(exchange);

            if (status == null) {
                presenter.prepareFailView("No market status available.");
                return;
            }

            MarketStatusResponseModel response = new MarketStatusResponseModel(status);
            presenter.prepareSuccessView(response);

        } catch (Exception e) {
            presenter.prepareFailView("Unable to load market status: " + e.getMessage());
        }
    }
}
