package daggerfx;

import java.net.URL;
import java.util.Objects;
import java.util.function.Function;

import dagger.BindsInstance;
import dagger.Subcomponent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

@FxAppScoped
@Subcomponent(modules = {FxAppModule.class})
interface FxAppComponent {

	Function<URL, FXMLLoader> fxmlLoaderFactory();

	default FXMLLoader loader(URL fxmlUrl) {
		return fxmlLoaderFactory().apply(Objects.requireNonNull(fxmlUrl));
	}

	@Subcomponent.Builder
	interface Builder {

		@BindsInstance
		Builder application(Application application);

		@BindsInstance
		Builder mainWindow(Stage mainWindow);

		FxAppComponent build();
	}

}
