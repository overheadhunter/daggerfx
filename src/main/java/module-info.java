module daggerfx {
	requires dagger;
	requires javax.inject;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens daggerfx to javafx.fxml, javafx.graphics;
}