package daggerfx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CoffeeApp extends Application {

	private static final CoffeeComponent LAUNCHER = DaggerCoffeeComponent.create();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		FxAppComponent fxApp = LAUNCHER.fxApp() //
				.application(this) //
				.mainWindow(primaryStage) //
				.build();

		FXMLLoader loader  = fxApp.loader(getClass().getResource("/main.fxml"));
		Parent root = loader.load();

		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}