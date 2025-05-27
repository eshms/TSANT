module TSANT {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example.tsant.Controller to javafx.fxml;
    opens org.example.tsant.Model to javafx.fxml;

    exports org.example.tsant.Controller;
    exports org.example.tsant.Model;
}
