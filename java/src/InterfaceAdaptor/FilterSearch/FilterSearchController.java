package interface_adapter.FilterSearch;

import use_case.FilterSearch.FilterSearchInputBoundary;
import use_case.FilterSearch.FilterSearchInputData;


#The controller for the Filter Search Use Case

public class FilterSearchController {

    private final FilterSearchInputBoundary FilterSearchUseCaseInteractor;

    public FilterSearchController(FilterSearchInputBoundary FilterSearchUseCaseInteractor) {
        this.FilterSearchUseCaseInteractor = FilterSearchUseCaseInteractor;
    }
