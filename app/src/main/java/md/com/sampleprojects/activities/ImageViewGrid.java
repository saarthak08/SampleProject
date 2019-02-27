package md.com.sampleprojects.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import md.com.sampleprojects.R;

public class ImageViewGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_grid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView3=findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gjava1");
                startActivity(intent);

            }
        });
        ImageView imageView4=findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gjava2");
                startActivity(intent);

            }
        }); ImageView imageView5=findViewById(R.id.imageView5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gjava3");
                startActivity(intent);

            }
        }); ImageView imageView6=findViewById(R.id.imageView6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gxml1");
                startActivity(intent);

            }
        }); ImageView imageView7=findViewById(R.id.imageView7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gxml2");
                startActivity(intent);

            }
        }); ImageView imageView8=findViewById(R.id.imageView8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gxml3");
                startActivity(intent);

            }
        }); ImageView imageView9=findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageViewGrid.this,ImageViewActivity.class);
                intent.putExtra("filename","gxml4");
                startActivity(intent);

            }
        });
    }

}
