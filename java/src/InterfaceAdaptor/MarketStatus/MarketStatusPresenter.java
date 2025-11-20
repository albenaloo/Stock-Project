package InterfaceAdaptor.MarketStatus;

import Usecase.MarketStatus.MarketStatusOutputBoundary;
import Usecase.MarketStatus.MarketStatusResponseModel;
import Entity.MarketStatus;

public class MarketStatusPresenter implements MarketStatusOutputBoundary {

    private final MarketStatusViewModel viewModel;

    public MarketStatusPresenter(MarketStatusViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(MarketStatusResponseModel responseModel) {
        MarketStatus status = responseModel.getMarketStatus();

        boolean open = status.isOpen();
        String session = status.getSession();
        String holiday = status.getHoliday();

        // Status message
        String text;
        if (open) {
            if (session != null && !session.isBlank()) {
                text = "US market is OPEN (" + session + ")";
            } else {
                text = "US market is OPEN";
            }
        } else {
            if (holiday != null && !holiday.isBlank()) {
                text = "US market is CLOSED (Holiday: " + holiday + ")";
            } else {
                text = "US market is CLOSED";
            }
        }

        viewModel.setStatusText(text);
        viewModel.setOpen(open);
        viewModel.setSession(session);
        viewModel.setHoliday(holiday);
        viewModel.setTimezone(status.getTimezone());
        viewModel.setErrorMessage(null);

        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.setStatusText("Market status unavailable");
        viewModel.setOpen(false);
        viewModel.setSession(null);
        viewModel.setHoliday(null);
        viewModel.setTimezone(null);
        viewModel.setErrorMessage(errorMessage);

        viewModel.firePropertyChanged();
    }
}
