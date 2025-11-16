package Usecase.ViewStockDetails;

import Entity.NewsArticle;

public interface MarketDataProvider {
    Quote fetchQuote(StockId id) throws MarketDataException;
    TickerDetails fetchDetails(StockId id) throws MarketDataException;
    List<NewsArticle> companyNews(StockId id) throws MarketDataException;
}


