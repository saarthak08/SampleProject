package md.com.sampleprojects.dependencyinjection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {
    Application application;

    @Provides
    @Singleton
    public DaggerModel provideDaggerModel()
    {
        return new DaggerModel();
    }
    public DaggerModule(Application application)
    {
        this.application=application;
    }
    @Provides
    @Singleton
    public Context providesContext()
    {
        return application;
    }
}
