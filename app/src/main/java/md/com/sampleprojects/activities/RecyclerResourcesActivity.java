package md.com.sampleprojects.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import md.com.sampleprojects.R;

import static md.com.sampleprojects.fragments.Tab2Fragment.filename;

public class RecyclerResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_resources);
        StackView stackViewjava, stackViewxml;
        stackViewjava = findViewById(R.id.stack_viewjava);
        stackViewjava.setInAnimation(this, android.R.animator.fade_in);
        stackViewjava.setOutAnimation(this, android.R.animator.fade_out);
        stackViewxml =findViewById(R.id.stack_viewxml);
        stackViewxml.setInAnimation(this, android.R.animator.fade_in);
        stackViewxml.setOutAnimation(this, android.R.animator.fade_out);
        final StackViewAdapter stackViewAdapterjava = new StackViewAdapter(this, R.layout.item, getStoresJava());
        final StackViewAdapter stackViewAdapterxml = new StackViewAdapter(this, R.layout.item, getStoresXML());
        stackViewjava.setAdapter(stackViewAdapterjava);
        stackViewxml.setAdapter(stackViewAdapterxml);
        stackViewjava.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RecyclerResourcesActivity.this, ImageViewActivity.class);
                filename=stackViewAdapterjava.storeLists.get(position);
                intent.putExtra("filename",filename);
                startActivity(intent);
            }
        });
        stackViewxml.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RecyclerResourcesActivity.this, ImageViewActivity.class);
                filename=stackViewAdapterxml.storeLists.get(position);
                intent.putExtra("filename",filename);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getStoresJava() {
        ArrayList<String> stores = new ArrayList<String>();
        stores.add("rjava1");
        stores.add("rjava2");
        stores.add("rjava3");
        stores.add("rjava4");
        stores.add("rjava5");
        stores.add("rjava6");
        return stores;
    }

    private ArrayList<String> getStoresXML() {
        ArrayList<String> stores = new ArrayList<String>();
        stores.add("rxml1");
        stores.add("rxml2");
        stores.add("rxml3");
        stores.add("rxml4");
        stores.add("rxml5");
        stores.add("rxml6");
        stores.add("rxml7");
        stores.add("rxml8");
        return stores;
    }
    class StackViewAdapter extends ArrayAdapter {
        public  ArrayList<String> storeLists;
        private Context context;
        private int itemLayout;
        public StackViewAdapter( Context ctx, int resource, ArrayList<String> objects) {
            super(ctx, resource, objects);
            storeLists= objects;
            context=ctx;
            itemLayout=resource;
        }
        @Override
        public int getCount()
        {
            return storeLists.size();
        }
        @Override
        public String getItem(int position)
        {
            return storeLists.get(position);
        }
        @Override
        public View getView(int position, View view, @NonNull ViewGroup parent)
        {
            if(view==null)
            {
                view=LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
            }
            String store=storeLists.get(position);
            ImageView imageView=view.findViewById(R.id.imageViewjava);
            int resId=context.getResources().getIdentifier(store,"drawable",context.getPackageName());
            Glide.with(getContext()).load(resId).into(imageView);
            imageView.setImageResource(resId);
            return view;
        }
    }
}

