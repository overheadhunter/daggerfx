package daggerfx;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

@FxAppScoped
public class CoffeeMakerController {

	private final Heater heater;
	private final Pump pump;

	@FXML
	private Label result;

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	@Inject
	CoffeeMakerController(Heater heater, Pump pump) {
		this.heater = heater;
		this.pump = pump;
	}

	public void initialize() {
		System.out.println("url: " + location + ", rb: " + resources);
	}

	public void brew(ActionEvent actionEvent) {
		heater.on();
		pump.pump();
		result.setText(resources.getString("success"));
		heater.off();
	}

}
