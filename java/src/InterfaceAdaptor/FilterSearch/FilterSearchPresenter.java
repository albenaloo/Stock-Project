package InterfaceAdaptor.FilterSearch;

import InterfaceAdapter.ViewManagerModel;
import InterfaceAdapter.FilterSearch.FilterSearchState;
import InterfaceAdapter.FilterSearch.FilterSearchViewModel;
import Usecase.FilterSearch.FilterSearchOutputBoundary;
import Usecase.FilterSearch.FilterSearchOutputData;

/**
 * The Presenter for the Login Use Case.
 */

public class FilterSearchPresenter implements FilterSearchOutputBoundary {
    private final FilterSearchViewModel FilterSearchViewModel;
    private final ViewManagerModel viewManagerModel;
}