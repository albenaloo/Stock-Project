package Usecase.News;

import Entity.NewsArticle;
import java.util.List;

/**
 * Interface talks to the Finnhub API
 */
public interface NewsDataAccessInterface {

     // Maps to Finnhub endpoint: /news?category=general
    List<NewsArticle> loadMarketNews() throws Exception;

    //Maps to Finnhub endpoint:
    //     /company-news?symbol={symbol}&from={fromDate}&to={toDate}
    //     Dates are "YYYY-MM-DD".
    List<NewsArticle> loadCompanyNews(String symbol,
                                      String fromDate,
                                      String toDate) throws Exception;
}