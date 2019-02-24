package md.com.sampleprojects.fragments;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import javax.inject.Inject;

import md.com.sampleprojects.DependencyInjection.DaggerApplication;
import md.com.sampleprojects.DependencyInjection.DaggerComponent;
import md.com.sampleprojects.DependencyInjection.DaggerModel;
import md.com.sampleprojects.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DaggerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DaggerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Inject
    DaggerModel myString;
    public DaggerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DaggerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DaggerFragment newInstance(String param1, String param2) {
        DaggerFragment fragment = new DaggerFragment();
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
    public void onAttach(Context context) {
        ((DaggerApplication)context.getApplicationContext()).getComponent().inject(this);
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dagger, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TextView textView=getActivity().findViewById(R.id.textViewDagger);
        final TextView textView2 =getActivity().findViewById(R.id.textView8);
        textView2.setAlpha(0);
        textView.setAlpha(0);
        new MaterialDialog.Builder(getContext()).title("Enter any string:").input(null,null , false, new MaterialDialog.InputCallback() {
            @Override
            public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                myString.setMyString(input.toString());
            }
        }).canceledOnTouchOutside(false).onAny(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                Toast.makeText(getContext(),"Dependency Injected",Toast.LENGTH_SHORT).show();
                textView.animate().alpha(1).setDuration(Toast.LENGTH_LONG);
                textView.setText("You entered "+ myString.getMyString());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView2.animate().alpha(1).setDuration(2000);

                    }
                },2500);

            }
        }).show();

    }

}
