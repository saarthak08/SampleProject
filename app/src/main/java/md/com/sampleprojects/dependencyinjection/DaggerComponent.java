package md.com.sampleprojects.dependencyinjection;

import javax.inject.Singleton;

import dagger.Component;
import md.com.sampleprojects.fragments.DaggerFragment;

@Singleton
@Component(modules = DaggerModule.class)
public interface DaggerComponent {
    void inject(DaggerFragment fragment);
}
