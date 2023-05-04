module com.mycompany.finalprojectcsc211 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.finalprojectcsc211 to javafx.fxml;
    exports com.mycompany.finalprojectcsc211;
}
