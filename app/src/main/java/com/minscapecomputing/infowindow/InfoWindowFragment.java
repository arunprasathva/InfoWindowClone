package com.minscapecomputing.infowindow;

import com.minscapecomputing.infowindow.fragments.ArticleFragment;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class InfoWindowFragment extends Fragment {

    private Activity activity;
    private ArrayList<String> list;

    private Bundle bundle;
    private FrameLayout container;
    private TabLayout tabLayout;

    private OnInfoWindowClosed onInfoWindowClosed;

    public InfoWindowFragment() {
    }

    public static InfoWindowFragment newInstance(Bundle args) {
        InfoWindowFragment fragment = new InfoWindowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();

        if (getArguments() != null) {
            bundle = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_fullview, container, false);

        init(rootView);
        if (bundle != null) {
            list = bundle.getStringArrayList("list");
            populateData();
        }

        setListener(rootView);

        return rootView;
    }

    private void setListener(View view) {

        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    private void populateData() {

        tabLayout.addTab(tabLayout.newTab().setText("TECH SPECS"));
        tabLayout.addTab(tabLayout.newTab().setText("REVIEWS"));
        tabLayout.addTab(tabLayout.newTab().setText("SERVICES"));
        tabLayout.addTab(tabLayout.newTab().setText("NEWS"));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ArticleFragment articleFragment = ArticleFragment.newInstance(bundle);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, articleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void changeTab(int tabPosition) {

        bundle.putInt("tabPosition", tabPosition);
        ArticleFragment articleFragment = ArticleFragment.newInstance(bundle);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, articleFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void init(View rootView) {

        container = (FrameLayout) rootView.findViewById(R.id.container);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
    }

    private String optString(Bundle b, String key) {
        if (b.containsKey(key)) return b.getString(key);
        return "";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (onInfoWindowClosed != null) onInfoWindowClosed.closed();
    }

    public void setOnInfoWindowClosed(OnInfoWindowClosed onInfoWindowClosed) {
        this.onInfoWindowClosed = onInfoWindowClosed;
    }

    public interface OnInfoWindowClosed {
        void closed();
    }
}