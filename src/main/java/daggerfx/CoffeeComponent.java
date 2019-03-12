package daggerfx;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DripCoffeeModule.class})
interface CoffeeComponent {

	FxAppComponent.Builder fxApp();

}
