module jareed.demo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens jareed.demo2 to javafx.fxml;
    exports jareed.demo2;
    exports jareed.demo2.controllers;
    opens jareed.demo2.controllers to javafx.fxml;
}