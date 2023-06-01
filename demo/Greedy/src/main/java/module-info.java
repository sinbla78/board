module com.example.greedy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.greedy to javafx.fxml;
    exports com.example.greedy;
}