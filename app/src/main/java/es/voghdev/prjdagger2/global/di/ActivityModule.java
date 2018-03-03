package es.voghdev.prjdagger2.global.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import es.voghdev.prjdagger2.ui.activity.UserListActivity;

@Module(subcomponents = ActivityModule.UserActivitySubcomponent.class)
public abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(UserListActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindUserActivityInjectorFactor(UserActivitySubcomponent.Builder builder);

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract UserListActivity contributeUserListActivityInjector();

    public interface UserActivitySubcomponent extends AndroidInjector<UserListActivity> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<UserListActivity> {
        }
    }
}
