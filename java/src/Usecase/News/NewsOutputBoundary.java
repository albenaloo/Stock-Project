package Usecase.News;

public interface NewsOutputBoundary {
    void prepareSuccessView(NewsResponseModel responseModel);

    void prepareFailView(String errorMessage);
}
