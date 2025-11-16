package Usecase.News;

import Entity.NewsArticle;
import java.util.List;

public interface NewsDataAccessInterface {

    // /news?category=general
    List<NewsArticle> loadMarketNews() throws Exception;

    // /company-news?symbol=...&from=...&to=...
    List<NewsArticle> loadCompanyNews(String symbol,
                                      String fromDate,
                                      String toDate) throws Exception;
}