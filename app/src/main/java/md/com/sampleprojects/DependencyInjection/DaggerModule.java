package md.com.sampleprojects.DependencyInjection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaggerModule {

    @Provides
    @Singleton
    public DaggerModel provideDaggerModel()
    {
        return new DaggerModel();
    }
}
