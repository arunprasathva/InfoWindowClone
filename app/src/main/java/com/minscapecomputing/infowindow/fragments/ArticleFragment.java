package com.minscapecomputing.infowindow.fragments;

import com.minscapecomputing.infowindow.R;
import com.minscapecomputing.infowindow.adapter.PagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleFragment extends Fragment {

    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    private int tabPosition;

    public static ArticleFragment newInstance(Bundle args) {
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("tabPosition")) {
                tabPosition = getArguments().getInt("tabPosition");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.article_fragment, container, false);

        init(view);
        setContent();

        return view;
    }

    private void init(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);
    }

    public void setContent() {

        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), 4, tabPosition);
        viewPager.setAdapter(pagerAdapter);

        circlePageIndicator.setViewPager(viewPager);
        circlePageIndicator.setStrokeColor(Color.GRAY);
        circlePageIndicator.setFillColor(Color.GRAY);
        circlePageIndicator.setRadius(5f);
    }
}
