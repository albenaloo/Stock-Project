package InterfaceAdaptor.FilterSearch;

/**
 * The state for the Filter Search View Model.
 */
public class FilterSearchState {
    private String exchange = "";
    private String filterSearchError;
    private String mic = "";

    public String getUsername() {
        return exchange;
    }

    public String getFilterSearchError() {
        return filterSearchError;
    }

    public String getMic() {
        return mic;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setFilterSearchError(String filterSearchError) {
        this.filterSearchError = filterSearchError;
    }

}

