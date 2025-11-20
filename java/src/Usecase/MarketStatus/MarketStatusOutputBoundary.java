package Usecase.MarketStatus;

public interface MarketStatusOutputBoundary {

    void prepareSuccessView(MarketStatusResponseModel responseModel);

    void prepareFailView(String errorMessage);
}
