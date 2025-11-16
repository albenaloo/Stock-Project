package InterfaceAdaptor.NewsPage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NewsViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final NewsState state = new NewsState();

    public NewsState getState() {
        return state;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void firePropertyChanged() {
        // property name "state" is arbitrary but consistent
        support.firePropertyChange("state", null, state);
    }
}
