package es.voghdev.prjdagger2.global.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import es.voghdev.prjdagger2.ui.activity.UserListActivity;

// TODO 1: Merge UserListModule and MainModule into one, with all deps provided
// TODO 2: Wire everything and make it run succesfully
// TODO 3: Try to replace injections in Espresso tests

@Module(subcomponents = ActivityModule.UserActivitySubcomponent.class)
public abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(UserListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindUserActivityInjectorFactor(UserActivitySubcomponent.Builder builder);

//    @ContributesAndroidInjector(modules = MainModule.class)
//    abstract UserListActivity contributeUserListActivityInjector();

    @Subcomponent(modules = MainModule.class)
    public interface UserActivitySubcomponent extends AndroidInjector<UserListActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<UserListActivity> {
        }
    }
}
