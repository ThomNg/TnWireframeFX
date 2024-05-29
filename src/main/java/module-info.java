module com.example.tnwireframefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tnwireframefx to javafx.fxml;
    exports com.example.tnwireframefx;
}