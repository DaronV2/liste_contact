module fr.daron.louis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    opens fr.daron.louis to javafx.fxml;
    exports fr.daron.louis;
}
