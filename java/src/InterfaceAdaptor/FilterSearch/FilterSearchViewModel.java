package InterfaceAdaptor.FilterSearch;

import InterfaceAdaptor.ViewModel;

/**
 * The View Model for the Filter Search View.
 */
public class FilterSearchViewModel extends ViewModel<FilterSearchState> {

    public FilterSearchViewModel() {
        super("Filter Search");
        setState(new FilterSearchState());
    }

}

