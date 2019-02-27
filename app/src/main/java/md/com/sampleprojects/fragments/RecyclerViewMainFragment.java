package md.com.sampleprojects.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import md.com.sampleprojects.R;
import md.com.sampleprojects.activities.RecyclerResourcesActivity;
import md.com.sampleprojects.adapter.TopicsAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewMainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public RecyclerViewMainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewMainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewMainFragment newInstance(String param1, String param2) {
        RecyclerViewMainFragment fragment = new RecyclerViewMainFragment();
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
        return inflater.inflate(R.layout.fragment_recycler_view_main, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView=getActivity().findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        final ArrayList<String> arraylist;
        arraylist=new ArrayList<>(100);
        arraylist.add("Item 1");
        arraylist.add("Item 2");
        arraylist.add("Item 3");
        TopicsAdapter topicsAdapter = new TopicsAdapter(getContext(),arraylist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(topicsAdapter);
        Button button2=getActivity().findViewById(R.id.buttonx);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getContext()).input("Item Name", "Item "+(arraylist.size()+1), false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        arraylist.add(input.toString());
                    }
                }).canceledOnTouchOutside(true).show();
            }
        });

        Button button1=getActivity().findViewById(R.id.buttony);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),RecyclerResourcesActivity.class));
            }
        });
    }
}
