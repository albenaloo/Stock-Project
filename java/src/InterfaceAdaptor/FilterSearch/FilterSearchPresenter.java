package InterfaceAdaptor.FilterSearch;

import InterfaceAdaptor.signup.ViewManagerModel;
import InterfaceAdaptor.FilterSearch.FilterSearchState;
import InterfaceAdaptor.FilterSearch.FilterSearchViewModel;
import Usecase.FilterSearch.FilterSearchOutputBoundary;
import Usecase.FilterSearch.FilterSearchOutputData;

/**
 * The Presenter for the Login Use Case.
 */

public class FilterSearchPresenter implements FilterSearchOutputBoundary {
    private final FilterSearchViewModel filterSearchViewModel;
    private final ViewManagerModel viewManagerModel;

    @Override
    public void prepareSuccessView(FilterSearchOutputData response) {
        // On success, update the filterSearchViewModel's state
        final FilterSearchState filterSearchState = filterSearchViewModel.getState();
        this.filterSearchViewModel.firePropertyChange();

        // and clear everything from the FilterSearchViewModel's state
        filterSearchViewModel.setState(new FilterSearchState());

        // switch to the filter search view
        this.viewManagerModel.setState(filterSearchViewModel.getViewName());
        this.viewManagerModel.firePropertyChange();
    }

    @Override
    public void prepareFailView(String error) {
        final FilterSearchState filterSearchState = filterSearchViewModel.getState();
        filterSearchState.setFilterSearchError(error);
        filterSearchViewModel.firePropertyChange();
    }

    @Override
    public void switchToMainView() {

    }
}