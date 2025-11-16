package InterfaceAdaptor.NewsPage;

import Entity.NewsArticle;
import java.util.List;

/**
 * Store what the NewsView should currently display
 */
public class NewsState {
    private List<NewsArticle> articles;
    private String errorMessage;

    public List<NewsArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticle> articles) {
        this.articles = articles;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
