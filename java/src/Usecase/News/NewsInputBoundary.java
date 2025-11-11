package Usecase.News;


public interface NewsInputBoundary {
    void executeMarketNews(NewsRequestModel requestModel);

    void executeCompanyNews(NewsRequestModel requestModel);
}
