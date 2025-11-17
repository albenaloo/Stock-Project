package View;

import InterfaceAdaptor.Dashboard.DashboardController;
import InterfaceAdaptor.Dashboard.DashboardViewModel;
import InterfaceAdaptor.Dashboard.DashboardState; // If ViewModel needs it
import InterfaceAdaptor.ViewManagerModel; // If managing sub-views directly from here

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashboardView extends JPanel implements PropertyChangeListener { // Extends JPanel to be embeddable

    public final String viewName = "dashboard"; // Unique identifier for this view

    private DashboardViewModel dashboardViewModel;
    private DashboardController dashboardController;
    private ViewManagerModel viewManagerModel; // If you need to switch views from here

    // UI Components (will be initialized in the constructor)
    private JTextField searchInputField;
    private JButton searchButton;
    private JButton accountButton;
    private JPanel newsPanel; // This will hold your NewsView
    private JButton filterSearchButton;
    private JButton marketStatusButton;
    private JButton historyButton;
    private JPanel mainContentPanel; // This will hold Search Results, Watchlist, etc.
    private CardLayout cardLayout; // To switch between different main content areas (Search Results, Watchlist)

    // Sub-views (already existing)
    private CompanyEarningView companyEarningView;
    private FilterView filterView;
    private NewsView newsView;
    private WatchlistView watchlistView;
    // private SearchingStockView searchingStockView; // You might need a specific view for search results display

    public DashboardView(DashboardViewModel dashboardViewModel,
                         DashboardController dashboardController,
                         ViewManagerModel viewManagerModel, // Pass this if needed for navigation
                         CompanyEarningView companyEarningView, // Pass existing views here
                         FilterView filterView,
                         NewsView newsView,
                         WatchlistView watchlistView
            /*, ... other sub-views */) {
        this.dashboardViewModel = dashboardViewModel;
        this.dashboardController = dashboardController;
        this.viewManagerModel = viewManagerModel; // Assign
        this.companyEarningView = companyEarningView;
        this.filterView = filterView;
        this.newsView = newsView;
        this.watchlistView = watchlistView;

        this.dashboardViewModel.addPropertyChangeListener(this); // Listen for changes from ViewModel

        // --- 1. Set up the main layout ---
        this.setLayout(new BorderLayout()); // Main layout for the dashboard

        // --- 2. Create and add Top Panel (NORTH) ---
        JPanel topPanel = createTopPanel();
        this.add(topPanel, BorderLayout.NORTH);

        // --- 3. Create and add Left Panel (WEST) ---
        JPanel leftPanel = createLeftPanel();
        this.add(leftPanel, BorderLayout.WEST);

        // --- 4. Create and add Main Content Panel (CENTER) ---
        this.mainContentPanel = createMainContentPanel();
        this.add(this.mainContentPanel, BorderLayout.CENTER);

        // --- Optional: Add a status bar (SOUTH) ---
        // JPanel statusBar = createStatusBar();
        // this.add(statusBar, BorderLayout.SOUTH);

        // --- Initial state (e.g., show watchlist by default) ---
        // this.cardLayout.show(mainContentPanel, "Watchlist"); // Example

        // // Initial update from ViewModel
        // updateView(dashboardViewModel.getState()); // If you have an initial state to render
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout for left alignment
        panel.setPreferredSize(new Dimension(this.getWidth(), 60)); // Fixed height for header
        panel.setBackground(Color.LIGHT_GRAY); // Example background

        // Your sketch shows "Name [P]"
        JLabel userNameLabel = new JLabel("Welcome, [User Name]");
        userNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(userNameLabel);

        // Search Bar
        this.searchInputField = new JTextField(20);
        panel.add(searchInputField);

        this.searchButton = new JButton("Search");
        panel.add(searchButton);
        searchButton.addActionListener(e -> dashboardController.executeSearch(searchInputField.getText())); // Connect to controller

        // Account Button
        this.accountButton = new JButton("Account");
        panel.add(accountButton);
        accountButton.addActionListener(e -> {
            // Handle account button click, e.g., show account view
            // viewManagerModel.setActiveView("accountView"); // Example
        });

        // --- Your Name [P] for profile, and account button are separate ---
        // You might want to use a more complex layout like BorderLayout or GridBagLayout within the topPanel
        // For example:
        // JPanel topPanel = new JPanel(new BorderLayout());
        // JPanel leftTop = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For Name [P]
        // JPanel centerTop = new JPanel(new FlowLayout(FlowLayout.CENTER)); // For search bar
        // JPanel rightTop = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // For account button
        // panel.add(leftTop, BorderLayout.WEST);
        // panel.add(centerTop, BorderLayout.CENTER);
        // panel.add(rightTop, BorderLayout.EAST);

        return panel;
    }

    private JPanel createLeftPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Stack components vertically
        panel.setPreferredSize(new Dimension(200, this.getHeight())); // Fixed width for left panel
        panel.setBackground(Color.DARK_GRAY); // Example background

        // News Section (Embed your existing NewsView here)
        panel.add(new JLabel("News:"));
        // newsPanel = new JPanel(); // Placeholder for NewsView
        // newsPanel.add(new JTextArea("Recent News Articles..."));
        // panel.add(newsPanel);
        panel.add(newsView); // Assuming NewsView extends JPanel and is ready to be embedded

        // Buttons
        this.filterSearchButton = new JButton("Filter Search");
        panel.add(filterSearchButton);
        filterSearchButton.addActionListener(e -> {
            // Call controller method or switch main content panel to filter view
            this.cardLayout.show(mainContentPanel, "Filter"); // Example
        });

        this.marketStatusButton = new JButton("Market Status");
        panel.add(marketStatusButton);
        marketStatusButton.addActionListener(e -> {
            // Call controller method or switch main content panel to market status view
            this.cardLayout.show(mainContentPanel, "CompanyEarnings"); // Example for your CompanyEarningView
        });

        this.historyButton = new JButton("History");
        panel.add(historyButton);
        historyButton.addActionListener(e -> {
            // Call controller method or switch main content panel to history view
            // this.cardLayout.show(mainContentPanel, "History"); // If you create a HistoryView
        });

        // Add some rigid area for spacing
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        return panel;
    }

    private JPanel createMainContentPanel() {
        JPanel panel = new JPanel();
        this.cardLayout = new CardLayout(); // Use CardLayout to switch main content
        panel.setLayout(cardLayout);

        // --- Embed your existing views here ---
        // You will add each major content area as a "card" to this panel
        // For search results:
        // You might need a dedicated SearchResultsView or embed a component to show results
        // panel.add(new JPanel().add(new JLabel("Search Results will go here")), "SearchResults");

        panel.add(watchlistView, "Watchlist"); // The WatchlistView
        panel.add(filterView, "Filter");       // The FilterView
        panel.add(companyEarningView, "CompanyEarnings"); // The CompanyEarningView
        // panel.add(newsView, "News"); // If you also want News as a main content panel, not just in left.

        // Set an initial view to show
        cardLayout.show(panel, "Watchlist"); // Default to show Watchlist

        return panel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // This method is called when the DashboardViewModel notifies of a change
        if (evt.getPropertyName().equals("state")) {
            DashboardState state = (DashboardState) evt.getNewValue();
            // Update UI based on new state
            // e.g., if(state.isShowingSearchResults()) { cardLayout.show(mainContentPanel, "SearchResults"); }
            // updateUserNameLabel(state.getUserName());
            // updateSearchResults(state.getSearchResults()); // You'd need a method to update your search results panel
        } else if (evt.getPropertyName().equals("activeView")) {
            String activeViewName = (String) evt.getNewValue();
            this.cardLayout.show(mainContentPanel, activeViewName);
        }
        // Add more conditions for other properties in your ViewModel
    }
}