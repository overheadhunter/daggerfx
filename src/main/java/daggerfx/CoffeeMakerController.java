package daggerfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.inject.Inject;

class CoffeeMakerController extends AbstractFXMLViewController {

	private final Heater heater; // Create a possibly costly heater only when we use it.
	private final Pump pump;

	@FXML
	private Label result;

	@Inject
	CoffeeMakerController(Heater heater, Pump pump) {
		this.heater = heater;
		this.pump = pump;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@Override
	protected URL getFxmlResourceUrl() {
		return getClass().getResource("/main.fxml");
	}

	@Override
	protected ResourceBundle getFxmlResourceBundle() {
		return null;
	}

	@FXML
	public void brew() {
		heater.on();
		pump.pump();
		result.setText(" [_]P coffee! [_]P");
		heater.off();
	}

}
