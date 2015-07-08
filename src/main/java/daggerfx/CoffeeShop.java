package daggerfx;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DripCoffeeModule.class)
interface CoffeeShop {
	Provider<CoffeeMakerController> coffeeMakerController();
}