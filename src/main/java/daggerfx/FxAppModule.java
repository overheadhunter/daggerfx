package daggerfx;

import javax.inject.Provider;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Function;

import dagger.Module;
import dagger.Provides;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.util.Callback;

@Module(includes = {FxControllersModule.class})
class FxAppModule {

	@Provides
	@FxAppScoped
	ResourceBundle provideResourceBundle() {
		try {
			return ResourceBundle.getBundle("ui");
		} catch (MissingResourceException e) {
			return ResourceBundle.getBundle("ui", Locale.ENGLISH);
		}
	}

	@Provides
	@FxAppScoped
	Callback<Class<?>, Object> provideControllerFactory(Map<Class<?>, Provider<Object>> providers) {
		return clazz -> {
			Provider<?> provider = providers.get(clazz);
			if (provider == null) {
				throw new UncheckedIOException(new LoadException("Controller not registered for class: " + clazz.getName()));
			}
			Object controller = provider.get();
			if (!clazz.isInstance(controller)) {
				throw new UncheckedIOException(new LoadException("Registered controller not instance of class: " + clazz.getName()));
			}
			return controller;
		};
	}

	@Provides
	@FxAppScoped
	Function<URL, FXMLLoader> provideFxmlLoaderFactory(Callback<Class<?>, Object> controllerFactory, ResourceBundle resourceBundle) {
		return url -> {
			FXMLLoader loader = new FXMLLoader(url, resourceBundle);
			loader.setControllerFactory(controllerFactory);
			return loader;
		};
	}
}
