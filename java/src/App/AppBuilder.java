package App;

import DataAccess.FileUserDataAcessObject;
import Entity.UserFactory;
import InterfaceAdapter.ViewManagerModel;
import InterfaceAdapter.logged_in.ChangePasswordController;
import InterfaceAdapter.logged_in.ChangePasswordPresenter;
import InterfaceAdapter.logged_in.LoggedInViewModel;
import InterfaceAdapter.login.LoginController;
import InterfaceAdapter.login.LoginPresenter;
import InterfaceAdapter.login.LoginViewModel;
import InterfaceAdapter.logout.LogoutController;
import InterfaceAdapter.logout.LogoutPresenter;
import InterfaceAdapter.signup.SignupController;
import InterfaceAdapter.signup.SignupPresenter;
import InterfaceAdapter.signup.SignupViewModel;
import Usecase.change_password.ChangePasswordInputBoundary;
import Usecase.change_password.ChangePasswordInteractor;
import Usecase.change_password.ChangePasswordOutputBoundary;
import Usecase.login.LoginInputBoundary;
import Usecase.login.LoginInteractor;
import Usecase.login.LoginOutpuIBoundary;
import Usecase.logout.LogoutInputBoundary;
import Usecase.logout.LogoutInteractor;
import Usecase.logout.LogoutOutputBoundary;
import Usecase.signup.SignupInputBoundary;
import Usecase.signup.SignupInteractor;
import Usecase.signup.SignupOutputBoundary;
import View.LoggedInView;
import View.LoginView;
import View.SignupView;
import View.ViewManager;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    final UserFactory userFactory = new UserFactory();
    final ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);
}