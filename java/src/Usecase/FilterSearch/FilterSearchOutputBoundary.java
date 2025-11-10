package Usecase.FilterSearch;

/**
 * The output boundary for the Filter Search Use Case.
 */
public interface FilterSearchOutputBoundary {
    /**
     * Prepares the success view for the Filter Search Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(FilterSearchOutputData outputData);

    /**
     * Prepares the failure view for the Filter Search Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    void switchToMainView();
}

