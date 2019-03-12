package daggerfx;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
abstract class FxControllersModule {

	@Binds
	@IntoMap
	@ClassKey(CoffeeMakerController.class)
	abstract Object bindCoffeeMakerController(CoffeeMakerController ctrl);

}
