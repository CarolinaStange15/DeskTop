module com.exemple.pets {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;


    opens com.example.pets to javafx.fxml;
    opens com.example.pets.model to org.hibernate.orm.core;
    exports com.example.pets;
    exports com.example.pets.controller;
    opens com.example.pets.controller to javafx.fxml;
}