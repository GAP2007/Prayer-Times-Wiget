module com.gap.widgets3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.jsoup;
    opens com.gap.widgets3 to javafx.fxml;
    exports com.gap.widgets3;
}