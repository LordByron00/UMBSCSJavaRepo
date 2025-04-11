module Java.Repository {
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.media;
    requires forms.rt;
    requires junit4;
    requires javafx.controls; // Add other required modules here
    exports com.example;      // Export the package
}