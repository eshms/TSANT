module org.example.tsant {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tsant to javafx.fxml;
    exports org.example.tsant;
}