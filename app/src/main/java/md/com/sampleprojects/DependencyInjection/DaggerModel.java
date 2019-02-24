package md.com.sampleprojects.DependencyInjection;

import android.widget.TextView;

import javax.inject.Inject;

public class DaggerModel {
    private String myString;

    @Inject
    public DaggerModel(String myString){
        this.myString=myString;     //Model needs the injection
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}
