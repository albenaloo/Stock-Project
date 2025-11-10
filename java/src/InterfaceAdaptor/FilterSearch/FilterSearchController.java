package InterfaceAdaptor.FilterSearch;

import Usecase.FilterSearch.FilterSearchInputBoundary;
import Usecase.FilterSearch.FilterSearchInputData;


//The controller for the Filter Search Use Case

public class FilterSearchController {

    private final FilterSearchInputBoundary FilterSearchUseCaseInteractor;

    public FilterSearchController(FilterSearchInputBoundary FilterSearchUseCaseInteractor) {
        this.FilterSearchUseCaseInteractor = FilterSearchUseCaseInteractor;
    }
}