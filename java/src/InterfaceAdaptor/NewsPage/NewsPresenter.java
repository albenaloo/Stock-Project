package InterfaceAdaptor.NewsPage;

import Usecase.News.NewsOutputBoundary;
import Usecase.News.NewsResponseModel;

/**
 * receives output data from interactor
 * writes the data through ViewModel nad then update the state
 */
public class NewsPresenter implements NewsOutputBoundary{
    private final NewsViewModel viewModel;

    public  NewsPresenter(NewsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(NewsResponseModel responseModel) {
        NewsState state = viewModel.getState();
        state.setArticles(responseModel.getArticles());
        state.setErrorMessage(null);
        viewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        NewsState state = viewModel.getState();
        state.setArticles(null);
        state.setErrorMessage(errorMessage);
        viewModel.firePropertyChanged();
    }
}
