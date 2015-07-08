package daggerfx;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class CoffeeApp extends Application {

	public static void main(String[] args) throws IOException {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final CoffeeShop coffeeShop = DaggerCoffeeShop.create();
		final CoffeeMakerController ctrl = coffeeShop.coffeeMakerController().get();

		final Stage stage = ctrl.createStage();
		stage.setResizable(false);
		stage.show();
	}

}