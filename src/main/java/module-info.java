module com.example.pms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.pms to javafx.fxml;
    exports com.example.pms;
}