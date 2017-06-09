package com.minscapecomputing.infowindow.fragments;

import com.github.chrisbanes.photoview.PhotoView;
import com.minscapecomputing.infowindow.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by Arun on 03-10-2016.
 */
public class ImageViewFragment extends android.support.v4.app.DialogFragment {

    private Activity activity;
    private Bundle bundle;

    private ImageView close;
    private PhotoView imageView;
    private int url;

    public ImageViewFragment() {
    }

    public static ImageViewFragment newInstance(Bundle args) {
        ImageViewFragment fragment = new ImageViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(ImageViewFragment.STYLE_NO_TITLE, R.style.AppDialogTheme);
        activity = getActivity();
        if (getArguments() != null) {
            bundle = getArguments();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.full_image_layout, container, false);

        init(rootView);
        setListener();
        if (url != 0) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(url);
        }

        return rootView;
    }

    private void setListener() {

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void init(View rootView) {

        close = (ImageView) rootView.findViewById(R.id.close);
        imageView = (PhotoView) rootView.findViewById(R.id.imageView);

        if (bundle.containsKey("image")) {
            url = bundle.getInt("image");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getDialog().getWindow() == null)
            return;

        try {
            Window window = getDialog().getWindow();
            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            window.setGravity(Gravity.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}