package md.com.sampleprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jsibbold.zoomage.ZoomageView;

import md.com.sampleprojects.fragments.Tab2Fragment;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_view);
        ZoomageView zoomageView=findViewById(R.id.myZoomageView);
        Bundle bundle=getIntent().getExtras();
        String s= bundle.getString("filename");
        int resId=this.getResources().getIdentifier(s,"drawable",this.getPackageName());
        zoomageView.setImageResource(resId);
    }
}
