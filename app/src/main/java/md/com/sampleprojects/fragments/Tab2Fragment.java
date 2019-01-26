package md.com.sampleprojects.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import md.com.sampleprojects.ImageViewActivity;
import md.com.sampleprojects.MainActivity;
import md.com.sampleprojects.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Tab2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab2Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static String filename;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Tab2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab2, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StackView stackViewjava, stackViewxml;
        stackViewjava = getActivity().findViewById(R.id.stack_viewjava);
        stackViewjava.setInAnimation(getContext(), android.R.animator.fade_in);
        stackViewjava.setOutAnimation(getContext(), android.R.animator.fade_out);
        stackViewxml = getActivity().findViewById(R.id.stack_viewxml);
        stackViewxml.setInAnimation(getContext(), android.R.animator.fade_in);
        stackViewxml.setOutAnimation(getContext(), android.R.animator.fade_out);
        final StackViewAdapter stackViewAdapterjava = new StackViewAdapter(getContext(), R.layout.item, getStoresJava());
        final StackViewAdapter stackViewAdapterxml = new StackViewAdapter(getContext(), R.layout.item, getStoresXML());
        stackViewjava.setAdapter(stackViewAdapterjava);
        stackViewxml.setAdapter(stackViewAdapterxml);
        stackViewjava.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ImageViewActivity.class);
                filename=stackViewAdapterjava.storeLists.get(position);
                startActivity(intent);
            }
        });
        stackViewxml.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ImageViewActivity.class);
                filename=stackViewAdapterxml.storeLists.get(position);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getStoresJava() {
        ArrayList<String> stores = new ArrayList<String>();
        stores.add("tabview1java");
        stores.add("tabview2java");
        return stores;
    }

    private ArrayList<String> getStoresXML() {
        ArrayList<String> stores = new ArrayList<String>();
        stores.add("tabviewxml1");
        stores.add("tabviewxml2");
        stores.add("tabviewxml3");
        return stores;
    }

    class StackViewAdapter extends ArrayAdapter {
        public  ArrayList<String> storeLists;
        private Context context;
        private int itemLayout;

        public StackViewAdapter(@androidx.annotation.NonNull Context ctx, int resource, @androidx.annotation.NonNull ArrayList<String> objects) {
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
            ImageView imageView=(ImageView)view.findViewById(R.id.imageViewjava);
            int resId=context.getResources().getIdentifier(store,"drawable",context.getPackageName());
            imageView.setImageResource(resId);
            return view;
        }
    }
}