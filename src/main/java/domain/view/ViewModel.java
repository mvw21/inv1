package domain.view;

public class ViewModel<T> {
    private  T object;

    public ViewModel(T object) {
        this.object = object;
    }

    public T getObject() {
        return this.object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
