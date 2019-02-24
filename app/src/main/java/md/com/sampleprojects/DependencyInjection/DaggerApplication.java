package md.com.sampleprojects.DependencyInjection;

import android.app.Application;

public class DaggerApplication extends Application {
    private DaggerComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component=DaggerDaggerComponent.builder().daggerModule(new DaggerModule()).build();
    }


    public DaggerComponent getComponent()
    {
        return component;
    }
}
