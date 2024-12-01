module com.example.javafxtp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens metier to javafx.base; // Open the `metier` package to `javafx.base`


    opens com.example.javafxtp to javafx.fxml;
    exports com.example.javafxtp;
}

