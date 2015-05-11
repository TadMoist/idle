import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Property {
    static StringProperty sissetulekProperty = new StringProperty() {
        @Override
        public String get() {
            return null;
        }

        @Override
        public void bind(ObservableValue<? extends String> observable) {

        }

        @Override
        public void unbind() {

        }

        @Override
        public boolean isBound() {
            return false;
        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void addListener(ChangeListener<? super String> listener) {

        }

        @Override
        public void removeListener(ChangeListener<? super String> listener) {

        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }

        @Override
        public void set(String value) {

        }


    };

}


