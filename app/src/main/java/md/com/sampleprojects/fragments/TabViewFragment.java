package md.com.sampleprojects.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import md.com.sampleprojects.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabViewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TabViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabViewFragment newInstance(String param1, String param2) {
        TabViewFragment fragment = new TabViewFragment();
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
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_view, container, false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        final TabLayout tabLayout=getActivity().findViewById(R.id.tabs);
        ViewPager viewPager=getActivity().findViewById(R.id.view_pager);
        CustomPagerAdapter customPagerAdapter=new CustomPagerAdapter(getChildFragmentManager());
        customPagerAdapter.addFragment(new Tab1Fragment(),"Text");
        customPagerAdapter.addFragment(new Tab2Fragment(),"Resources");
        viewPager.setAdapter(customPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

class CustomPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mFragments=new ArrayList<>();
    ArrayList<String> mStrings=new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void addFragment(Fragment fragment, String title)
    {
        mFragments.add(fragment);
        mStrings.add(title);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    public CharSequence getPageTitle(int position)
    {
        return mStrings.get(position);
    }
}

