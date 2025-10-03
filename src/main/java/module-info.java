module com.example.pets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pets to javafx.fxml;
    exports com.example.pets;
    exports com.example.pets.controller;
    opens com.example.pets.controller to javafx.fxml;
}