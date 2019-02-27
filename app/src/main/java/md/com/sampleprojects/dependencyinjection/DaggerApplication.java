package md.com.sampleprojects.dependencyinjection;

import android.app.Application;

public class DaggerApplication extends Application {
    private DaggerComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component=DaggerDaggerComponent.builder().daggerModule(new DaggerModule(this)).build();
    }


    public DaggerComponent getComponent()
    {
        return component;
    }
}
